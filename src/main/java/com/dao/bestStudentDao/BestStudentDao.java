package com.dao.bestStudentDao;

import com.entity.Faculty;
import com.entity.Student;

/**
 * Created by employee on 6/10/15.
 */
public interface BestStudentDao {
    Student getBestStudent(Faculty faculty);
}
