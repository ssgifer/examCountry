package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestJavaTH {
	
    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);
        System.out.println("Search : ");
        String str = myObj.nextLine();
        
        System.out.println("Search : ");
        String pop = myObj.nextLine();
        
        ArrayList<Country> listTH = CountryTHFunction.getCountryTH(str, pop);
//        System.out.println(CountryTHFunction.getSortbyPopulation(listTH));
        
        for(Country country: listTH) {
        	System.out.println("Country : " + country.getName() + "\t" + "Area : " + country.getArea() + "\t" + " " + "Population : " + country.getPeople());
        }
        
//        System.out.println("Search : ");
//        String sort = myObj.nextLine();
//        System.out.println(CountryListFunction.getCountry(str, pop));
    }    
}

