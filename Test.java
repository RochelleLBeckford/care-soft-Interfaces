public class Test {
    public static void main(String[] args) {
        // .. Main method set up ... //
        Physician doctor10 = new Physician(1);
        AdminUser roseTyler = new AdminUser(2, "Companion");
        AdminUser donnaNoble = new AdminUser(3, "Companion");
        
        System.out.println(doctor10.getId());
        System.out.println(roseTyler.getId());
        System.out.println(donnaNoble.getId());
        
        // Physician Implementation Tests
        System.out.println("\n==</span>======== Physician Tests ==========\n");
        //& if this is false it returns pass
        //? should be false b/c it is not atleast 4 digits long -> false should return pass
        String pinTest1 = doctor10.assignPin(42)? "FAIL" : "PASS";
        System.out.printf("Physician pin assign test 1: %s\n", pinTest1);
        
        //? this should be true b/c atleast 4 digits long -> true should return pass
        String pinTest2 = doctor10.assignPin(4000)? "PASS" : "FAIL";
        System.out.printf("Physician pin assign test 2: %s\n", pinTest2);
        
        //? return false when suppose to and return true otherwise
        //~ this should be false so will print out pass
        String authTest1 = doctor10.accessAuthorized(1234)? "FAIL" : "PASS";
        System.out.printf("Physician auth test 1: %s\n", authTest1);
        
        //~ this should be true and will print out pass
        String authTest2 = doctor10.accessAuthorized(1)? "PASS" : "FAIL";
        System.out.printf("Physician auth test 2: %s\n", authTest2);
        
        // AdminUser Implementation Tests
        System.out.println("\n========== AdminUser Tests ==========\n");
        String pinTest3 = roseTyler.assignPin(42)? "FAIL" : "PASS";
        System.out.printf("Admin pin assign test 1: %s\n", pinTest3);
        
        String pinTest4 = roseTyler.assignPin(424242)? "PASS" : "FAIL";
        System.out.printf("Admin pin assign test 2: %s\n", pinTest4);
        
        String authTest3 = roseTyler.accessAuthorized(1234)? "FAIL" : "PASS";
        System.out.printf("Admin auth test 1: %s\n", authTest3);
        
        String authTest4 = roseTyler.accessAuthorized(1234)? "FAIL" : "PASS";
        System.out.printf("Admin auth test 1: %s\n", authTest4);
        
        String authTest5 = roseTyler.accessAuthorized(2)? "PASS" : "FAIL";
        System.out.printf("Admin auth test 2: %s\n\n", authTest5);
        
        donnaNoble.accessAuthorized(42);
        donnaNoble.accessAuthorized(4321);
        donnaNoble.accessAuthorized(7);
        donnaNoble.accessAuthorized(28);
        
        System.out.println(donnaNoble.reportSecurityIncidents());

    }
}
