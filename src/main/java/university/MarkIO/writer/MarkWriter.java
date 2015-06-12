package university.MarkIO.writer;

import university.entity.Mark;

import java.sql.SQLException;


public interface MarkWriter {
    void saveMark(Mark mark) throws SQLException;
}
