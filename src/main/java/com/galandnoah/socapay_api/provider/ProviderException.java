package com.galandnoah.socapay_api.provider;

import lombok.Getter;

@Getter
public class ProviderException extends RuntimeException {
    private String reason;
    public ProviderException(String reason) {
        super(reason);
    }
}
