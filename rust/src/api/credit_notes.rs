// this file is @generated
#[allow(unused_imports)]
use crate::{error::Result, models::*, Configuration};

pub struct CreditNotes<'a> {
    cfg: &'a Configuration,
}

impl<'a> CreditNotes<'a> {
    pub(super) fn new(cfg: &'a Configuration) -> Self {
        Self { cfg }
    }

    pub async fn download_credit_note_pdf(&self, credit_note_id: String) -> Result<bytes::Bytes> {
        crate::request::Request::new(
            http1::Method::GET,
            "/api/v1/credit-notes/{credit_note_id}/download",
        )
        .with_path_param("credit_note_id", credit_note_id)
        .execute_binary(self.cfg)
        .await
    }
}
