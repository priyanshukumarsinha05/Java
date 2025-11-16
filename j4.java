public class j4 {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello");

        System.out.println("Original StringBuffer: " + sb);
        System.out.println("Length: " + sb.length());
        System.out.println("Capacity: " + sb.capacity()); 

        sb.append(", World!");
        System.out.println("\nAfter append: " + sb);

        sb.insert(5, " Java");
        System.out.println("After insert: " + sb);

        sb.replace(6, 10, "Python");
        System.out.println("After replace: " + sb);

        sb.delete(6, 12);
        System.out.println("After delete: " + sb);

        sb.reverse();
        System.out.println("After reverse: " + sb);

        sb.reverse();

        sb.setCharAt(0, 'h');
        System.out.println("After setCharAt(0, 'h'): " + sb);

        sb.ensureCapacity(100);
        System.out.println("Capacity after ensureCapacity(100): " + sb.capacity());

        sb.trimToSize();
        System.out.println("Capacity after trimToSize(): " + sb.capacity());

        sb.deleteCharAt(5);
        System.out.println("After deleteCharAt(5): " + sb);
    }
}
