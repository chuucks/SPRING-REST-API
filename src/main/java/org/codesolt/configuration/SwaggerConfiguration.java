package org.codesolt.configuration;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("RestAPI")
				.apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/oauth/token.*"), regex("/user.*"));
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Spring API REST")
				.description("REST API example with Spring and OAUTH2")
				.version("0.1")
				.contact(new Contact("Carlos Salazar", "http://carlos-salazar.com", "carlos-salazar@codesolt.com"))
				.build();
	}
}
