package MosaicAppDemo.appDemo.Service;

import MosaicAppDemo.appDemo.BookSpecifications;
import MosaicAppDemo.appDemo.Entities.Book;
import MosaicAppDemo.appDemo.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public List<Book> getBooks(String ISBN, String title) {
        Specification<Book> specISBN = BookSpecifications.filterByISBN(ISBN);
        Specification<Book> specTitle = BookSpecifications.filterByTitle(title);

        Specification<Book> combinedSpec = Specification.where(specISBN).and(specTitle);

        return bookRepo.findAll(combinedSpec);
    }

//    public List<Book> getBooksByISBN(String ISBN) {
//        return bookRepo.findByISBN(ISBN);
//    }
//
//    public List<Book> getBooksByAuthor(String author) {
//        return bookRepo.findByAuthor(author);
//    }
//
//    public List<Book> getBooksByTitle(String title) {
//        return bookRepo.findByTitle(title);
//    }
//
//    public List<Book> getBooksByGenre(String genre) {
//        return bookRepo.findByGenre(genre);
//    }
//    public List<Book> getBooksByPublicationDate(String publicationDate) {
//        return bookRepo.findByPublicationDate(publicationDate);
//    }
//
//    public List<Book> getBooksByPriceRange(double priceFloor, double priceCeil) {
//        return bookRepo.findByPriceBetween(priceFloor, priceCeil);
//    }
//
//    public List<Book> getBooksByQuantity(int quantity) {
//        return bookRepo.findByQuantity(quantity);
//    }

}
