package com.dx.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Description: Swagger配置
 *
 * @author rockstarsteve
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2021/11/27
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
@Profile({"dev"})
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //扫描包
                .apis(RequestHandlerSelectors.basePackage("com.dx"))
                //扫描注解
                //.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title("这个是后台管理项目")
                        .description("这个项目是用来做给前端提供接口调用和查询的。。")
                        .version("1.1")
                        .build());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("在SpringBoot项目结合Swagger编写接口文档")
                .description("Swagger官方仓库https://github.com/swagger-api/swagger-ui")
                .termsOfServiceUrl("https://github.com/forgot2015/SpringAndSwaggerDemo")
                .version("1.1.0")
                .build();
    }

}
