package hw1;



import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;

/**
 * Servlet implementation class registration
 */
@WebServlet("/RegisterResident")
public class RegisterResident extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterResident() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("RegisterResident.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirm_password = request.getParameter("confirm_password");
		String email = request.getParameter("email");
		String contact_no = request.getParameter("contact_no");
		String no_of_people = request.getParameter("no_of_people");
		String occupation = request.getParameter("occupation");
		String type = request.getParameter("type");
		String preferences = request.getParameter("preferences");
		String from_date = request.getParameter("from_date");
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = null;
		try
		{
			date = formatter.parse(from_date);
			if(request.getParameter("submitForm")!=null)
			{
				if(!password.equals(confirm_password))
				{
					response.setContentType("text/html");
					request.setAttribute("error", "Passwords do not match");
					request.getRequestDispatcher("RegisterResident.jsp").forward(request, response);
				}
				else
				{
					ServletContext context = request.getServletContext();
					ArrayList<UserDetail> Users = (ArrayList<UserDetail>)getServletContext().getAttribute("Users");
					UserDetail ud = new UserDetail(Users.size()+1,username,password,email,contact_no,no_of_people,occupation,type,preferences,date,true);
					Users.add(ud);
					context.setAttribute("Users", Users);
					if(!response.isCommitted())
						response.sendRedirect("Login");
					else
						response.sendRedirect("Login");
				}
			}
			else if(request.getParameter("clearForm")!=null)
			{
				response.sendRedirect("RegisterResident");
				response.setHeader("REFRESH", "0");
			}
		}
		catch(ParseException pe)
		{
			response.setContentType("text/html");
			request.setAttribute("error", "Date should be in the format mm/dd/yyyy.");
			request.getRequestDispatcher("RegisterResident.jsp").forward(request, response);
		}
	}
}


