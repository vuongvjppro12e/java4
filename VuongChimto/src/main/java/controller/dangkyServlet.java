	package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import beans.form_data.dangkyData;


@WebServlet("/dangkyServlet")
public class dangkyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public dangkyServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/dangKy.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameterMap();
		dangkyData bean = new dangkyData();
				try {
					BeanUtils.populate(bean, request.getParameterMap());
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(bean.getHoten());
				System.out.println(bean.getDiachi());
				System.out.println(bean.getEmail());
				System.out.println(bean.getGioitinh());
				System.out.println(bean.getPassword());
				System.out.println(bean.getSdt());
				System.out.println(bean.getLoaiKH());	
				response.sendRedirect("/VuongChimto"+"/helloServerlet");		
	}
	
}
