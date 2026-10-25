package com.galandnoah.socapay_api.transaction;

import com.galandnoah.socapay_api.provider.ProviderException;
import com.galandnoah.socapay_api.provider.ProviderSimulator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final ProviderSimulator providerSimulator;

    public ResponseEntity<Map<String, String>> create(TransactionRequest request)
    {
        String transactionId = UUID.randomUUID().toString();

        try {
            providerSimulator.call(request.provider());

            return ResponseEntity
                    .status(200)
                    .body(Map.of(
                            "id", transactionId,
                            "status", "Accepted"
                    ));
        }catch (ProviderException ex)
        {
            return ResponseEntity
                    .status(502)
                    .body(Map.of(
                            "id", transactionId,
                            "status", "rejected"
                    ));
        }
    }
}
