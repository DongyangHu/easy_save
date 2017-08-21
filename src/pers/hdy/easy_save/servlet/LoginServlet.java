package pers.hdy.easy_save.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.hdy.easy_save.entity.User;
import pers.hdy.easy_save.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		User user = null;
		String ID = new String(request.getParameter("userid").getBytes("ISO-8859-1"),"UTF-8");
		String Password = new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
		user = new LoginService().login(ID);
		if(user!=null){
			if(user.getPassword().equals(Password)){
				request.setAttribute("LoginInfo", "登录成功!");
				HttpSession session = request.getSession();
				
				String tempflag = user.getFlag();
				if(tempflag.equals("super")){
					session.setAttribute("flag", "管理员.");
				}else if(tempflag.equals("generic")){
					session.setAttribute("flag", "普通用户.");
				}
				session.setAttribute("ID", user.getID());
				session.setAttribute("username", user.getName());
				request.getRequestDispatcher("/testQuery.jsp").forward(request, response);
			}else{
				request.setAttribute("LoginInfo", "密码错误!");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("LoginInfo", "该用户不存在!");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
