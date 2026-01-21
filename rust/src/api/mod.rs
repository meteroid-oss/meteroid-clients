// this file is @generated
pub mod client;

mod checkout_sessions;
mod credit_notes;
mod customers;
mod events;
mod invoices;
mod plans;
mod product_families;
mod subscriptions;

pub use self::{
    checkout_sessions::CheckoutSessions,
    client::{Meteroid, MeteroidOptions},
    credit_notes::CreditNotes,
    customers::{Customers, CustomersListCustomersOptions},
    events::Events,
    invoices::{Invoices, InvoicesListInvoicesOptions},
    plans::{Plans, PlansListPlansOptions},
    product_families::{ProductFamilies, ProductFamiliesListProductFamiliesOptions},
    subscriptions::{Subscriptions, SubscriptionsListSubscriptionsOptions},
};
