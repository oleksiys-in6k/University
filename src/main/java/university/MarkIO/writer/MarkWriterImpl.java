package university.MarkIO.writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import university.dao.markDao.MarkDao;
import university.entity.Mark;

import java.sql.SQLException;

@Transactional
public class MarkWriterImpl implements MarkWriter {

    @Autowired
    private MarkDao markDao;

    public void saveMark(Mark mark) throws SQLException {
        markDao.addMark(mark);
    }
}
