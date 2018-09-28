package Model;

import java.util.Set;

/**
 * 
 * @author d.mikhaylov
 */
public abstract class Employee implements Person {

    private String firstName;
    private String lastName;
    protected Set<RoleEnum> roles;
    private Credential credential;
    
    public Employee(String newFirstName, String newLastName){
        this.firstName = newFirstName;
        this.lastName = newLastName;
    }
    
    
    abstract public String getFullName();
    
    public Boolean isFunctionPermitted(RoleEnum function){
        return roles.contains(function);
    }
    
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }
  
    
    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the credential
     */
    public Credential getCredential() {
        return credential;
    }
    
}
