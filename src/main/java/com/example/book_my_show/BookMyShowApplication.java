package com.example.book_my_show;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Movie Ticket Booking System",
				description = "The Movie Ticket Booking System is a web-based application built using Spring Boot and MySQL database and deployed on AWS.\n This system allows users to book movie tickets online, add new theatres, and add new movies to the database.\n The development of the system is still ongoing, and it is expected to be a comprehensive movie ticket booking platform that allows users to search for movies, view movie details, book tickets, and pay for them online.\n The system will also allow theatre owners to add their theatres to the system, and movie distributors to add their movies to the database.",
				version = "1.0.0",
				termsOfService = "Contact for details",
				contact = @Contact(
						name = "Vivek Singhania",
						email = "viveksinghania@gmail.com",
						url = "https://github.com/itsviveksinghania"
				),
				license = @License(
						name = "Vivek Singhania",
						url = "Run Code"
				)

		)
)
public class BookMyShowApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
	}

}
