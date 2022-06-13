package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import entities.User;
import utils.EncryptUtil;


@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private UserDao userDAO;
    public loginServlet() {
        super();
        this.userDAO = new UserDao();
    }

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		request.getRequestDispatcher("/views/login.jsp")
			.forward(request, response);
	}

	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = request.getParameter("email"),
			pwd = request.getParameter("password");
		
		User user = this.userDAO.findByEmail(email);
		
		boolean check = EncryptUtil.check(pwd, user.getPassword());
		
		if (check == true) {
			// Đăng nhập thành công
			session.setAttribute("user", user);
		} else {
			// Đăng nhập thất bại
		}
		
		response.sendRedirect(
			"/VuongChimto" +
			"/helloServlet"
		);
	}

}
