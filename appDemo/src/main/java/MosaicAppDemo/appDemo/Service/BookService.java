package MosaicAppDemo.appDemo.Service;

import MosaicAppDemo.appDemo.BookSpecifications;
import MosaicAppDemo.appDemo.Entities.Book;
import MosaicAppDemo.appDemo.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public Page<Book> getBooksWithPagination(String ISBN, String title, Integer page, Integer size, String orderBy, String direction) {

        Sort.Direction sortDirection = Sort.Direction.fromString(direction);

        Specification<Book> specISBN = BookSpecifications.filterByISBN(ISBN);
        Specification<Book> specTitle = BookSpecifications.filterByTitle(title);

        Specification<Book> combinedSpec = Specification.where(specISBN).and(specTitle);

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, orderBy));
        return bookRepo.findAll(combinedSpec, pageable);
    }


    public List<Book> getBooks(String ISBN, String title, String orderBy, String direction) {

        Sort.Direction sortDirection = Sort.Direction.fromString(direction);

        Sort sort = Sort.by(sortDirection, orderBy);

        Specification<Book> specISBN = BookSpecifications.filterByISBN(ISBN);
        Specification<Book> specTitle = BookSpecifications.filterByTitle(title);

        Specification<Book> combinedSpec = Specification.where(specISBN).and(specTitle);


        return bookRepo.findAll(combinedSpec, sort);
    }

    public List<Book> getOptionalBooks(String title, String genre, LocalDate startDate, LocalDate endDate) {
        Specification<Book> specTitle = BookSpecifications.filterByTitle(title);
        Specification<Book> specGenre = BookSpecifications.filterByGenre(genre);
        Specification<Book> specDateRange = BookSpecifications.filterByDateRange(startDate, endDate);

        Specification<Book> combinedSpec = Specification.where(specTitle).and(specGenre).and(specDateRange);

        return bookRepo.findAll(combinedSpec);
    }


    public Book addBook(Book book) {
        //1st approach was to see if there exists a book with ISBN the same and if there is, return existing book, if not add book


        try {
            return bookRepo.save(book);
        } catch (Exception e) {
            // do nothing
        }

    }


    public void deleteBook(long id) {
        if (bookRepo.existsById(id)) {
            bookRepo.deleteById(id);

        } else {

        }
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
