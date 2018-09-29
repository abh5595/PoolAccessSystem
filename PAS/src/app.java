import Model.Admin;
import Model.Employee;
import Model.Operator;
import Model.Pool;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * 
 * @author d.mikhaylov, David Ortiz
 */
public class app {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);

        Pool pool = new Pool();
        
        /*  
            Employee list (retrieved from "employees.txt" in root directory:
            empID is lastname + first 2 chars of firstname.
        
            empID = scottmi  
            password = mypass
        
            empID = shrutedw
            password = sheriff
        
            empID = squarepantssp
            password = pineapple
        
            empID = starpa
            password = rock
        
        */
         
        System.out.println("--- Login Below ---");
        System.out.print("empID: ");
        String id = scan.nextLine();
        
        boolean isEmpId = pool.doesEmpIdExist(id);
        
        if(isEmpId){
            Employee tempEmp = pool.findEmployee(id);
            
            System.out.print("password: ");
            String pass = scan.nextLine();
            
            if(tempEmp.authenticate(id, pass)) System.out.println("Login succesful!");
            else System.out.println("Login failed, incorrect password.");
            
        } else {
            System.out.println("Login failed, user does not exist.");
        }
        
    }
}
