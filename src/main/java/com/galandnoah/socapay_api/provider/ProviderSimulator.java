package com.galandnoah.socapay_api.provider;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
@AllArgsConstructor
public class ProviderSimulator {

    private ProviderProperties providerProperties;

    public void call(Provider provider)
    {
        var random = ThreadLocalRandom.current();

        var latency = providerProperties.getLatency();

        stop(latency + random.nextLong(latency));

        if (random.nextDouble() < failRate(provider))
        {
            throw new ProviderException(
                    random.nextDouble() < 0.7 ?
                            "provider_timeout" :
                            "provider_declined"
            );
        }
    }

    private void stop(long millis)
    {
        try{
            Thread.sleep(millis);
        }catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }

    private double failRate(Provider provider)
    {
        return switch (provider)
        {
            case ORANGE_MONEY -> providerProperties.getOrangeMoney().getFailRate();
            case MTN_MOMO -> providerProperties.getMtnMomo().getFailRate();
            case VISA -> providerProperties.getVisa().getFailRate();
        };
    }
}
