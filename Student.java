package university.management.system;

public class Student extends Person {
    private String course;
    private double grade;
    
    

    public Student(String name, int id, String course, double grade) {
        super(name, id);
        this.course = course;
        this.grade = grade;
    }
    
    public boolean isPass(){
        return grade >= 50;
    }
    
    
    @Override
            public void displayDetails() {
           
        System.out.printf("%n+==============================+");
        System.out.printf("%n|           STUDENT            |");
        System.out.printf("%n+==============================+");
        System.out.printf("%n| Name: %-23s|"  , name );
        System.out.printf("%n| ID:  %-23s |", id);
        System.out.printf("%n| Course: %-21s|" , course);
        System.out.printf("%n| Grade: %-21s |", grade);
        // to show the result of ( isPass() ) 
        System.out.printf("%n| Status: %-21s|",isPass() ? "Pass": "Fail");
        System.out.println("\n--------------------------------");

    }
}  