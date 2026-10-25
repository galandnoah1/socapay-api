package com.galandnoah.socapay_api.provider;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "provider")
@Getter
@Setter
public class ProviderProperties {

    private long latency;

    private Settings orangeMoney;
    private Settings mtnMomo;
    private Settings visa;

    @Getter
    @Setter
    public static class Settings {
        private double failRate;
    }
}
