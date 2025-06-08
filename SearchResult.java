package lab4_1;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {
    private List<Book> books;
    private Integer totalCount;
    public SearchResult() {
        this.books = new ArrayList<>();
        this.totalCount = 0;
    }

    public SearchResult(List<Book> books, Integer totalCount) {
        this.books = books;
        this.totalCount = totalCount;
    }

    // Getters and Setters
    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books; }

    public Integer getTotalCount() { return totalCount; }
    public void setTotalCount(Integer totalCount) { this.totalCount = totalCount; }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }
}
