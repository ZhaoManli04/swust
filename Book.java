package lab4_1;

public class Book {
    private Long id;
    private String title;
    private String authors;
    private String publisher;
    private Integer publishYear;
    private DocumentType documentType;
    private Language language;
    private Carrier carrier;
    private Source source;
    private InventoryStatus status;

    public Book() {
        System.out.println("Book created: " + this);
    }
    public Book(Long id, String title, String authors, String publisher, Integer publishYear, DocumentType documentType, Language language, Carrier carrier, Source source, InventoryStatus status,  Field field){
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.documentType = documentType;
        this.language = language;
        this.carrier = carrier;
        this.source = source;
        this.status = status;

        System.out.println("Book created: " + this);
    }
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthors() { return authors; }
    public void setAuthors(String authors) { this.authors = authors; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public Integer getPublishYear() { return publishYear; }
    public void setPublishYear(Integer publishYear) { this.publishYear = publishYear; }

    public DocumentType getDocumentType() { return documentType; }
    public void setDocumentType(DocumentType documentType) { this.documentType = documentType; }

    public Language getLanguage() { return language; }
    public void setLanguage(Language language) { this.language = language; }

    public Carrier getCarrier() { return carrier; }
    public void setCarrier(Carrier carrier) { this.carrier = carrier; }

    public Source getSource() { return source; }
    public void setSource(Source source) { this.source = source; }

    public InventoryStatus getStatus() { return status; }
    public void setStatus(InventoryStatus status) { this.status = status; }


    @Override
    public String toString() {
        return "《" + title + "》 - " + authors + " (" + publishYear + ") [" + documentType + "]";
    }
}
