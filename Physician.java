import java.util.ArrayList;
import java.util.Date;

//? Physician - Will implement HIPAACompliantUser and extend User
// -> a contract -> agreeing that this class will implement these methods -> so the params have to be in the class that is using the interface
// -> Physician is a User as well 
// -> it’s for stuff that isn’t necessarily confined to a class. it’s like birds can fly, but so can airplanes
public class Physician extends User implements HIPAACompliantUser{
    //... imports class definition...
    
    // Inside class:    
    private ArrayList<String> patientNotes;
	
    // TODO: Constructor that takes an ID
	// want to call the parent w/i the child use super
    public Physician(Integer id) {
        super(id);
        
    }
    
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
            report += String.format("Reported By ID: %s\n", this.id);
            report += String.format("Patient Name: %s\n", patientName);
            report += String.format("Notes: %s \n", notes);
            this.patientNotes.add(report);
        }

    // TODO: Implement HIPAACompliantUser!
    @Override
    public boolean assignPin(int pin) {
        // TODO Auto-generated method stub
        //? getting PASS here b;/c returning false randomly 
        //~ we would have to check if pin iid 4 digits long
        //~ will print out what pin is
        //~ want to find how to print the length of an integer in java
        // will give the length of the 1st test that is run
        int numlen = Integer.toString(pin).length();
        // have this print to see if pin is >= 4 digits is true or false
        // System.out.println(numlen == 4);
        // if (numlen != 4) {
        //     return false;
        // }else {
        //     return true;
        // }
        // if (numlen == 4) {
        //     return true;
        // }else {
        //     return false;
        // }
        //? can just replace the if and return the below
        // -> just checking the truth of the value
        return numlen == 4;
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        // TODO Auto-generated method stub
        //? print out what the ID is 
        // wants us to compare if they are a match or not 
        //if match then true of not false
        // when make a physician determine id from user id 
        System.out.println(confirmedAuthID);
        // id should be 1
        // test 1 should fail b/c 1234 does not match 1
        //test 2 passes b/c 1 = 1 
        System.out.println(this.id);
        System.out.println(confirmedAuthID == this.id);
        // return false
        return confirmedAuthID == this.id;
    }
        
    // TODO: Setters & Getters
    public ArrayList<String> getPatientNotes() {
        return this.patientNotes;
    }

    public void setPatientNotes(ArrayList<String> patientNotes) {
        this.patientNotes = patientNotes;
    }

}

