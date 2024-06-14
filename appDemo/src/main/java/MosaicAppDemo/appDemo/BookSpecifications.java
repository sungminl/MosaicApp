package MosaicAppDemo.appDemo;

import MosaicAppDemo.appDemo.Entities.Book;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;


public class BookSpecifications {

    /*
        Adding to test git push
        Time ran out during interview so only had time for 2 of the filter
     */

    public static Specification<Book> filterByISBN(String ISBN) {
        return (Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (ISBN == null || ISBN.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("ISBN"), ISBN);
        };
    }

    public static Specification<Book> filterByTitle(String title) {
        return (Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (title == null || title.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("title"), title);
        };
    }

    public static Specification<Book> filterByGenre(String genre) {
        return (Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (genre == null || genre.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("genre"), genre);
        };
    }

    public static Specification<Book> filterByDateRange(LocalDate startDate, LocalDate endDate) {
        return (Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (startDate == null && endDate == null) {
                return criteriaBuilder.conjunction();
            } else if (startDate != null && endDate != null) {
                return criteriaBuilder.between(root.get("publicationDate"), startDate, endDate);
            } else if (startDate != null && endDate == null) {
                return criteriaBuilder.greaterThan(root.get("publicationDate"), startDate);
            } else {
                return criteriaBuilder.lessThan(root.get("publicationDate"), endDate);
            }
        };
    }
}
