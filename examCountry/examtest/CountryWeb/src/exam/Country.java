package exam;

public class Country {
	
		private String name;
		private double area;
		private int people;
		
		public Country() {
			
		}
		public Country(String name , double area , int people) {
			setName(name);
			setArea(area);
			setPeople(people);
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public double getArea() {
			return area;
		}
		
		public void setArea(double area) {
			this.area = area;
		}
		
		public int getPeople() {
			return people;
		}
		
		public void setPeople(int people) {
			this.people = people;
		}
		  
		
}
