package servlet;
import java.io.IOException;
import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CreditCardDAO;
import mysqlapp.business.CreditCard;
 
@WebServlet("/createCard")
public class CreateCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        getServletContext().getRequestDispatcher("/createCard.jsp").forward(request, response);
    }
     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        try {
            int number = Integer.parseInt(request.getParameter("number"));
            int cvv = Integer.parseInt(request.getParameter("cvv"));
            int month = Integer.parseInt(request.getParameter("month"));
            int year = Integer.parseInt(request.getParameter("year"));
            
            CreditCard card = new CreditCard(number, cvv, month, year);
            CreditCardDAO.insert(card);
            response.sendRedirect(request.getContextPath()+"/index");
        }
        catch(Exception ex) {
             
            getServletContext().getRequestDispatcher("/createCard.jsp").forward(request, response); 
        }
    }
}