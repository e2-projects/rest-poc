package lt.edas.demo.poc.configurations;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
@Configuration
@ConfigurationProperties("api.security")
@EqualsAndHashCode(callSuper = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private String baseDn;
    private String userDnPattern;
    private String groupSearchBase;
    private String ldapUrl;
    private Integer ldapPort;

    private static final String PASSWORD_ATTRIBUTE = "userPassword";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .fullyAuthenticated()
                .and()
                .formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.ldapAuthentication()
                .userDnPatterns(userDnPattern)
                .groupSearchBase(groupSearchBase)
                .contextSource()
                .url(buildLdapUrl())
                .and()
                .passwordCompare()
                .passwordEncoder(new BCryptPasswordEncoder(12))
                .passwordAttribute(PASSWORD_ATTRIBUTE);
    }

    private String buildLdapUrl() {
        return ldapUrl + ":" + ldapPort + "/" + baseDn;
    }
}
