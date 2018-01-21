package com.mzd.drugstore.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(postPaths()).build();
    }

    //过滤路径，只有路径中符合/drugstore/.*的congtoller才会产生swagger
    private Predicate<String> postPaths() {
        return or(regex("/drugstore/.*"), regex("/drugstore/.*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("drugstore接口说明文档")
                .description("drugstore API ")
                .version("1.0").build();
    }
}
