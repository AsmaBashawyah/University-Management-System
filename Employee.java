package university.management.system;

public abstract class Employee extends Person {  
    //we must use abstract class to make method abstract
		public Employee(String name, int id) {
			super(name, id);
		}
                
                /*abstract to hide info in sub class
                for each type use different way to calculate Salary*/
		public abstract double calculateSalary();
	}
    
