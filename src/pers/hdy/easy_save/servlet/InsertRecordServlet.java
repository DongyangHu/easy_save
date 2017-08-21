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
		//�洢���˺�
		String account = new String(request.getParameter("account").getBytes("ISO-8859-1"),"UTF-8");
		//�˺�����
		String password = new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
		//�˺�����
		String type = new String(request.getParameter("type").getBytes("ISO-8859-1"),"UTF-8");
		HttpSession session = request.getSession();
		//�洢��ʱ��
		String CreateTime = GetTime.getTime();
		//��¼��ID
		String DataID = session.getAttribute("ID") + CreateTime;
		//��¼��Ӧ���û�ID
		String UserID = (String) session.getAttribute("ID");
		record.setDataID(DataID);
		record.setAccount(account);
		record.setAccount_pw(password);
		record.setAccount_type(type);
		record.setCreateTime(CreateTime);
		record.setUserID(UserID);
		//������Ӽ�¼����
		InsertRecordService insertRecordService = new InsertRecordService();
		boolean flag = insertRecordService.insertRecord(record);
		if(flag){
			request.setAttribute("InsertRecordResult", "��ӳɹ�!");
		}else{
			request.setAttribute("InsertRecordResult", "���ʧ��!");
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
