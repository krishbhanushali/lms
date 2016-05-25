package hw1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LookUpApartment
 */
@WebServlet("/LookUpApartment")
public class LookUpApartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LookUpApartment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.sendRedirect("LookUpApartment.jsp");
		//Appointment dummy = new Appointment();
		//request.setAttribute("dummy", dummy);
		request.getRequestDispatcher("LookUpApartment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<Appointment> appointmentsArray = (ArrayList<Appointment>)getServletContext().getAttribute("Appointments");
		
			int appointmentID = Integer.parseInt(request.getParameter("appointmentID"));
		
		//int apartmentID = Integer.parseInt(request.getParameter("apartmentID"));
		if(request.getParameter("accept")!=null)
		{
			for(Appointment appoint:appointmentsArray)
			{
				if(appoint.appointmentID==appointmentID)
				{
					appoint.appointmentStatus = "Accepted";
					request.getRequestDispatcher("LookUpApartment.jsp").forward(request, response);
					response.setHeader("REFRESH","0");
				}
			}
		}
		if(request.getParameter("deny")!=null)
		{
			for(Appointment appoint:appointmentsArray)
			{
				if(appoint.appointmentID==appointmentID)
				{
					appoint.ruledOutDates.add(appoint.appointmentDate);
					appoint.appointmentStatus = "Denied";
					request.getRequestDispatcher("LookUpApartment.jsp").forward(request, response);
					response.setHeader("REFRESH","0");
				}
			}
		}
	}

}
