package university.management.system;

public class FullTimeEmployee extends Employee {
	private double monthlySalary;
	
public FullTimeEmployee(String name, int id, double monthlySalary)  {
	super(name, id);
	this.monthlySalary = monthlySalary;
}
        @Override
        public double calculateSalary() {
	return monthlySalary;
}

   
    @Override
        public void displayDetails(){
        System.out.printf("%n+==============================+");
        System.out.printf("%n|      Full Time Employee      |");
        System.out.printf("%n+==============================+");
        System.out.printf("%n| Name: %-23s|" , name);
        System.out.printf("%n| ID: %-24s |", id);
        System.out.printf("%n| Salary: %-20s | " , calculateSalary());
        System.out.println("\n--------------------------------");

}
        }