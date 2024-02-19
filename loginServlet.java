package OnlineShop;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
  @Override 
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        
       DatabaseClass d_class = null;
      try {
          d_class = new DatabaseClass();
    if (d_class.isExist(email, password)) {
        response.sendRedirect("homepage.html");
    } 
    else {
        response.sendRedirect("index.html");
    }
} catch (Exception ex) {
    Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
}
}
}
