package university.dao.markDao;


import university.entity.Mark;

import java.sql.SQLException;
import java.util.List;

public interface MarkDao {

    void addMark(Mark mark) throws SQLException;
    Mark getMarkById(Integer id) throws SQLException;
    List getAllMarks() throws SQLException;
    void deleteMark(Mark mark) throws SQLException;
//    Student getBestStudent() throws SQLException;


}
