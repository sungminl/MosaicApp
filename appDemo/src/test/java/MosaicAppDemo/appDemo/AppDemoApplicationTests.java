package MosaicAppDemo.appDemo;

import MosaicAppDemo.appDemo.Controller.BookController;
import MosaicAppDemo.appDemo.Entities.Book;
import MosaicAppDemo.appDemo.Repo.BookRepo;
import MosaicAppDemo.appDemo.Service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AppDemoApplicationTests {

	@Autowired
	private BookRepo bookRepo;

	@Autowired
	private BookService bookService;


	@Autowired
	private BookController bookController;

	@Test
	void testAddBook() {
		Book book = new Book();

		book.setISBN("123456789");
		book.setAuthor("Author name");
		book.setTitle("Generic Title");
		book.setGenre("Anything");
		book.setPublicationDate(LocalDate.of(2020, Month.NOVEMBER, 15));
		book.setPrice(12.34);
		book.setQuantity(5);

		Book bookAdded = bookService.addBook(book);

		assertEquals(bookAdded.getISBN(), "123456789");
	}

	@Test
	void deleteBook() {
		Book book = new Book();

		book.setISBN("987654321");
		book.setAuthor("Author name");
		book.setTitle("Generic Title");
		book.setGenre("Anything");
		book.setPublicationDate(LocalDate.of(2020, Month.NOVEMBER, 15));
		book.setPrice(12.34);
		book.setQuantity(5);

		Book bookAdded = bookService.addBook(book);

		long newBookID = bookAdded.getId();

	}

}


/*
    @DeleteMapping(value = "/deleteBook/{id}")
    public String deleteBook(@PathVariable long id) {
        if (bookRepo.existsById(id)) {
            bookRepo.deleteById(id);
            return "Deleted book with the ID: " + id;
        } else {
            return "Cannot find book with the ID: " + id;
        }
    }


 */