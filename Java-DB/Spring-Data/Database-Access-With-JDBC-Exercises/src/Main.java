import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_Name = "minions_db";
    private static Connection connection;
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        connection = DriverManager.getConnection(URL + DB_Name, "root", "");

        System.out.print("Enter problem number: ");
        int problemNumber = Integer.parseInt(scan.nextLine());
        switch (problemNumber) {
            case 2 -> problemTwo();
            case 3 -> problemThree();
            case 4 -> problemFour();
            case 5 -> problemFive();
            case 6 -> problemSix();
            case 7 -> problemSeven();
            case 8 -> problemEighth();
            case 9 -> problemNine();
        }

    }

    private static void problemNine() throws SQLException {
        System.out.print("Enter id: ");
        int target_id = Integer.parseInt(scan.nextLine());
        CallableStatement statement =
                connection.prepareCall("CALL usp_get_older(?)");

        statement.setInt(1, target_id);

    }

    private static void problemEighth() throws SQLException {
        int[] ids = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < ids.length; i++) {
            PreparedStatement statement = connection
                    .prepareStatement("UPDATE minions " +
                            "SET name = LOWER(name), " +
                            "    age  = age + 1 " +
                            "WHERE id = ?;");
            statement.setInt(1, ids[i]);
            statement.executeUpdate();
        }

        PreparedStatement statement =
                connection.prepareStatement("SELECT name, age FROM minions");

        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            System.out.printf("%s %d%n"
                    , rs.getString("name")
                    , rs.getInt("age"));
        }
    }

    private static void problemSeven() throws SQLException {
        PreparedStatement statement = connection
                .prepareStatement("SELECT name FROM  minions");

        ResultSet rs = statement.executeQuery();
        List<String> minions = new ArrayList<>();
        while (rs.next()) {
            minions.add(rs.getString("name"));
        }

        int start = 0;
        int end = minions.size() - 1;
        for (int i = 0; i < minions.size(); i += 2) {
            System.out.println(minions.get(start++));
            System.out.println(minions.get(end--));
        }
    }


    private static void problemSix() throws SQLException {
        System.out.print("Enter villain id: ");
        int id = Integer.parseInt(scan.nextLine());
        try {
            String villainName = findEntityById("villains", id);

            PreparedStatement getMinionCntStm = connection
                    .prepareStatement("SELECT v.name, COUNT(mv.minion_id) m_count\n" +
                            "FROM villains v\n" +
                            "         join minions_villains mv on v.id = mv.villain_id\n" +
                            "WHERE villain_id = ?\n" +
                            "GROUP BY v.name;");

            getMinionCntStm.setInt(1, id);
            ResultSet resultSet = getMinionCntStm.executeQuery();
            resultSet.next();
            int minionsReleaseCnt = resultSet.getInt("m_count");


            PreparedStatement releasesMinionsStm = connection
                    .prepareStatement("UPDATE minions_villains\n" +
                            "SET villain_id = null\n" +
                            "WHERE villain_id = ?;");
            releasesMinionsStm.setInt(1, id);
            releasesMinionsStm.executeUpdate();

            PreparedStatement deleteStm = connection
                    .prepareStatement(
                            "DELETE FROM villains\n" +
                                    "WHERE id = ?;");
            deleteStm.setInt(1, id);
            deleteStm.executeUpdate();


            System.out.printf("%s was deleted%n", villainName);
            System.out.printf("%d minions released%n", minionsReleaseCnt);
        } catch (SQLException e) {
            System.out.println("No such villain was found");
        }

    }

    private static void problemFive() throws SQLException {
        System.out.print("Enter country: ");
        String country = scan.nextLine();
        PreparedStatement statement = connection
                .prepareStatement("UPDATE towns " +
                        "SET name = UPPER(name) " +
                        "WHERE country = ?;");
        statement.setString(1, country);
        int affectedRows = statement.executeUpdate();
        if (affectedRows == 0) {
            System.out.println("No town names were affected.");
        } else {
            System.out.printf("%d town names were affected.%n", affectedRows);
            printAllTowns(country, affectedRows);
        }
    }

    private static void problemFour() throws SQLException {
        System.out.println("Enter info for minions");
        String[] minionInfo = scan.nextLine().split("\\s+");
        System.out.println("Enter info for villains");
        String[] villainInfo = scan.nextLine().split("\\s+");

        String minionName = minionInfo[1];
        int minionAge = Integer.parseInt(minionInfo[2]);
        String minionTown = minionInfo[3];

        int townId = entityIsExist("towns", minionTown);
        if (townId == -1) {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO towns(name, country)\n" +
                    "VALUES (?, null);");
            stm.setString(1, minionTown);
            stm.executeUpdate();
            System.out.printf("Town %s was added to the database.%n", minionTown);
        }

        townId = findEntityByName("towns", minionTown);
        PreparedStatement addMinionStm = connection
                .prepareStatement("INSERT INTO minions(name, age, town_id)\n" +
                        "VALUES (?,?,?);");

        addMinionStm.setString(1, minionName);
        addMinionStm.setInt(2, minionAge);
        addMinionStm.setInt(3, townId);
        addMinionStm.executeUpdate();


        String villainName = villainInfo[1];
        int villainId = entityIsExist("villains", villainName);
        if (villainId == -1) {
            PreparedStatement addVillainStm = connection
                    .prepareStatement("INSERT INTO villains(name, evilness_factor)\n" +
                            "VALUES (?, 'evil');");
            addVillainStm.setString(1, villainName);
            addVillainStm.executeUpdate();
            System.out.printf("Villain %s was added to the database.%n", villainName);
        }

        int minionId = findEntityByName("minions", minionName);
        villainId = findEntityByName("villains", villainName);

        PreparedStatement addMinionToVillainStm = connection
                .prepareStatement("INSERT INTO minions_villains(minion_id, villain_id) \n" +
                        "VALUES(?,?);");
        addMinionToVillainStm.setInt(1, minionId);
        addMinionToVillainStm.setInt(2, villainId);
        addMinionToVillainStm.executeUpdate();
        System.out.printf("Successfully added %s to be minion of %s.%n", minionName, villainName);


    }

    private static void problemThree() throws SQLException {
        System.out.print("Enter villain id: ");
        int villainId = Integer.parseInt(scan.nextLine());
        String villainName = "";
        try {
            villainName = findEntityById("villains", villainId);
        } catch (SQLException e) {
            System.out.printf("No villain with ID %d exists in the database.%n", villainId);
            return;
        }

        PreparedStatement preStatement = connection
                .prepareStatement("SELECT v.name, m.name, m.age " +
                        "FROM minions m " +
                        "         join minions_villains mv on m.id = mv.minion_id " +
                        "         join villains v on mv.villain_id = v.id " +
                        "WHERE v.id = ?;");

        preStatement.setInt(1, villainId);
        ResultSet rs = preStatement.executeQuery();

        System.out.printf("Villain: %s%n", villainName);
        while (rs.next()) {
            System.out.printf("%d. %s %d%n"
                    , rs.getRow()
                    , rs.getString("m.name")
                    , rs.getInt("age"));
        }

    }

    private static void problemTwo() throws SQLException {
        PreparedStatement preStatement = connection.prepareStatement(
                "SELECT v.name, COUNT(DISTINCT mv.minion_id) m_count " +
                        "FROM villains v " +
                        "         join minions_villains mv on v.id = mv.villain_id " +
                        "GROUP BY v.name " +
                        "HAVING m_count > 15 " +
                        "ORDER BY m_count DESC;");

        ResultSet resultSet = preStatement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d%n"
                    , resultSet.getString("name")
                    , resultSet.getInt("m_count"));
        }
    }

    private static void printAllTowns(String country, int affectedRows) throws SQLException {
        PreparedStatement statement = connection
                .prepareStatement("SELECT name " +
                        "FROM towns " +
                        "WHERE country = ?");
        statement.setString(1, country);
        ResultSet rs = statement.executeQuery();
        String[] arr = new String[affectedRows];
        int i = 0;
        while (rs.next()) {
            arr[i++] = rs.getString("name");
        }
        System.out.println(Arrays.toString(arr));
    }

    private static int entityIsExist(String tableName, String entityName) throws SQLException {

        PreparedStatement statement
                = connection.prepareStatement("SELECT * \n" +
                "FROM " + tableName + " " +
                "WHERE name = ?");

        statement.setString(1, entityName);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            return rs.getInt("id");

        }

        return -1;
    }

    private static int findEntityByName(String tableName, String entityName) throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement("SELECT id " +
                        "FROM " + tableName + " " +
                        "WHERE name = ?");
        statement.setString(1, entityName);
        ResultSet rs = statement.executeQuery();
        rs.next();
        return rs.getInt("id");
    }

    private static String findEntityById(String tableName, int entityId) throws SQLException {
        PreparedStatement statement =
                connection.prepareStatement("SELECT name " +
                        "FROM " + tableName + " " +
                        "WHERE id = ?");
        statement.setInt(1, entityId);
        ResultSet rs = statement.executeQuery();
        rs.next();
        return rs.getString("name");
    }
}
