/**
 * Every Meteroid HTTP call the seed makes, in one file.
 *
 * Plain `fetch` on purpose. The generated SDKs in this repository are built from
 * `spec/openapi.json`, which does not yet carry the catalog writes (`POST /features`,
 * `POST /plan-versions/{id}/entitlements`), so there would be nothing to call. Keeping
 * the requests literal also makes this file readable as documentation: it is the shortest
 * description of what seeding a Meteroid tenant actually involves.
 */

export class MeteroidError extends Error {
  constructor(
    readonly status: number,
    readonly method: string,
    readonly path: string,
    readonly body: string,
  ) {
    super(`${method} ${path} → ${status} ${body}`);
    this.name = 'MeteroidError';
  }
}

export class Meteroid {
  constructor(
    private readonly baseUrl: string,
    private readonly apiKey: string,
  ) {}

  async request<T>(method: string, path: string, body?: unknown): Promise<T> {
    const res = await fetch(`${this.baseUrl}${path}`, {
      method,
      headers: {
        authorization: `Bearer ${this.apiKey}`,
        ...(body === undefined ? {} : { 'content-type': 'application/json' }),
      },
      ...(body === undefined ? {} : { body: JSON.stringify(body) }),
    });
    const text = await res.text();
    if (!res.ok) throw new MeteroidError(res.status, method, path, text);
    return (text === '' ? undefined : JSON.parse(text)) as T;
  }

  get<T>(path: string): Promise<T> {
    return this.request<T>('GET', path);
  }

  post<T>(path: string, body: unknown): Promise<T> {
    return this.request<T>('POST', path, body);
  }

  /**
   * A GET that answers `undefined` on 404 instead of throwing — how every "does this
   * already exist?" probe is written.
   */
  async find<T>(path: string): Promise<T | undefined> {
    try {
      return await this.get<T>(path);
    } catch (err) {
      if (err instanceof MeteroidError && err.status === 404) return undefined;
      throw err;
    }
  }

  /**
   * Walk a paginated list endpoint to the end.
   *
   * The seed narrows client-side rather than trusting `search`, which is a fuzzy match:
   * searching "Scribe" returns all three plans, and searching a metric code returns
   * anything containing it. See CATALOG.md section 5.
   */
  async list<T>(path: string): Promise<T[]> {
    const items: T[] = [];
    const sep = path.includes('?') ? '&' : '?';
    for (let page = 0; ; page++) {
      const res = await this.get<Paginated<T>>(`${path}${sep}page=${page}&per_page=100`);
      items.push(...res.data);
      if (items.length >= res.pagination_meta.total_items || res.data.length === 0) return items;
    }
  }
}

interface Paginated<T> {
  data: T[];
  pagination_meta: { total_items: number };
}
