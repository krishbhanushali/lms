package hw1;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RentOut
 */
@WebServlet("/RentOut")
public class RentOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userID = Integer.parseInt(request.getParameter("userID"));
		int apartmentID = Integer.parseInt(request.getParameter("apartmentID"));
		request.setAttribute("userID", userID);
		request.setAttribute("apartmentID", apartmentID);
		request.getRequestDispatcher("RentOut.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<RentOutDetails> rentOuts = (ArrayList<RentOutDetails>)getServletContext().getAttribute("RentOuts");
		ArrayList<ApartmentDetails> Apartment = (ArrayList<ApartmentDetails>)getServletContext().getAttribute("Apartments");
		ArrayList<Appointment> appointmentsArray = (ArrayList<Appointment>)getServletContext().getAttribute("Appointments");
		ArrayList<UserDetail> Users = (ArrayList<UserDetail>)getServletContext().getAttribute("Users");
		int userID = Integer.parseInt(request.getParameter("userID"));
		int apartmentID = Integer.parseInt(request.getParameter("apartmentID"));
		java.util.Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String leaseHolderName = request.getParameter("leaseHolderName");
		String passport = request.getParameter("passport");
		String calID = request.getParameter("calID");
		String license = request.getParameter("license");
		int rent = Integer.parseInt(request.getParameter("rent"));
		int deposit = Integer.parseInt(request.getParameter("deposit"));
		String documents[] = {passport,calID,license};
		if(request.getParameter("submit")!=null)
		{
			try
			{
				date = formatter.parse(request.getParameter("leaseTerminationDate"));
				RentOutDetails r = new RentOutDetails(rentOuts.size()+1,userID,apartmentID,date,leaseHolderName,documents,rent,deposit);
				rentOuts.add(r);
				for(ApartmentDetails apart:Apartment)
				{
					if(apartmentID==Integer.parseInt(apart.apartment_id))
					{
						apart.vacancy = false;
					}
				}
				for(Appointment appoint:appointmentsArray)
				{
					if(appoint.appointmentAptID==apartmentID)
						appoint.appointmentStatus = "Rented Out";
				}
				request.getRequestDispatcher("ViewApartment.jsp").forward(request, response);
			}
			catch(ParseException pe)
			{
				
			}
		}
		else if(request.getParameter("clear")!=null)
		{
			response.sendRedirect("RentOut");
			response.setHeader("REFRESH", "0");
		}
		
		//RentOutDetails rents = new(rentOuts.size()+1,userID,apartmentID,);
		/*for(RentOutDetails rents:rentOuts)
		{
			
		}*/
	}

}
