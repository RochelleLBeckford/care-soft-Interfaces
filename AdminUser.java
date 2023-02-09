import java.util.ArrayList;
import java.util.Date;
//... imports class definition...

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin{
    //... imports class definition...
    
    // Inside class:
    // private Integer employeeID; -> this is not being used anywhere
    private String role;
                                                //? have to add this 
    private ArrayList<String> securityIncidents = new ArrayList<>();
    
    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(Integer id, String role ) {
        super(id);
        this.role = role;

        //TODO Auto-generated constructor stub
    }
    
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }

    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

    // TODO: Implement HIPAACompliantAdmin!
    @Override
    public ArrayList<String> reportSecurityIncidents() {
        // TODO Auto-generated method stub
        // return null;
        return securityIncidents;
    }

    // TODO: Implement HIPAACompliantUser!
    @Override
    public boolean assignPin(int pin) {
        // TODO Auto-generated method stub
        int numlen = Integer.toString(pin).length();
        // System.out.println(numlen == 6);
        if (numlen == 6) {
            return true;
        } else {
            return false;
        }
        // return false;
        // return numlen == 6;
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        // TODO Auto-generated method stub
        System.out.println(confirmedAuthID);
        if (confirmedAuthID == this.getId()) {
            return true;
        } else {
            authIncident();
            return false;
        }
        // return false;
    }
    
    // TODO: Setters & Getters

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<String> getSecurityIncidents() {
        return this.securityIncidents;
    }

    public void setSecurityIncidents(ArrayList<String> securityIncidents) {
        this.securityIncidents = securityIncidents;
    }


}
