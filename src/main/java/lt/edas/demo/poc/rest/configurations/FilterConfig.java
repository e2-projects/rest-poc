package lt.edas.demo.poc.rest.configurations;

import lombok.RequiredArgsConstructor;
import lt.edas.demo.poc.rest.filters.PingFilter;
import org.slf4j.Logger;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FilterConfig {

    private final Logger logger;

    @Bean
    public FilterRegistrationBean<PingFilter> pingFilterBean() {
        var filterBean = new FilterRegistrationBean<PingFilter>();
        filterBean.setFilter(new PingFilter(logger));
        filterBean.setOrder(1);
        filterBean.addUrlPatterns("/rest/api/v1/ping");
        return filterBean;
    }
}
