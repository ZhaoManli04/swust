package lab4_1;

import java.util.List;

public class AdvancedSearchController {
    private BookRepository bookRepository = new SWUSTBookRepository();

    public SearchResult handleSearchRequest(AdvancedSearchForm form) {
        if (!validate(form)) {
            throw new IllegalArgumentException("搜索表单验证失败");
        }

        List<Book> books = bookRepository.findBooks(form);
        return new SearchResult(books, books.size());
    }

    public boolean validate(AdvancedSearchForm form) {
        // 实现表单验证逻辑
        if (form.getConditions().isEmpty()) {
            return false;
        }

        if (form.getPublishDateStart() != null && form.getPublishDateEnd() != null) {
            if (form.getPublishDateStart().after(form.getPublishDateEnd())) {
                return false;
            }
        }
        return true;
    }
}