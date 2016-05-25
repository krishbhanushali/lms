package hw1;
import java.io.IOException;
import java.text.ParseException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.CycleRecoverable.Context;

/**
 * Servlet implementation class login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<UserDetail> User;
	ArrayList<ApartmentDetails> Apartment;
	ArrayList<Appointment> AppointmentArray;
	ArrayList<RentOutDetails> RentOutArray;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Serlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = null;
		try{
		date = formatter.parse("10/25/2015"); 
		User = new ArrayList<>();
		Apartment = new ArrayList<>();
		AppointmentArray = new ArrayList<>();
		RentOutArray = new ArrayList<>();
		ApartmentDetails ad1 = new ApartmentDetails("101","1BD 1Bath","Wooden Floor,TV","2","1200","1200",true);
		ApartmentDetails ad2 = new ApartmentDetails("102","2BD 1Bath","Microwave","3","2400","2400",false);
		ApartmentDetails ad3 = new ApartmentDetails("103","2BD 1Bath","Microwave","3","2350","2400",true);
		UserDetail ud1 = new UserDetail(1,"jdoe","admin","jdoe@localhost.com",true);		
		UserDetail ud2 = new UserDetail(2,"krishsb","krishsb","k@g.com","7798775575","5","Student","1 BHK","haha",date,true);
		UserDetail ud3 = new UserDetail(3,"krish","krish","krish@g.com","7798775575","5","Student","1 BHK","haha",date,true);
		Appointment a1 = new Appointment(1,101,3,"Requested");
		User.add(ud1);
		User.add(ud2);
		User.add(ud3);
		AppointmentArray.add(a1);
		Apartment.add(ad1);
		Apartment.add(ad2);
		Apartment.add(ad3);
		config.getServletContext().setAttribute("Users",User);
		config.getServletContext().setAttribute("Apartments", Apartment);
		config.getServletContext().setAttribute("Appointments", AppointmentArray);
		config.getServletContext().setAttribute("RentOuts", RentOutArray);
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<UserDetail> Users = (ArrayList<UserDetail>)getServletContext().getAttribute("Users");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int flag=0;
		if(request.getParameter("submit1") != null)
		{
			if(username.isEmpty() || password.isEmpty())
			{
				response.setContentType("text/html");
				request.setAttribute("error", "Username or password cannot be empty.");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				return;
			}
			else
			{
				for(UserDetail user : Users)
				{
					if(user.email.equals(username) && user.password.equals(password) && user.isManager==true)
					{
						
						HttpSession session = request.getSession(true);
						session.setAttribute("Username",user.username);
						session.setAttribute("userID", user.userID);
						request.getRequestDispatcher("ManagerHome").forward(request, response);
						return;
					}
					else
					if(user.email.equals(username) && user.password.equals(password) && user.isProspect==true)
					{
						HttpSession session = request.getSession(true);
						session.setAttribute("Username",user.username);
						session.setAttribute("userID", user.userID);
						response.sendRedirect("LookUpApartment");
						return;
					}
				}
				request.setAttribute("error","Incorrect username or password.");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				
			}
		}
		else if(request.getParameter("clear") !=null)
		{
			response.sendRedirect("Login");
			response.setHeader("REFRESH", "0");
		}
	}

}
