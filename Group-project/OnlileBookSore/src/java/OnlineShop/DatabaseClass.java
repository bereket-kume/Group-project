package OnlineShop;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseClass {
    public Connection connection;

    public DatabaseClass() throws Exception {
        String url = "jdbc:mysql://localhost:3306/bookstore";
        String userName = "root";
        String pass = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, userName, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new Exception("Error connecting to the database");
        }
    }

    public boolean isExist(String email, String password,String tableName) throws SQLException {
        String query = "SELECT * FROM "+tableName+ " WHERE email=? AND pasword=?";
        try (PreparedStatement ps = this.connection.prepareStatement(query)) {
            ps.setString(1,email);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    public void createAccount(int userName, String fname, String lname, String email, String password) throws SQLException {
        String query = "INSERT INTO customer (userName, fname, lname, email, pasword, balance) VALUES (?, ?, ?, ?, ?, 0)";
        try (PreparedStatement ps = this.connection.prepareStatement(query)) {
            ps.setInt(1, userName);
            ps.setString(2, fname);
            ps.setString(3, lname);
            ps.setString(4, email);
            ps.setString(5, password);
            ps.executeUpdate();
        }
    }

    public List<Book> getAllBook(){
         List<Book> books = new ArrayList<>();

        String query = "SELECT * FROM books";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int bookNo = resultSet.getInt("book_no");
                    String title = resultSet.getString("title");
                    String author = resultSet.getString("author");
                    Double price = resultSet.getDouble("price");
                     byte[] image = resultSet.getBytes("image");
                      byte[] book_pdf = resultSet.getBytes("book_pdf");
                      String description=resultSet.getString("descriptions");
                    // Assuming you have a Book class with appropriate constructor
                    Book book = new Book(bookNo, title, author, price, image, book_pdf,description);
                    books.add(book);
                }
            }
            catch (Exception e) {
            e.printStackTrace();
            }
        return books;
    }
  public void addBook(int bookNo,String title,String author,double price,byte[] image,byte[]pdf,String description){
       String query = "INSERT INTO books (book_no, title, author, price, book_image, book_pdf) VALUES (?, ?, ?, ?, ?, ?,?)";
            try{
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, bookNo);
                preparedStatement.setString(2, title);
                preparedStatement.setString(3, author);
                preparedStatement.setDouble(4, price);
                preparedStatement.setBytes(5, image);
                preparedStatement.setBytes(6, pdf);
                preparedStatement.setString(7, description);
                 preparedStatement.executeUpdate();

             
            }
         catch (Exception e) {
            e.printStackTrace();
        }
    }
  public void closeConnection() throws SQLException {
        if (this.connection != null && !this.connection.isClosed()) {
            this.connection.close();
        }
    }
  }

          
