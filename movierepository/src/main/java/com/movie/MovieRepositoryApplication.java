package com.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MovieRepositoryApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MovieRepositoryApplication.class, args);
	}

	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(MovieRepositoryApplication.class);
	    }

	@Bean
	public Docket api() {
	return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.movie"))
				.build();
	}
	
	
//	@Bean
//	CommandLineRunner runner(MovieRepository movieRepository) {
//		return args -> {
//			// read json and write to db
//			ObjectMapper mapper = new ObjectMapper();
//			TypeReference<List<Movie>> typeReference = new TypeReference<List<Movie>>(){};
//			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");
//			try {
//				List<Movie> movies = mapper.readValue(inputStream,typeReference);
//				movieRepository.saveAll(movies);
//				System.out.println("Movies Saved!");
//			} catch (IOException e){
//				System.out.println("Unable to save movies: " + e.getMessage());
//			}
//		};
//	}
}
