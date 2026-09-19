/**
 * Billing: the customer portal, and the invoices Meteroid has issued.
 *
 * There is no payment-method form, no invoice renderer and no dunning UI in this demo, and that is
 * the point — "Manage billing" mints a short-lived portal token and hands the visitor to Meteroid's
 * own portal, which is a couple of lines of backend code instead of a quarter of product work.
 */
import { useCallback, useState } from "react";
import type { ApiError } from "../api/client";
import type { Invoice, InvoiceStatus } from "../api/types";
import { ErrorNotice } from "../components/ErrorNotice";
import { Panel } from "../components/Panel";
import { formatDate, formatMoney } from "../lib/format";
import { useApp } from "../state/app";
import { useResource } from "../state/useResource";

const STATUS_TONE: Record<InvoiceStatus, string> = {
  DRAFT: "chip",
  FINALIZED: "chip chip-live",
  CLOSED: "chip chip-live",
  UNCOLLECTIBLE: "chip chip-warn",
  VOID: "chip",
};

export function Billing() {
  const { me, openPortal } = useApp();
  const { client } = useApp();
  const load = useCallback(() => client.listInvoices(), [client]);
  const invoices = useResource<Invoice[]>(load, []);

  const [opening, setOpening] = useState(false);
  const [error, setError] = useState<ApiError | null>(null);

  const subscription = me.data?.subscription ?? null;

  async function portal() {
    setOpening(true);
    setError(null);
    try {
      await openPortal();
    } catch (caught) {
      setError(caught as ApiError);
    } finally {
      setOpening(false);
    }
  }

  return (
    <>
      <header className="screen-head">
        <h1 className="screen-title">Billing</h1>
        <p className="screen-sub">
          Payment method, receipts and plan details live in Meteroid&apos;s customer portal. The
          backend mints a short-lived token for this workspace&apos;s customer and the button opens
          it.
        </p>
      </header>

      {error && <ErrorNotice error={error} />}

      <div className="stack">
        <Panel
          eyebrow="subscription"
          title={subscription ? subscription.plan_name : "No subscription"}
          actions={
            <button
              type="button"
              data-testid="manage-billing"
              className="btn btn-primary"
              onClick={() => void portal()}
              disabled={opening}
            >
              {opening && <span className="spin" />}
              Manage billing
            </button>
          }
        >
          {subscription ? (
            <div className="quota-facts">
              <div className="fact">
                <div className="label">status</div>
                <div className="fact-value">{subscription.status}</div>
              </div>
              <div className="fact">
                <div className="label">period</div>
                <div className="fact-value">
                  {formatDate(subscription.current_period_start)}
                  {subscription.current_period_end
                    ? ` → ${formatDate(subscription.current_period_end)}`
                    : " → open"}
                </div>
              </div>
              <div className="fact">
                <div className="label">currency</div>
                <div className="fact-value">{subscription.currency}</div>
              </div>
              {subscription.trial_duration_days !== null && (
                <div className="fact">
                  <div className="label">trial</div>
                  <div className="fact-value">{subscription.trial_duration_days} days</div>
                </div>
              )}
            </div>
          ) : (
            <p className="panel-note">
              This workspace has never checked out. Pick a plan and the subscription, its invoices
              and its entitlements all appear here.
            </p>
          )}
        </Panel>

        <Panel
          eyebrow="invoices"
          title="Issued by Meteroid"
          actions={
            <button type="button" className="btn btn-small btn-quiet" onClick={invoices.reload}>
              {invoices.loading ? <span className="spin" /> : null}
              Refresh
            </button>
          }
          bodyClassName=""
        >
          {invoices.error ? (
            <div className="panel-body">
              <ErrorNotice error={invoices.error} />
            </div>
          ) : invoices.data.length === 0 ? (
            <p className="empty">
              {invoices.loading
                ? "Loading…"
                : "No invoices yet. Meteroid drafts one as soon as the subscription starts."}
            </p>
          ) : (
            <table className="table">
              <thead>
                <tr>
                  <th>Invoice</th>
                  <th>Date</th>
                  <th>Due</th>
                  <th>Status</th>
                  <th className="table-num">Total</th>
                  <th className="table-num">Due now</th>
                </tr>
              </thead>
              <tbody>
                {invoices.data.map((invoice) => (
                  <tr key={invoice.id}>
                    <td className="num">{invoice.invoice_number}</td>
                    <td>{formatDate(invoice.invoice_date)}</td>
                    <td className="mute">
                      {invoice.due_date ? formatDate(invoice.due_date) : "—"}
                    </td>
                    <td>
                      <span className={STATUS_TONE[invoice.status]}>{invoice.status}</span>
                    </td>
                    <td className="table-num">{formatMoney(invoice.total, invoice.currency)}</td>
                    <td className="table-num">
                      {formatMoney(invoice.amount_due, invoice.currency)}
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          )}
        </Panel>
      </div>
    </>
  );
}
