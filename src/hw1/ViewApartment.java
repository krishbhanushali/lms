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
 * Servlet implementation class ViewApartment
 */
@WebServlet("/ViewApartment")
public class ViewApartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewApartment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = request.getServletContext();
		ArrayList<ApartmentDetails> Apartment = (ArrayList<ApartmentDetails>)context.getAttribute("Apartments");
		HttpSession session = request.getSession();
		String get_id=request.getParameter("id");
		if(get_id!=null)
		{
			for(ApartmentDetails apart: Apartment)
			{
				if(get_id.equals(apart.apartment_id))
				{
					apart.vacancy = true;
					response.sendRedirect("ViewApartment");
					response.setHeader("REFRESH", "0");
				}
			}
		}
		else
			request.getRequestDispatcher("ViewApartment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
