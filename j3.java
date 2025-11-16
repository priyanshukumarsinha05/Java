public class j3{
    public static void main(String[] args){
        String s1 = "Hello World";
        String s2 = "hello world";

        System.out.println("Original String"+ s1);

        // Character Extraction
        System.out.println("Character at index 4: "+ s1.charAt(4));

        // String comparision
        System.out.println("s1.equals(s2): " + s1.equals(s2));
        System.out.println("s1.equalsIgnoreCase(s2): " + s1.equalsIgnoreCase(s2));
        System.out.println("s1.compareTo(s2): " + s1.compareTo(s2));
        System.out.println("s1.compareToIgnoreCase(s2): "+ s1.compareToIgnoreCase(s2));

        // String Search
        System.out.println("index of 'World': "+ s1.indexOf("World"));
        System.out.println("index of 'o': "+ s1.indexOf('o'));
        System.out.println("Last Index of 'o': "+ s1.lastIndexOf('o'));
        System.out.println("Starts with 'Hello' : "+ s1.startsWith("Hello"));
        System.out.println("Ends with 'ld': "+ s1.endsWith("ld"));

        // String Modification
        System.out.println("\n--- String Modification ---");
        System.out.println("Uppercase: " + s1.toUpperCase());
        System.out.println("Lowercase: " + s1.toLowerCase());
        System.out.println("Replace 'World' → 'Java': " + s1.replace("World", "Java"));
        System.out.println("Substring (6 to 11): " + s1.substring(6, 11));
        System.out.println("Concatenation: " + s1.concat(" Programming"));

        // Split 
        System.out.println("\nSplit by space:");
        String[] words = s1.split(" ");
        for (String w : words) {
            System.out.println("-> " + w);
        }
    }
}