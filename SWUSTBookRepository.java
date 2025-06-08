package lab4_1;

import java.util.ArrayList;
import java.util.List;

public class SWUSTBookRepository implements BookRepository {
    private List<Book> books = new ArrayList<>();
    private Search search=new Search();
    public SWUSTBookRepository() {
        // 实际实现中这里会连接西南科技大学图书馆数据库
        // 这里模拟返回一些数据


        // 模拟数据1
        Book book1 = new Book();
        book1.setId(1L);
        book1.setTitle("计算机网络（第7版）");
        book1.setAuthors("谢希仁");
        book1.setPublisher("电子工业出版社");
        book1.setPublishYear(2021);
        book1.setDocumentType(DocumentType.BOOK);
        book1.setLanguage(Language.CHINESE);
        book1.setCarrier(Carrier.PRINT);
        book1.setStatus(new InventoryStatus("在馆"));

        books.add(book1);

        // 模拟数据2 - 西南科技大学学位论文
        Book book2 = new Book();
        book2.setId(2L);
        book2.setTitle("基于深度学习的图像识别研究");
        book2.setAuthors("张伟");
        book2.setPublisher("西南科技大学");
        book2.setPublishYear(2022);
        book2.setDocumentType(DocumentType.THESIS);
        book2.setLanguage(Language.CHINESE);
        book2.setCarrier(Carrier.DIGITAL);
        book2.setSource(Source.EI);
        book2.setStatus(new InventoryStatus("在线访问"));
        books.add(book2);
    }
    @Override
    public List<Book> findBooks(AdvancedSearchForm form) {
        SearchResult result = new SearchResult();
        List<SearchCondition> conditions = form.getConditions();
        for (Book book : books){
            for(SearchCondition condition : conditions){

                boolean first=(search.SearchByTitle(condition.getField())&&search.SearchByMode(condition.getMode(),condition.getValue(),book.getTitle()))
                        ||(search.SearchByAuthor(condition.getField())&&search.SearchByMode(condition.getMode(),condition.getValue(),book.getAuthors()))
                        ||(search.SearchByPublisher(condition.getField())&&search.SearchByMode(condition.getMode(),condition.getValue(),book.getPublisher()));
                boolean second=(search.SearchByTitle(condition.getField())&&search.SearchByMode(condition.getMode(),condition.getValue(),book.getTitle()))
                        ||(search.SearchByAuthor(condition.getField())&&search.SearchByMode(condition.getMode(),condition.getValue(),book.getAuthors()))
                        ||(search.SearchByPublisher(condition.getField())&&search.SearchByMode(condition.getMode(),condition.getValue(),book.getPublisher()));
                if(first||(AdvancedSearchBoundary.flag&&search.SearchByRelation(condition.getRelation(),first,second)))
                    result.addBook(book);


            }
        }
        return result.getBooks();
    }

}

