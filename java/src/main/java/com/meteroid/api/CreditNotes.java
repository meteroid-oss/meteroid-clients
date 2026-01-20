// this file is @generated
package com.meteroid.api;

import com.meteroid.MeteroidHttpClient;
import com.meteroid.exceptions.ApiException;

import okhttp3.HttpUrl;

import java.io.IOException;

public class CreditNotes {
    private final MeteroidHttpClient client;

    public CreditNotes(MeteroidHttpClient client) {
        this.client = client;
    }

    /** */
    public byte[] downloadCreditNotePdf(final String creditNoteId)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(
                                String.format("/api/v1/credit-notes/%s/download", creditNoteId));
        return this.client.executeBinaryRequest("GET", url.build(), null, null);
    }
}
