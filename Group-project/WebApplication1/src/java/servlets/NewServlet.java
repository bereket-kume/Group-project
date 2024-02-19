import jakarta.servlet.http.HttpServlet;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class NewServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String Departement = request.getParameter("Departement");

        try {
            // Loading drivers for MySQL
            Class.forName("com.mysql.jdbc.Driver");

            // Creating connection with the database
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/infos", "root", "root")) {
                if (con != null && !con.isClosed()) {
                    out.println("Database connection successful<br>");

                    PreparedStatement ps = con.prepareStatement("INSERT INTO studnetinfo VALUES (?, ?, ?, ?, ?, ?, ?)");
                    ps.setString(1, username);
                    ps.setString(2, firstname);
                    ps.setString(3, lastname);
                    ps.setString(4, email);
                    ps.setString(5, password);
                    ps.setString(6, gender);
                    ps.setString(7, Departement);

                    int i = ps.executeUpdate();

                    if (i > 0) {
                        out.println("You are successfully registered");
                    }
                } else {
                    out.println("Failed to connect to the database");
                }
            }

        } catch (Exception se) {
            se.printStackTrace();
        }

    }
}