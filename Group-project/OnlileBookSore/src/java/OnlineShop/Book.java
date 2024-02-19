package OnlineShop;
import java.awt.Image;
public class Book {
    private String bookNo;   // Unique identifier for the book
    private String title;    // Title of the book
    private String author;   // Author of the book
    private Double price;     // Price of the book
    private  byte[] image;      // Cover image of the book
    private byte[] pdf;       // Binary data for the PDF version of the book
    public Book(int bookNo1, String bookNo, String title, Double price, byte[] image, byte[] pdf, String description) {
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

    public  byte[] getImage() {
        return image;
    }

    public void setImage( byte[] image) {
        this.image = image;
    }
    public byte[] getPdf() {
        return pdf;
    }
    public void setPdf(byte[] pdf) {
        this.pdf = pdf;
    }
}
