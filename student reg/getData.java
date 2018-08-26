

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getData
 */
@WebServlet("/getData")
public class getData extends HttpServlet {
	//veriable for retrive data form .jsp file;
	private int index;
	private String name;
	
	//veriable for senddata to .jsp file;
	String[] data = new String[4];
			
	
	Dbconn db0 = new Dbconn();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getData() {
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
		try {
			index = Integer.parseInt(request.getParameter("index"));
			name = request.getParameter("name");
			System.out.print("here");
			
			if(index > 0) {
				db0.connectDb();
				data = db0.getData(index);
				//System.out.print(data[1]);
				
				request.setAttribute("indexNo", data[0] );
				request.setAttribute("uName", data[1] );
				request.setAttribute("umobile", data[2] );
				request.setAttribute("uemail", data[3] );
			}
			else {
				request.setAttribute("info", "Please enter valide index no" );
			}
			request.getRequestDispatcher("studentData.jsp").forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("info", "Please enter correct index number");
			request.getRequestDispatcher("studentData.jsp").forward(request, response);
		}
	}

}
