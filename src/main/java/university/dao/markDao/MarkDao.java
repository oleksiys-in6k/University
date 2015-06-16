package university.dao.markDao;


import university.entity.Mark;

import java.sql.SQLException;
import java.util.List;

public interface MarkDao {

    void addMark(Mark mark);
    Mark getMarkById(Integer id);
    List getAllMarks();
    void deleteMark(Mark mark);


}
