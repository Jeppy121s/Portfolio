package com.va.week6.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.va.week6.dao.StudentDao;
import com.va.week6.model.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private StudentDao stDao;

	public void init() {
		stDao = new StudentDao();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String grade = request.getParameter("grade");

		Student st = new Student();
		st.setFirstname(firstName);
		st.setLastname(lastName);
		st.setGrade(grade);
		

		try {
			stDao.registerStudent(st);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("StudentInfo.jsp");
	}

}
