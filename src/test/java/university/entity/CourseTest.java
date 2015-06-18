package university.entity;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CourseTest {

    @Test
    public void fulfilsCourse() throws Exception {
        // given
        Faculty historicalFaculty = new Faculty("Historical");
        Course course = new Course(historicalFaculty, "Ancient history");

        // when
//        Mark mark = new Mark(student, course, 2);

        // then
        assertThat(course.getTitle(), is("Ancient history"));
        assertThat(course.getFaculty(), is(historicalFaculty));

    }
}
