package JAVApractice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");

        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:sqliteSample.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            // statement.executeUpdate("drop table if exists tableName");

            /* CREATE TABLE, comment out if you want to append data, NOT redo! */
            // statement.executeUpdate("create table tableName (id integer PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE, name string, score integer)");

            /* ADD STATEMENT */
            //statement.executeUpdate("insert into tableName values(1, 'NEW', 40)");

            /* DELETE STATEMENT */
           // statement.executeUpdate("DELETE FROM tableName WHERE id = 1");

            /* FULL TABLE DISPLAY */
//            String q = "SELECT * FROM tableName";
//            ResultSet rs = statement.executeQuery(q);
//            // * = all
//            while(rs.next())
//            {
//                // read the result set
//                System.out.println("name = " + rs.getString("name"));
//                System.out.println("id = " + rs.getInt("id"));
//                System.out.println("score = " + rs.getInt("score"));
//            }

            /* ONLY MAX score DISPLAY */
            String q = "SELECT * FROM tableName WHERE score = (SELECT MAX(score) FROM tableName)\n";
            ResultSet rs = statement.executeQuery(q);
            // * = all
            if(rs.next())
            {
                // read the result set
              System.out.println("score = " + rs.getInt("score"));
                System.out.println("name = " + rs.getString("name") + "\n");
                     }






        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }
}