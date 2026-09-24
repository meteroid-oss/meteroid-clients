import { execFileSync } from "node:child_process";
import { rmSync, writeFileSync } from "node:fs";
import { createRequire } from "node:module";
import { build } from "esbuild";

rmSync("dist", { recursive: true, force: true });

const shared = { bundle: true, target: "es2020", sourcemap: true, logLevel: "warning" };

await Promise.all([
  build({
    ...shared,
    entryPoints: ["src/index.ts"],
    format: "esm",
    outfile: "dist/index.mjs",
  }),
  build({
    ...shared,
    entryPoints: ["src/index.ts"],
    format: "cjs",
    outfile: "dist/index.cjs",
  }),
  build({
    ...shared,
    entryPoints: ["src/global.ts"],
    format: "iife",
    minify: true,
    outfile: "dist/meteroid.global.js",
  }),
]);

const tsc = createRequire(import.meta.url).resolve("typescript/bin/tsc");
execFileSync(process.execPath, [tsc, "-p", "tsconfig.build.json"], { stdio: "inherit" });
// The declarations are CommonJS-flavoured; ESM consumers resolving with
// `node16`/`nodenext` get this ESM entry, which re-exports them.
writeFileSync("dist/index.d.mts", 'export * from "./types/index.js";\n');
