package MosaicAppDemo.appDemo.Repo;

import MosaicAppDemo.appDemo.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface BookRepo extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
//    List<Book> findByISBN(String ISBN);
//    List<Book> findByAuthor(String author);
//    List<Book> findByTitle(String title);
//    List<Book> findByGenre(String genre);
//    List<Book> findByPublicationDate(String pubDate);
//    List<Book> findByPriceBetween(double priceFloor, double priceCeil);
//    List<Book> findByQuantity(int quantity);

//    @Query("SELECT b FROM Book b WHERE (:ISBN is null OR b.isbn = :isbn) AND " +
//            "(:author is null OR b.author = :author) AND " +
//            "(:title is null OR b.title = :title) AND " +
//            "(:genre is null OR b.genre = :genre) AND " +
//            "(:publicationDate is null OR b.author = :publicationDate) AND " +
//            "(:priceFloor is null OR b.price >= :priceFloor) AND " +
//            "(:priceCeil is null OR b.price <= :priceCeil) AND " +
//            "(:quantity is null OR b.quantity = :quantity)")
//    List<Book> findByParams(@Param("ISBN") String ISBN,
//            @Param("author") String author,
//            @Param("title") String title,
//            @Param("genre") String genre,
//            @Param("publicationDate") String publicationDate,
//            @Param("priceFloor") Double priceFloor,
//            @Param("priceCeil") Double priceCeil,
//            @Param("quantity") Integer quantity);
}


/*
    private String ISBN;
    private String author;
    private String title;
    private String genre;
    private String publicationDate;
    private double price;
    private int quantity;
 */