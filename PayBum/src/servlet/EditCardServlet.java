package servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CreditCardDAO;
import mysqlapp.business.CreditCard;
 
 
@WebServlet("/editCard")
public class EditCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            CreditCard card = CreditCardDAO.selectOne(id);
            
            if(card != null) {
                request.setAttribute("card", card);
                getServletContext().getRequestDispatcher("/editCard.jsp").forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            int number = Integer.parseInt(request.getParameter("number"));
            int cvv = Integer.parseInt(request.getParameter("cvv"));
            int month = Integer.parseInt(request.getParameter("month"));
            int year = Integer.parseInt(request.getParameter("year"));
            
            CreditCard card = new CreditCard(id, number, cvv, month, year);            
            CreditCardDAO.update(card);            
            response.sendRedirect(request.getContextPath() + "/index");
        }
        catch(Exception ex) {
             
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);   
        }
    }
}