package MosaicAppDemo.appDemo;

import MosaicAppDemo.appDemo.Entities.Book;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;


public class BookSpecifications {

    /*
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
}
