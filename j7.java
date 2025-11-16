import java.sql.*;
import java.util.Scanner;

public class j7 {
    // DB details
    static final String DB_URL = "";
    static final String USER = "";
    static final String PASS = "";

    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n --- Student Database Menu ---");
                System.out.println("1. Insert Student");
                System.out.println("2. Update Student");
                System.out.println("3. Delete Student");
                System.out.println("4. Search Student");
                System.out.println("5. Display All Students");
                System.out.println("6. Exit");
                System.out.print("Enter Your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        insertStudent(conn, scanner);
                        break;
                    case 2:
                        updateStudent(conn, scanner);
                        break;
                    case 3:
                        deleteStudent(conn, scanner);
                        break;
                    case 4:
                        searchStudent(conn, scanner);
                        break;
                    case 5:
                        dispalyAllStudent(conn);
                        break;
                    case 6:
                        System.out.println("Exiting ...");
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    static void insertStudent(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter Name: ");
        scanner.nextLine(); // consumes newline
        String name = scanner.nextLine();

        System.out.print("Enter Grade: ");
        double grade = scanner.nextDouble();

        String sql = "INSERT INTO Student VALUES (?, ?, ?)";

        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setDouble(3, grade);  

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " student inserted.");
        }
    }

    static void updateStudent(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter New name: ");
        scanner.nextLine(); // consumes newline
        String name = scanner.nextLine();

        System.out.print("Enter new Grade: ");
        double grade = scanner.nextDouble();

        String sql = "UPDATE Student SET name = ?, grade = ? WHERE id = ?";

        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, name);
            pstmt.setDouble(2, grade);  
            pstmt.setInt(3, id);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " student updated.");
        }
    }

    static void deleteStudent(Connection conn, Scanner scanner) throws SQLException {
        System.out.println("Enter ID of student to delete: ");
        int id = scanner.nextInt();
        String sql = "DELETE FROM Student WHERE id = ?";

        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " student inserted.");
        }
    }

    static void searchStudent(Connection conn, Scanner scanner) throws SQLException{
        System.out.println("Enter ID to search: ");
        int id = scanner.nextInt();

        String sql = "SELECT * FROM Student WHERE id = ?";

        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                System.out.println("ID: " + rs.getInt("id") + 
                    ", Name: " + rs.getString("name") + 
                    ", Grade: " + rs.getDouble("grade")
                );
            }
            else{
                System.out.println("Student not found");
            }
        }
    }

    static void dispalyAllStudent(Connection conn) throws SQLException{
        String sql = "SELECT * FROM Student";

        try(Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("\nAll Students: ");

            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id")
                    + ", Name: " + rs.getString("name") + 
                    ", Grade: " + rs.getDouble("grade")
                );
            }
        }
    }

}