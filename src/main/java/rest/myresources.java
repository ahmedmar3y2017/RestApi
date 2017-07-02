package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by programmer on 02/07/17.
 */

@Path("/myresources")
public class myresources {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<student>  GetResources() throws SQLException {
//String names="";
//        Connection connection=  databaseConnection.GetConnection();
//        PreparedStatement preparedStatement=connection.prepareStatement("select * from student");
//        ResultSet resultSet=preparedStatement.executeQuery();
//
//        while(resultSet.next()){
//
//           names+= resultSet.getString("username");
//
//
//        }

student student1 =new student();
student1.setUsername("ahmed");
student1.setPassword("123");
        student student2 =new student();
        student2.setUsername("mohamed");
        student2.setPassword("987");
        List<student> arrayList= Arrays.asList(student1,student2);

        return  arrayList;

    }

}