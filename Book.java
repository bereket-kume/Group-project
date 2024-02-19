import java.awt.Image;

/**
 * Represents a Book with specific attributes.
 */
public class Book {
    private String bookNo;   // Unique identifier for the book
    private String title;    // Title of the book
    private String author;   // Author of the book
    private Double price;     // Price of the book
    private Image image;      // Cover image of the book
    private byte[] pdf;       // Binary data for the PDF version of the book
    public Book(String bookNo, String title, String author, Double price, Image image, byte[] pdf) {
        this.bookNo = bookNo;
        this.title = title;
        this.author = author;
        this.price = price;
        this.image = image;
        this.pdf = pdf;
    }
    public String getBookNo() {
        return bookNo;
    }
    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Image getImage() {
        return image;
    }


    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Gets the binary data for the PDF version of the book.
     *
     * @return The PDF data.
     */
    public byte[] getPdf() {
        return pdf;
    }

    /**
     * Sets the binary data for the PDF version of the book.
     *
     * @param pdf The PDF data.
     */
    public void setPdf(byte[] pdf) {
        this.pdf = pdf;
    }

    // Other methods, if needed
}
