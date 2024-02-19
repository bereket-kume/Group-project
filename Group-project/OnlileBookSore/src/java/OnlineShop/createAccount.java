package OnlineShop;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
@WebServlet("/createAccount")
public class createAccount extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res){
        String fname=req.getParameter("fname");
        String lname=req.getParameter("lname");
        String email=req.getParameter("email");
        String password=req.getParameter("password");
       DatabaseClass d_class = null;
            try {
                
                d_class = new DatabaseClass();
                d_class.createAccount(13,fname, lname, email, password);
                res.sendRedirect("login.html");
    
            } catch (Exception ex) {
                Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
    }
}
