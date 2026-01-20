package university.management.system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UniversityManagementSystem {

    // ------- Single list for Students + Employees ---------
    private static final List<Person> records = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
            // ------- Sample Data: 4 students as an example ------
    records.add(new Student("Hala", 1011, "Mathematics", 40.0));
    records.add(new FullTimeEmployee("Fatema", 7027, 3000.0));
    records.add(new PartTimeEmployee("Sara", 7033, 50.5, 7));
    records.add(new Student("Lina", 1046, "Computer Science", 99.0));
        
    // ------- loop to show the menu and handle user choices -------
        while (true) {
            printMenu();
            int choice = readIntInRange("Choose (1-5): ", 1, 5);
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> addFullTimeEmployee();
                case 3 -> addPartTimeEmployee();
                case 4 -> displayAll();
                case 5 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
            }
            System.out.println(); // spacer
        }
    } // end of main

    // -------- Display Menu --------
    private static void printMenu() {
        System.out.println("\n===== University Management (Console) =====");
        System.out.println("1) Add Student");
        System.out.println("2) Add Full-time Employee");
        System.out.println("3) Add Part-time Employee");
        System.out.println("4) Display All Records");
        System.out.println("5) Exit");
    }

    // -------- Actions in menu --------
    // ------ 1) add student -------
    private static void addStudent() {
        System.out.println("\n-- Add Student --");
        String name = readNonEmpty("Name: ");
        int id = readUniqueId("ID (>=0): ");
        String course = readNonEmpty("Course: ");
        double grade = readDoubleInRange("Grade (0-100): ", 0.0, 100.0);

        records.add(new Student(name, id, course, grade));
        System.out.println("Student added.");
        waitForEnter();  // wait for Enter from user
    }
    // ------ 2) add Full Time Employee -------
    private static void addFullTimeEmployee() {
        System.out.println("\n-- Add Full-time Employee --");
        String name = readNonEmpty("Name: ");
        int id = readUniqueId("ID (>=0): ");
        double salary = readDoubleMin("Monthly Salary (>=0): ", 0.0);

        records.add(new FullTimeEmployee(name, id, salary));
        System.out.println("Full-time employee added.");
        waitForEnter(); // wait for Enter from user
    }
// ------- 3) add Part Time Employee -------
    private static void addPartTimeEmployee() {
        System.out.println("\n-- Add Part-time Employee --");
        String name = readNonEmpty("Name: ");
        int id = readUniqueId("ID (>=0): ");
        double rate = readDoubleMin("Hourly Rate (>=0): ", 0.0);
        int hours = readIntMin("Hours per week (>=0): ", 0);

        records.add(new PartTimeEmployee(name, id, rate, hours));
        System.out.println("Part-time employee added.");
        waitForEnter(); // wait for Enter from user
    }
// ------- 4) dispaly all records -------
    private static void displayAll() {
        System.out.println("\n-- All Records --");
  // ------- if there is no records -------
        if (records.isEmpty()) {
            System.out.println("No records yet.");
                    waitForEnter();

            return;
        }
        // ------- else if there is recods count and dispaly ------- 
        int i = 1;
        for (Person p : records) {
            System.out.print(i++ + ") ");
            p.displayDetails();          // uses your nice formatted output
        }
        System.out.printf("%nTotal: %d%n", records.size());
        waitForEnter(); // wait for Enter from user
    
    }
    

    // -------- Validation for not empty value --------
    private static String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Please enter a non-empty value.");
        }
    }
//------- Validates that the (ID) is an integer >= the minimum allowed value (0) -------
    private static int readIntMin(String prompt, int minInclusive) {
        while (true) {
            try {
                System.out.print(prompt);
                String s = sc.nextLine().trim();
                int v = Integer.parseInt(s);
                if (v < minInclusive) {
                    System.out.printf("Value must be >= %d.%n", minInclusive);
                } else return v;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }
    
    // ------ Validates (menu choice) is an integer within the range (1–5) -------
    private static int readIntInRange(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                String s = sc.nextLine().trim();
                int v = Integer.parseInt(s);
                if (v < min || v > max) {
                    System.out.printf("Value must be between %d and %d.%n", min, max);
                } else return v;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }
// ------ Validates the double for (Monthly Salary) or (Hourly Rate) to be in range -------
    private static double readDoubleMin(String prompt, double minInclusive) {
        while (true) {
            try {
                System.out.print(prompt);
                String s = sc.nextLine().trim();
                double v = Double.parseDouble(s);
                if (v < minInclusive) {
                    System.out.printf("Value must be >= %.2f.%n", minInclusive);
                } else return v;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    
// ------ Validates that the (grade) is a double within the range (0–100) -------
    private static double readDoubleInRange(String prompt, double min, double max) {
        while (true) {
            try {
                System.out.print(prompt);
                String s = sc.nextLine().trim();
                double v = Double.parseDouble(s);
                if (v < min || v > max) {
                    System.out.printf("Value must be between %.2f and %.2f.%n", min, max);
                } else return v;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
        // -------- Duplicate ID Prevention --------
    /**
     * Checks if an ID already exists in the records
     * @param id The ID to check
     * @return true if ID exists, false otherwise
     */
    private static boolean isIdExists(int id) {
        for (Person p : records) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Reads a unique ID that doesn't already exist in the system
     * @param prompt The prompt message to display
     * @return A unique, valid ID (>= 0)
     */
    private static int readUniqueId(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String s = sc.nextLine().trim();
                int v = Integer.parseInt(s);
                
                // Check if ID is negative
                if (v < 0) {
                    System.out.println(" Error: ID must be >= 0.");
                    continue;
                }
                
                // Check for duplicate ID
                if (isIdExists(v)) {
                    System.out.printf(" Error: ID %d already exists. Please enter a different ID.%n", v);
                    continue;
                }
                
                return v;
            } catch (NumberFormatException e) {
                System.out.println(" Error: Please enter a valid integer.");
            }
        }
    }
// -------- Helpe to pause before returning to menu --------
private static void waitForEnter() {
    System.out.print("\n Press Enter to return to menu...");
    sc.nextLine(); // wait for Enter from user
}
} // end of class
