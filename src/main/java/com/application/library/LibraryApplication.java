package com.application.library;

import com.application.library.entity.Author;
import com.application.library.entity.Book;
import com.application.library.entity.Category;
import com.application.library.entity.Publisher;
import com.application.library.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	//executed when application is launched for the first time
	@Bean
	public CommandLineRunner initialCreate(BookService bookService){
		return (args) -> {
			Book book1 = new Book("ABC", "The Daughter's Tale", "The German Girl on his roster, Correa delivers again with the poignant and heart-wrenching The Daughter’s Tale. ");
			Author author1 = new Author("Armando Lucas Correa", "Correa, an award-winning journalist, editor, and author.");
			Category category1 = new Category("Business Books");
			Publisher publisher1 = new Publisher("Amazon");

			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);
			bookService.createBook(book1);

			/*************************************************/
			Book book2 = new Book("DEF", "Himself", "Kidd creates remarkable characters and real-life settings, and then makes them magical. ");
			Author author2 = new Author("Jess Kidd", "The award-winning author ");
			Category category2 = new Category("Math Books");
			Publisher publisher2 = new Publisher("FlipKart");

			book2.addAuthor(author2);
			book2.addCategory(category2);
			book2.addPublisher(publisher2);
			bookService.createBook(book2);

			/*************************************************/
			Book book3 = new Book("GHI", "Gorgeous Lies", " McPhee’s work is expertly crafted and incredibly enticing.");
			Author author3 = new Author("Martha McPhee", " New York Times bestselling author ");
			Category category3 = new Category("Science Books");
			Publisher publisher3 = new Publisher("Barnes & Noble");

			book3.addAuthor(author3);
			book3.addCategory(category3);
			book3.addPublisher(publisher3);
			bookService.createBook(book3);
		};
	}

}
