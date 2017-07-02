package rest;


import java.sql.*;

/**
 * Created by programmer on 02/07/17.
 */
public class databaseConnection {

public static Connection GetConnection(){
    java.sql.Connection conn = null;


    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
    } catch (Exception e) {
        e.printStackTrace();
    }

    return  conn;

}

    public static void main(String[] args) throws SQLException {
    Connection connection=  databaseConnection.GetConnection();
PreparedStatement preparedStatement=connection.prepareStatement("select * from student");
ResultSet resultSet=preparedStatement.executeQuery();

while(resultSet.next()){

    System.out.println(resultSet.getString("username"));


}




    }


}
