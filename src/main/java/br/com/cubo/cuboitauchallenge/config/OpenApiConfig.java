package br.com.cubo.cuboitauchallenge.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Desafio Cubo Itau API")
                        .description("Cubo-Itau-Desafio-api")
                        .contact(new Contact()
                                .name("Gabriel Nóbrega")
                                .email("gabrielnobregasantos2@gmail.com"))
                        .version("1.0.0"));
    }
}
