package com.galandnoah.socapay_api.transaction;

import com.galandnoah.socapay_api.provider.Provider;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransactionRequest(
        @NotNull
        @DecimalMin("0.0")
        BigDecimal amount,

        @NotBlank
        String currency,

        String merchantId,

        @NotNull
        Provider provider
) {


}
