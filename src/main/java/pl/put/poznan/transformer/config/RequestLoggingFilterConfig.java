package pl.put.poznan.transformer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

/**
 * Configuration class for debug logging incoming requests
 *
 * @author Piotr Parzysz
 */
@Configuration
public class RequestLoggingFilterConfig {

    /**
     * config bean for logging incoming requests
     * @return logging filter bean
     */
    @Bean
    public CommonsRequestLoggingFilter logFilter() {
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(1000);
        return filter;
    }

}
