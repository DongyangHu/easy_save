package pers.hdy.easy_save.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.hdy.easy_save.entity.Record;
import pers.hdy.easy_save.service.InsertRecordService;
import pers.hdy.easy_save.util.GetTime;

/**
 * Servlet implementation class InsertAcountServlet
 */
@WebServlet("/InsertRecordServlet")
public class InsertRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertRecordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Record record = new Record();
		//存储的账号
		String account = new String(request.getParameter("account").getBytes("ISO-8859-1"),"UTF-8");
		//账号密码
		String password = new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
		//账号类型
		String type = new String(request.getParameter("type").getBytes("ISO-8859-1"),"UTF-8");
		HttpSession session = request.getSession();
		//存储的时间
		String CreateTime = GetTime.getTime();
		//记录的ID
		String DataID = session.getAttribute("ID") + CreateTime;
		//记录对应的用户ID
		String UserID = (String) session.getAttribute("ID");
		record.setDataID(DataID);
		record.setAccount(account);
		record.setAccount_pw(password);
		record.setAccount_type(type);
		record.setCreateTime(CreateTime);
		record.setUserID(UserID);
		//调用添加记录服务
		InsertRecordService insertRecordService = new InsertRecordService();
		boolean flag = insertRecordService.insertRecord(record);
		if(flag){
			request.setAttribute("InsertRecordResult", "添加成功!");
		}else{
			request.setAttribute("InsertRecordResult", "添加失败!");
		}
		request.getRequestDispatcher("/testQuery.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
