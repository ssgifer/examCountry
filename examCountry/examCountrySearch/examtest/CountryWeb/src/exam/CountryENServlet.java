package exam;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class CountryENServlet extends HttpServlet {
	
	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	}
	
	@Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String countryName = request.getParameter("countryName");
		String area = request.getParameter("area");
		String population = request.getParameter("population");
		String sorting = request.getParameter("sorting");
		String orderBy = request.getParameter("orderBy");
//		String sumPopulation = request.getParameter("sumPopulation");
//		String sumArea = request.getParameter("sumArea");
		
		ArrayList<Country> listEN = new ArrayList<>();
	
		//check null country
		if (countryName != null && !countryName.equals("")) {
			if(countryName.length() >= 2) {		
				listEN = CountryENFunction.getCountryEN(countryName, population);
			}	
			else {
				request.setAttribute("NotFound", "Data Not Found!!!");
			}
			
		}
		else {
				request.setAttribute("NotFound", "Data Not Found!!!");
		}
		
		//check null population
		if (population != null && !population.equals("")) {
			if(population.length() > 0) {
				listEN = CountryENFunction.getCountryEN(countryName, population);	
			}	
		}
		
		//check sort
		if(!sorting.equals("")) {
			if(sorting.equals("name")) {
				listEN = CountryENFunction.getSortbyName(listEN);
			}
			
			else if(sorting.equals("area")) {
				listEN = CountryENFunction.getSortbyArea(listEN);
			}
			
			else if(sorting.equals("population")) {
				listEN = CountryENFunction.getSortbyPopulation(listEN);
				
			}
		}
		
		//check order by
		if(!orderBy.equals("")) {
			if(orderBy.equals("desc")) {
				Collections.reverse(listEN);
			}
		}
		
		request.setAttribute("countryENSearch", listEN);
		request.getServletContext().getRequestDispatcher("/testEN.jsp").forward(request, response);
	}
}
	