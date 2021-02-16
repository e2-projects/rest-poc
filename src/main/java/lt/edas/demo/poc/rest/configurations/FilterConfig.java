package lt.edas.demo.poc.rest.configurations;

import lombok.AllArgsConstructor;
import lt.edas.demo.poc.rest.filters.PingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class FilterConfig {

    private final PingFilter pingFilter;

    @Bean
    public FilterRegistrationBean<PingFilter> pingFilterBean() {
        var filterBean = new FilterRegistrationBean<PingFilter>();
        filterBean.setFilter(pingFilter);
        filterBean.setOrder(0);
        filterBean.addUrlPatterns("/ping");
        return filterBean;
    }
}
