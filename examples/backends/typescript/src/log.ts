/**
 * Three log levels on stderr. A logging library would be the second dependency of a
 * backend whose first and only one is the Meteroid SDK.
 */

function write(level: string, message: string): void {
  process.stderr.write(`${new Date().toISOString()} ${level.padStart(5)} scribe_backend: ${message}\n`);
}

export const log = {
  info: (message: string) => write("INFO", message),
  warn: (message: string) => write("WARN", message),
  error: (message: string) => write("ERROR", message),
};
