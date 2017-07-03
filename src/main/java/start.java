import Entities.Student;
import SingletonHibernate.HibernateConnection;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by programmer on 02/07/17.
 */
public class start {


    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateConnection.GetConnection();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Criteria criteria=session.createCriteria(Student.class);
        java.util.List<Student> list=criteria.list();
        for (Student student : list){

            System.out.println(student.getUsername());

        }
//        Student student=new Student();
//        student.setUsername("mohamed");
//        student.setAddress("cairo");
//        session.save(student);

        session.getTransaction().commit();
    }
}
