package hw1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class RequestMapping
 */
@WebServlet("/RequestMapping")
public class RequestMapping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestMapping() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userID = Integer.parseInt(request.getParameter("userID"));
		int aptID = Integer.parseInt(request.getParameter("aptID"));
		ArrayList<Appointment> appointmentsArray = (ArrayList<Appointment>)getServletContext().getAttribute("Appointments");
		Appointment a1 = new Appointment(appointmentsArray.size()+1,aptID,userID,"Requested");
		appointmentsArray.add(a1);
		response.sendRedirect("LookUpApartment");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
