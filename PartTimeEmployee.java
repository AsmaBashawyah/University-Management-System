package university.management.system;

public class PartTimeEmployee extends Employee {
        private double hourlyRate;
	private int hoursWorked;
	
	public PartTimeEmployee(String name, int id, double hourlyRate, int hoursWorked) {
            super (name, id);
            this.hourlyRate = hourlyRate;
            this.hoursWorked = hoursWorked;
        }
        @Override
       public double calculateSalary() {
           return hourlyRate * hoursWorked;
       }

    @Override
   public void displayDetails() {
        System.out.printf("%n+==============================+");
        System.out.printf("%n|      Part Time Employee      |");
        System.out.printf("%n+==============================+");
        System.out.printf("%n| Name: %-23s|" , name);
        System.out.printf("%n| ID: %-25s|" , id);
        System.out.printf("%n| Salary: %-21s|" , calculateSalary());
        System.out.println("\n--------------------------------");

    }
}