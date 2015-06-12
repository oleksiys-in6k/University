package university.MarkIO.writer;

import university.dao.markDao.MarkDao;
import university.entity.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import university.dao.markDao.MarkDaoImpl;

import java.sql.SQLException;

@Transactional
public class MarkWriterImpl implements MarkWriter {

    @Autowired
    private MarkDao markDao;

    public void saveMark(Mark mark) throws SQLException {
        markDao.addMark(mark);
    }

    public void setMarkDao(MarkDaoImpl markDao) {
        this.markDao = markDao;
    }
}
