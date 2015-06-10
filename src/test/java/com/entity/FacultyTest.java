package com.entity;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FacultyTest {

    @Test
    public void setTitleInConstructor() throws Exception {
        // given
        Faculty faculty = new Faculty("Historical");

        // then
        assertThat(faculty.getTitle(), is("Historical"));
    }


}