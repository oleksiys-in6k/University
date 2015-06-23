package university.entity;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StudentTest {

    @Test
    public void fulfilsStudent() throws Exception {
        // given
        Faculty historicalFaculty = new Faculty("Historical");
        Student student = new Student("Josh Smith", historicalFaculty, "pas1", "pas1");

        // when
//        Mark mark = new Mark(student, course, 2);

        // then
        assertThat(student.getName(), is("Josh Smith"));
        assertThat(student.getFaculty(), is(historicalFaculty));

    }
}