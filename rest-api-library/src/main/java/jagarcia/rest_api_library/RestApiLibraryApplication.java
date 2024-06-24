package jagarcia.rest_api_library;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//DOCUMENTAR API
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot REST API Documentation",
				description = "Spring boot REST API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Jhony Alexis Martinez",
						email = "jhonyalexis100@gmail.com"
				),
				license = @License(
						name = "apache 2.0"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Sping boot Library Management Documentation"
		)
)
public class RestApiLibraryApplication {
	//Registrar en el contexto de la aplicacion el ModelMapper
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(RestApiLibraryApplication.class, args);
	}

}
