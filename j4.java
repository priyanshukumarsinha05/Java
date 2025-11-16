public class j4 {

    public static void main(String[] args) {

        // Step 1: Create a StringBuffer object
        StringBuffer sb = new StringBuffer("Hello");

        // Step 2: Display initial content and capacity
        System.out.println("Original StringBuffer: " + sb);
        System.out.println("Length: " + sb.length());
        System.out.println("Capacity: " + sb.capacity());   // Default = 16 + initial length

        // Step 3: Append text
        sb.append(", World!");
        System.out.println("\nAfter append: " + sb);

        // Step 4: Insert text
        sb.insert(5, " Java");
        System.out.println("After insert: " + sb);

        // Step 5: Replace text
        sb.replace(6, 10, "Python");
        System.out.println("After replace: " + sb);

        // Step 6: Delete part of text
        sb.delete(6, 12);
        System.out.println("After delete: " + sb);

        // Step 7: Reverse the string
        sb.reverse();
        System.out.println("After reverse: " + sb);

        // Step 8: Reverse again to restore original
        sb.reverse();

        // Step 9: Set character at a position
        sb.setCharAt(0, 'h');
        System.out.println("After setCharAt(0, 'h'): " + sb);

        // Step 10: Ensure capacity
        sb.ensureCapacity(100);
        System.out.println("Capacity after ensureCapacity(100): " + sb.capacity());

        // Step 11: Trim capacity to current size
        sb.trimToSize();
        System.out.println("Capacity after trimToSize(): " + sb.capacity());

        // Step 12: Delete a single character
        sb.deleteCharAt(5);
        System.out.println("After deleteCharAt(5): " + sb);
    }
}
