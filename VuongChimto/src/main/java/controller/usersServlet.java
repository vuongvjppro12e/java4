package controller;

import java.io.IOException;
//import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

//import beans.form_data.dangkyData;
import dao.UserDao;
import entities.User;

@WebServlet({ "/usersServlet","/index","/create","/store","/delete" })
public class usersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDAO;

	public usersServlet() {
		super();
		this.userDAO = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("index")) {
			this.index(request, response);
		} else if (uri.contains("show")) {
			this.show(request, response);
		} else if (uri.contains("delete")) {
			this.delete(request, response);
		} else if (uri.contains("update")) {
			this.update(request, response);
		} else if (uri.contains("create")) {
			this.create(request, response);
		} else if (uri.contains("store")) {
			this.store(request, response);
		} else {
		}
		this.create(request, response);
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.store(request, response);
		request.setAttribute("views", "/views/admin/users/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);

	}	

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Date now = new Date();
		List<User> ds = this.userDAO.all();

		request.setAttribute("ds", ds);
		request.setAttribute("now", now);
		request.setAttribute("views", "/views/admin/users/index.jsp");
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);

	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		User entity = this.userDAO.findById(id);
		try {
			this.userDAO.delete(entity);
			index(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> ds = this.userDAO.all();

		request.setAttribute("ds", ds);
		request.setAttribute("views", "/views/admin/users/create.jsp");	
		request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
	}

	private void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User entity = new User();
			BeanUtils.populate(entity, request.getParameterMap());
			this.userDAO.create(entity);
			index(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/VuongChimto/create");
		}
	}
}
