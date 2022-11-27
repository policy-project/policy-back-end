package com.app.policy.common;

import org.springframework.beans.factory.annotation.Value;

import java.net.URI;

public interface Constants {
    public static final int POLICY_MIN_ID = 100_000_000;
    public static final int POLICY_MAX_ID = 999_999_999;
    public static final int INSURED_MIN_ID = 10_000_000;
    public static final int INSURED_MAX_ID = 99_999_999;
    public static final int PRODUCT_MIN_ID = 100;
    public static final int PRODUCT_MAX_ID = 999;

    public static final String STATUS_CODE = "statusCode";
    public static final String STATUS_DESCRIPTION = "statusDescription";

    public static interface POLICY_API{
        public static final String MAIN = "/policies";
        public static final String POLICY_BY_INSURED = "/insured";
        public static final String POLICY_BY_PRODUCT = "/product";
        public static final String ADD_ALL = "/add/all";
        public static final String POLICY_INSURED = "/dashboard";
        public static final String POLICY_INSURED_QUERY = "/dashboard/query";


    }

    public static interface INSURED_API{
        public static final String MAIN = "/insureds";
        public static final String ADD_ALL = "/add/all";

    }
}
