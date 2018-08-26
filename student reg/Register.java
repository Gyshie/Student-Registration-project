

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xml.internal.serializer.utils.StringToIntTable;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	
	private int index;
	private String name;
	private String mobile;
	private String eAddress;
	
	
	Dbconn db = new Dbconn();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			index = Integer.parseInt(request.getParameter("index"));
			name = request.getParameter("name");
			mobile = request.getParameter("mobile");
			eAddress = request.getParameter("eAddress");
			//System.out.println(index);
			if(index > 0) {
				db.connectDb();
				db.insertData(index, name, mobile, eAddress);
				request.setAttribute("info0", "Data inserted success" );
			}
			else {
				request.setAttribute("info0", "Please enter valide index no" );
			}
			request.getRequestDispatcher("studentData.jsp").forward(request, response);
		}
		catch(Exception e){
			request.setAttribute("info0", "Something happen please reenter your details" );
			request.getRequestDispatcher("studentData.jsp").forward(request, response);
		}
	}

}
