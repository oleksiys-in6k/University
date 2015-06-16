package university.MarkIO.writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import university.dao.markDao.MarkDao;
import university.entity.Mark;
import university.service.markService.MarkService;

import java.sql.SQLException;

@Transactional
public class MarkWriterImpl implements MarkWriter {

    @Autowired
    private MarkService markService;

    public void saveMark(Mark mark){
        markService.addMark(mark);
    }
}
