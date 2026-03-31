// this file is @generated
package com.meteroid.api;

import com.meteroid.MeteroidHttpClient;
import com.meteroid.Utils;
import com.meteroid.exceptions.ApiException;
import com.meteroid.models.Coupon;
import com.meteroid.models.CouponListResponse;
import com.meteroid.models.CreateCouponRequest;
import com.meteroid.models.UpdateCouponRequest;

import okhttp3.HttpUrl;

import java.io.IOException;

public class Coupons {
    private final MeteroidHttpClient client;

    public Coupons(MeteroidHttpClient client) {
        this.client = client;
    }

    /** */
    public CouponListResponse listCoupons() throws IOException, ApiException {

        return this.listCoupons(new CouponsListCouponsOptions());
    }

    /** */
    public CouponListResponse listCoupons(final CouponsListCouponsOptions options)
            throws IOException, ApiException {
        HttpUrl.Builder url = this.client.newUrlBuilder().encodedPath("/api/v1/coupons");
        if (options.search != null) {
            url.addQueryParameter("search", options.search);
        }
        if (options.filter != null) {
            url.addQueryParameter("filter", Utils.serializeQueryParam(options.filter));
        }
        if (options.orderBy != null) {
            url.addQueryParameter("order_by", options.orderBy);
        }
        if (options.page != null) {
            url.addQueryParameter("page", Utils.serializeQueryParam(options.page));
        }
        if (options.perPage != null) {
            url.addQueryParameter("per_page", Utils.serializeQueryParam(options.perPage));
        }
        return this.client.executeRequest("GET", url.build(), null, null, CouponListResponse.class);
    }

    /** */
    public Coupon createCoupon(final CreateCouponRequest createCouponRequest)
            throws IOException, ApiException {
        HttpUrl.Builder url = this.client.newUrlBuilder().encodedPath("/api/v1/coupons");
        return this.client.executeRequest(
                "POST", url.build(), null, createCouponRequest, Coupon.class);
    }

    /** */
    public Coupon getCoupon(final String couponId) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/coupons/%s", couponId));
        return this.client.executeRequest("GET", url.build(), null, null, Coupon.class);
    }

    /** */
    public Coupon updateCoupon(final String couponId, final UpdateCouponRequest updateCouponRequest)
            throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/coupons/%s", couponId));
        return this.client.executeRequest(
                "PATCH", url.build(), null, updateCouponRequest, Coupon.class);
    }

    /** */
    public void archiveCoupon(final String couponId) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/coupons/%s/archive", couponId));
        this.client.executeRequest("POST", url.build(), null, null, null);
    }

    /** */
    public void disableCoupon(final String couponId) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/coupons/%s/disable", couponId));
        this.client.executeRequest("POST", url.build(), null, null, null);
    }

    /** */
    public void enableCoupon(final String couponId) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/coupons/%s/enable", couponId));
        this.client.executeRequest("POST", url.build(), null, null, null);
    }

    /** */
    public void unarchiveCoupon(final String couponId) throws IOException, ApiException {
        HttpUrl.Builder url =
                this.client
                        .newUrlBuilder()
                        .encodedPath(String.format("/api/v1/coupons/%s/unarchive", couponId));
        this.client.executeRequest("POST", url.build(), null, null, null);
    }
}
