import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

// `envDir: ".."` makes the SPA read the same `examples/.env` the backends read, so
// `VITE_API_BASE_URL` is one switch for the whole demo. A `.env` inside `frontend/` is ignored.
export default defineConfig({
  plugins: [react()],
  envDir: "..",
  server: { port: 5173 },
});
