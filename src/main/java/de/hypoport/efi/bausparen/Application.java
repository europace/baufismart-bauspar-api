package de.hypoport.efi.bausparen;

import com.google.common.base.Predicate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "de.hypoport.efi.bausparen")
@EnableSwagger2
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public Docket bausparApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("europace-bauspar-api")
        .apiInfo(apiInfo())
        .select()
        .paths(apiPaths())
        .build();
  }

  private Predicate<String> apiPaths() {
    return or(
        regex("/bausparangebot.*")
    );
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Europace Bauspar API")
        .description("<img src='https://media.giphy.com/media/xTiTnkAp58qbDdQN8Y/giphy.gif'/>")
        .termsOfServiceUrl("http://www.hypoport.de")
        .contact("gbitteamspeed@hypoport.de")
        .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
        .build();
  }
}

