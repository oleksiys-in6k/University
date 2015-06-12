package university.run;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Main {
    static String input = "1\n1\n1\n";


    public static void main(String[] args) throws SQLException {

        BeanFactory factory = new ClassPathXmlApplicationContext("database.xml");
        University universityClass = factory.getBean(University.class);
        universityClass.execute();
    }
}
