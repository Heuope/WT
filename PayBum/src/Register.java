import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
@WebServlet("/reg")
public class Register extends HttpServlet {
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
          
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
 
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        String lastName = request.getParameter("lastName");
        String mail = request.getParameter("mail");
        var data = request.getParameter("data");               
         
        try {
            writer.println("<p>Successful registration! maybe.</p>");
                        
        } finally {
            writer.close();  
        }
    }
}