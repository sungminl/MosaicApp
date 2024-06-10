package MosaicAppDemo.appDemo.Controller;


import MosaicAppDemo.appDemo.Entities.Book;
import MosaicAppDemo.appDemo.Repo.BookRepo;
import MosaicAppDemo.appDemo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookEntity")
public class BookController {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private BookService bookService;

//    @GetMapping(value = "/getAllBooks")
//    public List<Book> getAllBooks() {
//        return bookRepo.findAll();
//    }
//
//    @GetMapping(value = "/getBook")
//    public Book getBook(@PathVariable long id) {
//        Optional<Book> bookOptional = bookRepo.findById(id);
//        if (bookOptional.isPresent()) {
//             return bookOptional.get();
//        } else {
//            System.out.println("Cannot find book with the ID: " + id);
//            return null;
//        }
//    }

//    @GetMapping("/books")
//    public List<Book> getBooks(
//            @RequestParam(required = false) String ISBN,
//            @RequestParam(required = false) String author,
//            @RequestParam(required = false) String title,
//            @RequestParam(required = false) String genre,
//            @RequestParam(required = false) String publicationDate,
//            @RequestParam(required = false) Double priceFloor,
//            @RequestParam(required = false) Double priceCeil,
//            @RequestParam(required = false) Integer quantity) {
//
//        if (ISBN != null) {
//            return bookService.getBooksByISBN(ISBN);
//        } else if (author != null) {
//            return bookService.getBooksByAuthor(author);
//        } else if (title != null) {
//            return bookService.getBooksByTitle(title);
//        } else if (genre != null) {
//            return bookService.getBooksByGenre(genre);
//        } else if (publicationDate != null) {
//            return bookService.getBooksByPublicationDate(publicationDate);
//        } else if (priceFloor != null && priceCeil != null) {
//            return bookService.getBooksByPriceRange(priceFloor, priceCeil);
//        } else if (quantity != null) {
//            return bookService.getBooksByQuantity(quantity);
//        } else {
//            return bookRepo.findAll();
//        }
//
//    }

    @GetMapping("/books")
    public List<Book> getBooks(@RequestParam(required = false) String ISBN,
            @RequestParam(required = false) String title) {
        return bookService.getBooks(ISBN, title);
    }

    @PostMapping(value = "/addBook")
    public String addBook(@RequestBody Book book) {
        bookRepo.save(book);
        return "Saved book with the title: " + book.getTitle();
    }


    @PutMapping(value = "/updatedBook/{id}")
    public String updateBook(@PathVariable long id, @RequestBody Book book) {
        Optional<Book> bookOptional = bookRepo.findById(id);
        if (bookOptional.isPresent()) {
            Book updatedBook = bookOptional.get();
            updatedBook.setISBN(book.getISBN());
            updatedBook.setAuthor(book.getAuthor());
            updatedBook.setTitle(book.getTitle());
            updatedBook.setGenre(book.getGenre());
            updatedBook.setPublicationDate(book.getPublicationDate());
            updatedBook.setPrice(book.getPrice());
            updatedBook.setQuantity(book.getQuantity());
            bookRepo.save(updatedBook);
            return "Updated book with the ID: " + id;
        } else {
            return "Cannot find book with the ID: " + id;
        }
    }

    @DeleteMapping(value = "/deleteBook/{id}")
    public String deleteBook(@PathVariable long id) {
        if (bookRepo.existsById(id)) {
            bookRepo.deleteById(id);
            return "Deleted book with the ID: " + id;
        } else {
            return "Cannot find book with the ID: " + id;
        }
    }
}

