package university.entity;

import org.junit.Test;
import university.entity.Course;
import university.entity.Faculty;
import university.entity.Mark;
import university.entity.Student;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by employee on 6/8/15.
 */
public class MarkTest {

    @Test
    public void fulfilsMarkInConstructor() throws Exception {
        // given
        Faculty faculty = new Faculty("faculty");
        Student student = new Student("name", faculty);
        Course course = new Course(faculty, "course");

        // when
        Mark mark = new Mark(student, course, 2);

        // then
        assertThat(mark.getMark(), is(2));
        assertThat(mark.getCourse(), is(course));
        assertThat(mark.getStudent(), is(student));
    }
}