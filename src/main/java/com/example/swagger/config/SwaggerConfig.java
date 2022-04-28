package com.example.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.PathProvider;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * Posts api docket
     *
     * @return docket
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathProvider(new PathProvider() {
                    @Override
                    public String getApplicationBasePath() {
                        return StringUtils.EMPTY;
                    }

                    @Override
                    public String getOperationPath(String s) {
                        return s;
                    }

                    @Override
                    public String getResourceListingPath(String s, String s1) {
                        return "/";
                    }
                })
                .protocols(new HashSet<String>(Arrays.asList("https","http")));
    }

    /**
     * Api info api info.
     *
     * @return the api info
     */
    private ApiInfo apiInfo() {
        final ApiInfo apiInfo = new ApiInfoBuilder()
                .title("Swagger With Spring Boot")
                .description("All about Integrating Swagger with Spring Boot")
                .version("1.0")
                .build();
        return apiInfo;
    }
}
