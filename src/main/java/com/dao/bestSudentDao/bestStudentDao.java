package com.dao.bestSudentDao;

import com.entity.Faculty;
import com.entity.Student;

/**
 * Created by employee on 6/10/15.
 */
public interface bestStudentDao {
    Student getBestStudent(Faculty faculty);
}
