package exam;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// Extend HttpServlet class
public class CountryTHServlet extends HttpServlet {
	
	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

	}
	
	@Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String countryName = request.getParameter("countryName");
		String area = request.getParameter("area");
		String population = request.getParameter("population");
		String sorting = request.getParameter("sorting");
		String orderBy = request.getParameter("orderBy");

		ArrayList<Country> listTH = new ArrayList<>();
	
		//check null country
		if (countryName != null && !countryName.equals("")) {
			if(countryName.length() >= 2) {		
				listTH = CountryTHFunction.getCountryTH(countryName, population);
			}
			else {
				request.setAttribute("NotFound", "ไม่พบข้อมูล !!!");
			}
			
		}
		else {
				request.setAttribute("NotFound", "ไม่พบข้อมูล !!!");
		}
		
		//check null population
		if (population != null && !population.equals("")) {
			if(population.length() > 0) {
				listTH = CountryTHFunction.getCountryTH(countryName, population);	
			}	
		}
		
		//check sort
		if(!sorting.equals("")) {
			if(sorting.equals("name")) {
				listTH = CountryTHFunction.getSortbyName(listTH);
			}
			
			else if(sorting.equals("area")) {
				listTH = CountryTHFunction.getSortbyArea(listTH);
			}
			
			else if(sorting.equals("population")) {
				listTH = CountryTHFunction.getSortbyPopulation(listTH);
				
			}
		}
		
		//check order by
		if(!orderBy.equals("")) {
			if(orderBy.equals("desc")) {
				Collections.reverse(listTH);
			}
		}
		
		request.setAttribute("countryTHSearch", listTH);
		request.getServletContext().getRequestDispatcher("/testTH.jsp").forward(request, response);
	}
}

