package Model;

/**
 *
 * @author d.mikhaylov
 */
public class Credential {

    private String emplID;
    private String password;

    public Credential(String firstName, String lastName, String newPassword) {
        emplID = ("" + firstName.toUpperCase().charAt(0) + lastName.toUpperCase().charAt(0) + ((int) Math.random() * 10000));
        password = newPassword;
    }
   
    
}
