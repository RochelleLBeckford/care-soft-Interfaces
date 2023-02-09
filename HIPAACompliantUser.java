//? Interface is a contract
// i hereby promise to implement this method in the class when i implement this interface
public interface HIPAACompliantUser {
    abstract boolean assignPin(int pin);
    abstract boolean accessAuthorized(Integer confirmedAuthID);
}
