import java.util.*;

class Address {
    private String name;
    private String state;

    Address(String name, String state) {
        this.name = name;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", State: " + state;
    }
}

public class j2{
    public static void main(String args []){
        LinkedList<Address> list = new LinkedList<>();
        // Add elements
        list.add(new Address("Arun", "Karnataka"));
        list.add(new Address("Raj", "Tamil Nadu"));
        list.add(new Address("Vani", "Kerala"));
        list.add(new Address("Harshitha", "Karnataka"));

        // Insert at index 1
        list.add(1, new Address("Ram", "Telangana"));

        System.out.println("Original List: ");
        for(Address a:list){
            System.out.println(a);
        }

        // Remove all Kerala People
        list.removeIf(a->a.toString().contains("Kerala"));

        System.out.println("\nAfter Deletion (Kerala): ");
        for(Address a:list){
            System.out.println(a);
        }

        // Remove first and last
        if(!list.isEmpty()) list.removeFirst();
        if(!list.isEmpty()) list.removeLast();

        System.out.println("\nAfter Removing First and Last: ");
        for(Address a:list){
            System.out.println(a);
        }
    }
}