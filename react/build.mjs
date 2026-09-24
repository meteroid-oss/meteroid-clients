import { execFileSync } from "node:child_process";
import { rmSync, writeFileSync } from "node:fs";
import { createRequire } from "node:module";
import { build } from "esbuild";

rmSync("dist", { recursive: true, force: true });

const shared = {
  entryPoints: ["src/index.ts"],
  bundle: true,
  // react and @meteroid/browser stay imports.
  packages: "external",
  jsx: "automatic",
  target: "es2020",
  sourcemap: true,
  logLevel: "warning",
  // The hooks and components are client components under React Server Components.
  banner: { js: '"use client";' },
};

await Promise.all([
  build({ ...shared, format: "esm", outfile: "dist/index.mjs" }),
  build({ ...shared, format: "cjs", outfile: "dist/index.cjs" }),
]);

const tsc = createRequire(import.meta.url).resolve("typescript/bin/tsc");
execFileSync(process.execPath, [tsc, "-p", "tsconfig.build.json"], { stdio: "inherit" });
// The declarations are CommonJS-flavoured; ESM consumers resolving with
// `node16`/`nodenext` get this ESM entry, which re-exports them.
writeFileSync("dist/index.d.mts", 'export * from "./types/index.js";\n');
