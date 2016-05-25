package hw1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import lab2.UserDetails;

/**
 * Servlet implementation class AddApartment
 */
@WebServlet("/AddApartment")
public class AddApartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddApartment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("AddApartment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String apart_no = request.getParameter("apartment_no");
		String type = request.getParameter("type");
		String facilities = request.getParameter("facilities");
		String max_people = request.getParameter("max_people");
		String rent = request.getParameter("rent");
		String deposits = request.getParameter("deposits");
		
		if(request.getParameter("submit1")!=null)
		{
			if(apart_no.isEmpty() || type.isEmpty() || facilities.isEmpty() || max_people.isEmpty() || rent.isEmpty() || deposits.isEmpty())
			{
				response.setContentType("text/html");
				request.setAttribute("error", "Please fill in all details");
				request.getRequestDispatcher("AddApartment.jsp").forward(request, response);
				return;
			}
			else
			{
				ServletContext context = request.getServletContext();
				ArrayList<ApartmentDetails> Apartment = (ArrayList<ApartmentDetails>)getServletContext().getAttribute("Apartments");
				
				ApartmentDetails ad = new ApartmentDetails(apart_no,type,facilities,max_people,rent,deposits,true);
				Apartment.add(ad);
				context.setAttribute("Apartments", Apartment);
				response.sendRedirect("ViewApartment");
			}
		}
		else if(request.getParameter("clear")!=null)
		{
			response.sendRedirect("AddApartment");
			response.setHeader("REFRESH", "0");
		}
	}

}
