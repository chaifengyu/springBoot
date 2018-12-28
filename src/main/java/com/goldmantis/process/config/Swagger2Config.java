package com.goldmantis.process.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
	
	private static Logger logger = LoggerFactory.getLogger(Swagger2Config.class);
			
	@Value("${swagger.enabled:false}")
	private boolean swaggerEnabled;
	
	@Bean
    public Docket createRestApi() {
		logger.info("swagger.enabled:{}", swaggerEnabled);	
		Docket docket;
		if(swaggerEnabled){
			docket = new Docket(DocumentationType.SWAGGER_2)
					.apiInfo(apiInfo())
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.goldmantis.process.controller"))
					.paths(PathSelectors.any())
					.build();
		}else{
			docket = new Docket(DocumentationType.SWAGGER_2)
					.apiInfo(new ApiInfoBuilder().build())
					.select()
					.apis(RequestHandlerSelectors.basePackage(" "))
					.build();
		}
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口APIs")
                .description("")
                .termsOfServiceUrl("")
                .contact(new Contact("","",""))
                .version("1.0")
                .build();
    }

}
