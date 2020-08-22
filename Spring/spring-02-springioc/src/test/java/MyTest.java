import com.pojo.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @anthor Tolaris
 * @date 2020/4/5 - 15:28
 */
public class MyTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());
    }

}
