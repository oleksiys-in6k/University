package university.entity.markDao;

import org.junit.Test;
import university.entity.Course;
import university.entity.Faculty;
import university.entity.Mark;
import university.entity.Student;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

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
        assertThat(mark.getRating(), is(2));
        assertThat(mark.getCourse(), is(course));
        assertThat(mark.getStudent(), is(student));
    }
}