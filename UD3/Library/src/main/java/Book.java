import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long idBook;
    @Column(nullable = false, length = 13, unique = true)
    private String isbn;
    private String title;
    private String author;
    private Short publicationYear;
    private Boolean available;
    @Lob
    private byte[] cover;
    @ElementCollection
    private String[] content;
    @Enumerated(EnumType.STRING)
    private Category category;
    private Calendar publicationDate;
    @Transient
    private Long publishedSince;

    public Long getDaysSincePublication() {
        if (publicationDate != null) {
            LocalDate pubDate = publicationDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            return ChronoUnit.DAYS.between(pubDate, LocalDate.now());
        }
        return null;
    }

    @Transient
    private String isbn10;

    public Book() {
    }

    public Book(String isbn, String title, Calendar publicationDate, Long publishedSince, Category category, String[] content, byte[] cover, Boolean available, Short publicationYear, String author) {
        this.isbn = isbn;
        this.title = title;
        this.publicationDate = publicationDate;
        this.publishedSince = publishedSince;
        this.category = category;
        this.content = content;
        this.cover = cover;
        this.available = available;
        this.publicationYear = publicationYear;
        this.author = author;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Short getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Short publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }

    public String[] getContent() {
        return content;
    }

    public void setContent(String[] content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Calendar getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Calendar publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Long getPublishedSince() {
        return publishedSince;
    }

    public void setPublishedSince(Long publishedSince) {
        this.publishedSince = publishedSince;
    }

    public String getIsbn10() {
        if (isbn != null && isbn.startsWith("978")) {
            String partialIsbn10 = isbn.substring(3, 12);
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                int digit = Character.getNumericValue(partialIsbn10.charAt(i));
                sum += (10 - i) * digit;
            }
            int remainder = sum % 11;
            int controlDigit = 11 - remainder;

            if (controlDigit == 10) {
                return partialIsbn10 + "X";
            } else if (controlDigit == 11) {
                return partialIsbn10 + "0";
            } else {
                return partialIsbn10 + controlDigit;
            }
        }
        return null;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }
}
