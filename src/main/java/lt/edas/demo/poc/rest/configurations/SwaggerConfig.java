package lt.edas.demo.poc.rest.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.*;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@Data
@Configuration
@EnableOpenApi
@ConfigurationProperties("api")
public class SwaggerConfig {

    private String version;
    private String title;
    private String description;
    private String contactName;
    private String contact;
    private String swaggerEnabled;
    private String origins;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .directModelSubstitute(LocalDateTime.class, String.class)
                .enable(Boolean.parseBoolean(swaggerEnabled))
                .globalResponses(HttpMethod.GET, globalResponses())
                .globalResponses(HttpMethod.POST, globalResponses())
                .globalResponses(HttpMethod.PUT, globalResponses())
                .select()
                .apis(basePackage("lt.edas.demo.poc.rest.controllers"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    UiConfiguration uiConfiguration() {
        return UiConfigurationBuilder.builder()
                .docExpansion(DocExpansion.LIST)
                .operationsSorter(OperationsSorter.METHOD)
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .version(version)
                .title(title)
                .description(description)
                .contact(new Contact(contactName, "", contact))
                .build();
    }

    private List<Response> globalResponses() {
        return Arrays.asList(
                new ResponseBuilder().code("200").description("OK").build(),
                new ResponseBuilder().code("201").description("OK").build(),
                new ResponseBuilder().code("400").description("Bad Request").build(),
                new ResponseBuilder().code("401").description("Unauthorized").build(),
                new ResponseBuilder().code("404").description("Not Found").build(),
                new ResponseBuilder().code("500").description("Internal Server Error").build());
    }

}
