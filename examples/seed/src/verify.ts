/**
 * CATALOG.md section 7's checklist, as a PASS/FAIL table.
 *
 * Each item runs against the tenant the seed has just written to, so a green table means
 * the catalog the backends resolve at startup is actually there — not that the seed's
 * POSTs returned 200.
 */

interface Result {
  name: string;
  ok: boolean;
  detail: string;
}

export class Checklist {
  private readonly results: Result[] = [];

  async check(name: string, assertion: () => Promise<void>): Promise<void> {
    try {
      await assertion();
      this.results.push({ name, ok: true, detail: '' });
    } catch (err) {
      this.results.push({ name, ok: false, detail: err instanceof Error ? err.message : String(err) });
    }
  }

  get failed(): number {
    return this.results.filter((r) => !r.ok).length;
  }

  print(): void {
    const width = Math.max(...this.results.map((r) => r.name.length));
    for (const result of this.results) {
      const status = result.ok ? 'PASS' : 'FAIL';
      console.log(`  ${status}  ${result.name.padEnd(width)}${result.ok ? '' : `  ${result.detail}`}`);
    }
    const passed = this.results.length - this.failed;
    console.log(`\n  ${passed}/${this.results.length} checks passed`);
  }
}
