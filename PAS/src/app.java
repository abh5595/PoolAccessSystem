import Model.Admin;
import Model.Pool;
import java.util.Scanner;


/**
 * 
 * @author d.mikhaylov
 */
public class app {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pool pool = new Pool();
        
        Admin testAdmin = new Admin("Michael", "Scott");
        testAdmin.setCredential("mypass");
        
        Scanner scan = new Scanner(System.in);
        
        /*
            empID = scottmi  (lastname + first 2 chars of firstname)
            password = mypass
        */
         
        System.out.println("--- Login Below ---");
        System.out.print("empID: ");
        String id = scan.nextLine();
        System.out.print("password: ");
        String pass = scan.nextLine();

        
        System.out.println("access? "+testAdmin.authenticate(id, pass));
        
    }
    
}
