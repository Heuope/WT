package servlet;
import java.io.IOException;
import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserAccount;
import dao.CreditCardDAO;
import mysqlapp.business.CreditCard;
import utils.AppUtils;

@WebServlet("/cardsView")
public class CardsViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
		
		UserAccount loginedUser = AppUtils.getLoginedUser(request.getSession());
        ArrayList<CreditCard> cards = CreditCardDAO.select(loginedUser.getUserName());
        request.setAttribute("cards", cards);
          
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}