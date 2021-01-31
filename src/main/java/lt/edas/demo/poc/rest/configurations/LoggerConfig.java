package lt.edas.demo.poc.rest.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.MethodParameter;

import java.lang.reflect.Field;
import java.util.Optional;

@Configuration
public class LoggerConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Logger logger(InjectionPoint injectionPoint){
        return LoggerFactory
                .getLogger(Optional.ofNullable(injectionPoint.getMethodParameter())
                        .<Class>map(MethodParameter::getContainingClass)
                        .orElseGet(() ->
                                Optional.ofNullable(injectionPoint.getField())
                                        .map(Field::getDeclaringClass)
                                        .orElseThrow(IllegalArgumentException::new))
                );
    }
}
