import java.sql.*;
import java.util.Scanner;

public class SecondProblem {
    public static void main(String[] args) throws SQLException {

        Scanner scan = new Scanner(System.in);
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/diablo", "root", "");

        StringBuilder sql = new StringBuilder("SELECT user_name, first_name, last_name, name AS game_name\n" +
                "FROM users AS u\n" +
                "JOIN users_games AS ug ON u.id = ug.user_id\n" +
                "JOIN games g on g.id = ug.game_id\n" +
                "WHERE user_name = ?");

        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        String userName = scan.nextLine();
        preparedStatement.setString(1, userName);
        ResultSet rs = preparedStatement.executeQuery();

        if (rs == null) {
            System.out.println("No such user exists");
        } else {

            rs.next();
            int gamesCnt = 1;
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            while (rs.next()) {
                gamesCnt++;
            }

            System.out.println("User: " + userName);
            System.out.printf("%s %s has played %d games%n"
                    , first_name, last_name, gamesCnt);

        }


    }
}
