package pers.hdy.easy_save.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.hdy.easy_save.entity.User;
import pers.hdy.easy_save.service.RegisterService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		String password = new String(request.getParameter("password1").getBytes("ISO-8859-1"),"UTF-8");
		User user = new User();
		user.setName(username);
		user.setPassword(password);
		RegisterService registerServeice = new RegisterService();
		boolean flag = registerServeice.register(user);
		if(flag){
			request.setAttribute("register_result", "注册成功!&nbsp;&nbsp;用户名:"+user.getName() + ",&nbsp;&nbsp;ID:" + user.getID());
			request.getRequestDispatcher("/register_result.jsp").forward(request, response);
		}else{
			request.setAttribute("register_result", "注册失败!");
			request.getRequestDispatcher("/register_result.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
