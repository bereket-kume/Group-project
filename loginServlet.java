import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
@WebServlet(urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {
  @Override 
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String customerId=request.getParameter("id");
        String password=request.getParameter("password");
        DatabaseClass d_class;
      try {
          d_class = new DatabaseClass();
           if (d_class.isExist(customerId,password,"customerTable")){
               RequestDispatcher redi=request.getRequestDispatcher("homePage.html");
               redi.forward(request, response);
          
            
        }
      } catch (Exception ex) {
          Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
      }
       
        
    }
    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    
        
    }
}
