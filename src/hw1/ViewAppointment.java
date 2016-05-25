package hw1;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAppointment
 */
@WebServlet("/ViewAppointment")
public class ViewAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("aptID", request.getParameter("aptID"));
		request.getRequestDispatcher("ViewAppointment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		int appointmentID = Integer.parseInt(request.getParameter("appointmentID"));
		String date = request.getParameter("appointmentDate");
		String aptID = request.getParameter("apartmentID");
		Date appointmentDate;
		try{
			appointmentDate = formatter.parse(date);
			ArrayList<Appointment> appointmentsArray = (ArrayList<Appointment>)getServletContext().getAttribute("Appointments");
			for(Appointment appoint:appointmentsArray)
			{
				if(appoint.appointmentID==appointmentID)
				{
					appoint.appointmentDate = appointmentDate;
					appoint.appointmentStatus = "Waiting";
					response.sendRedirect("ViewAppointment?aptID="+appoint.appointmentAptID);
				}
			}
		}
		catch(ParseException pe)
		{
			
			request.setAttribute("error", "Please input date in the format MM/dd/yyy hh:mm:ss");
			response.sendRedirect("ViewAppointment?aptID="+aptID);
		}
	}

}
