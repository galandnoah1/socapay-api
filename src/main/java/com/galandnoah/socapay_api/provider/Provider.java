package com.galandnoah.socapay_api.provider;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum Provider {
    ORANGE_MONEY("orange money"),
    MTN_MOMO("mtn momo"),
    VISA("visa");

    @JsonValue
    private final String value;

    Provider(String value)
    {
        this.value = value;
    }


}
