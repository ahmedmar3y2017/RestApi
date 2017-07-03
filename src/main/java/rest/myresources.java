package rest;

import Entities.Student;
import SingletonHibernate.HibernateConnection;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by programmer on 02/07/17.
 */

@Path("/students")
public class myresources {

    @GET
    @Produces({MediaType.APPLICATION_XML ,MediaType.APPLICATION_JSON})
    public List<Student> GetResources() throws SQLException {
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

//student student1 =new student();
//student1.setUsername("ahmed");
//student1.setPassword("123");
//        student student2 =new student();
//        student2.setUsername("mohamed");
//        student2.setPassword("987");
        SessionFactory sessionFactory = HibernateConnection.GetConnection();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Criteria criteria=session.createCriteria(Student.class);
        java.util.List<Student> list=criteria.list();
        session.getTransaction().commit();
        return  list;

    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML ,MediaType.APPLICATION_JSON})
    public  Student GetStudent(@PathParam("id") int id) throws SQLException {

        SessionFactory sessionFactory = HibernateConnection.GetConnection();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

    Student student=(Student) session.get(Student.class,id);

//       Student student=(Student) criteria.uniqueResult();
        session.getTransaction().commit();

        return  student;

    }



    @POST
    @Path("student")
    @Consumes({MediaType.APPLICATION_XML ,MediaType.APPLICATION_JSON})
    public Student save(Student student){
        SessionFactory sessionFactory = HibernateConnection.GetConnection();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
session.save(student);
        session.getTransaction().commit();

        return  student;
    }



}