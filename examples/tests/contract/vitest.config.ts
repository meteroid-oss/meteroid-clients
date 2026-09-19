import { defineConfig } from 'vitest/config';

export default defineConfig({
  test: {
    include: ['tests/**/*.test.ts'],

    // `BASE_URL` is also Vite's own variable for the app's public base path, and Vitest
    // overwrites `process.env.BASE_URL` with it (`/`) inside the test worker. This config
    // file runs in the parent process, before that happens, so the real value is captured
    // here and forwarded under a name nothing else claims. `BASE_URL` stays the documented
    // knob — see `src/env.ts`, which reads both.
    env: { SCRIBE_BASE_URL: process.env.SCRIBE_BASE_URL ?? process.env.BASE_URL ?? '' },

    // The whole run happens in one worker with one module graph, on purpose. The suite
    // shares a single demo workspace — and therefore a single Meteroid customer — across
    // all files, held in a module-level promise in `src/session.ts`. Isolated or parallel
    // files would each create their own customer and quietly multiply the tenant's data
    // on every run, and the transcription-history assertions would depend on file order.
    pool: 'forks',
    maxWorkers: 1,
    fileParallelism: false,
    isolate: false,
    sequence: { concurrent: false, shuffle: false },

    // These are real HTTP round trips to a backend that itself calls Meteroid, usually
    // twice per request. The default 5s is not enough.
    testTimeout: 60_000,
    hookTimeout: 60_000,

    reporters: ['verbose'],
    passWithNoTests: false,
  },
});
