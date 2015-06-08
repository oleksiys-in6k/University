package com.dao.MarkDao;


import com.entity.Mark;
import com.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface IMarkDao {

    void addMark(Mark mark) throws SQLException;
    Mark getMarkById(Long id) throws SQLException;
    List getAllMarks() throws SQLException;
    void deleteMark(Mark mark) throws SQLException;
    String getBestStudentEver() throws SQLException;
    Student getBestStudent() throws SQLException;


}
