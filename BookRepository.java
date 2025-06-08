package lab4_1;

import java.util.List;

public interface BookRepository {
    List<Book> findBooks(AdvancedSearchForm form);
}
