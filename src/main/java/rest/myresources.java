package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by programmer on 02/07/17.
 */

@Path("/myresources")
public class myresources {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String GetResources() throws SQLException {
String names="";
        Connection connection=  databaseConnection.GetConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("select * from student");
        ResultSet resultSet=preparedStatement.executeQuery();

        while(resultSet.next()){

           names+= resultSet.getString("username");


        }


        return  names;

    }

}