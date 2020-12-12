package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserAccount;
import config.SecurityConfig;
import dao.UsersDAO;

@WebServlet("/registerView")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/registerView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            UserAccount userAccount = new UserAccount(username, password, SecurityConfig.ROLE_USER);
            UsersDAO.insert(userAccount);
            response.sendRedirect(request.getContextPath()+"/index");
        }
        catch(Exception ex) {
             
            getServletContext().getRequestDispatcher("/registerView.jsp").forward(request, response); 
        }
	}

}
