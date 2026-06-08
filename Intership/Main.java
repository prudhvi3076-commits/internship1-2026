import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    String department;
    
    Employee(int id , String name, String department ) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
}
public class Main  {
    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        while(true) {
            System.out.println("\n========== Employee Management System ===== ");
            System.out.println(" 1. Add employee ");
            System.out.println(" 2. View employee ");
            System.out.println(" 3. Search employee ");
            System.out.println(" 4. Update department ");
            System.out.println(" 5. Exit");
            System.out.print(" Enter choice ");
            
            int choice = sc.nextInt();
            
            switch( choice ) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployee();
                    break;
                case 3:
                    searchEmployee();
                    break;
                case 4:
                    updateDepartment();
                    break;
                case 5:
                    System.out.println(" Exitinng  .... ");
                    break;
                default :
                    System.out.println(" Invalid choice ");
                
            }
        }
    }
    static void addEmployee() {
        System.out.println( " Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        System.out.println(" Enter nmae : ");
        String name = sc.nextLine();
        
        System.out.println(" Enter Department : ");
        
        String dept = sc.nextLine();
        
        employees.add(new Employee (id , name , dept ));
        
        System.out.println(" Employee added successfully! "); 
    }
    static void viewEmployee() {
        if( employees.isEmpty()) {
            System.out.println(" No employee found . ");
            return;
        }
        System.out.println(" \n Employee Record: ");
        for( Employee e : employees) {
            System.out.println(" ID :" + e.id + " Name: " +e.name + " Department " + e.department );
        }
    }
    static void searchEmployee() {
        System.out.println(" Enter Employee ID: ");
        int id = sc.nextInt();
        for( Employee e : employees ) {
            if( e.id == id ) {
                System.out.println(" Found - > Name: " + e.name + " Department: " + e.department);
                return;
            }
        }
        System.out.println(" Employee not found ");
    }
    static void updateDepartment() {
        System.out.println(" Enter employee id; ");
        int id = sc.nextInt();
        sc.nextLine();
        
        for( Employee e : employees ) {
            if( e.id == id ) {
                System.out.println(" Enter new depaetment: ");
                
                e.department = sc.nextLine();
                
                System.out.println(" System updated successfully! ");
                return;
            }
        }
        System.out.println(" Employee not found . ");
    }
}