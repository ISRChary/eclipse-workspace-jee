package com.StudentServlet;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.sql.DataSource;
/**
* Servlet implementation class MainServlet
*/
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      @Resource(name="jdbc/studentdb")
      private DataSource dataSource;
     
      private DBConnection dbConnection;
   /**
    * @see HttpServlet#HttpServlet()
    */
   public MainServlet() {
       super();
       // TODO Auto-generated constructor stub
   }
  
  
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		dbConnection = new DBConnection(dataSource);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		listStudent(request,response);
		
	}
	
	private void listStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		List<SettersGetters> students = dbConnection.getStudents();
		request.setAttribute("Student_list", students);
		RequestDispatcher dispacher = request.getRequestDispatcher("/index.jsp");
		dispacher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
