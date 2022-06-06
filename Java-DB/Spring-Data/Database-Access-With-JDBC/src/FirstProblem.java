import java.sql.*;
import java.util.Scanner;

public class FirstProblem {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/soft_uni", "root", "");
        Scanner scan = new Scanner(System.in);

        String salary = scan.nextLine();
        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT * FROM employees WHERE salary > ?");

        preparedStatement.setString(1, salary);

        preparedStatement.executeQuery();
        ResultSet rs = preparedStatement.getResultSet();
        int id = 1;
        while (rs.next()) {
            System.out.println(rs.getString("first_name") + " "
                    + rs.getString("last_name"));
        }
    }
}
