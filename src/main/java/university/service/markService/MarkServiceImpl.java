package university.service.markService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.dao.markDao.MarkDao;
import university.entity.Mark;

import java.util.List;

@Service
@Transactional
public class MarkServiceImpl implements MarkService {

    @Autowired
    private MarkDao markDao;

    @Override
    public void addMark(Mark mark) {
        markDao.addMark(mark);
    }

    @Override
    public Mark getMarkById(Integer id) {
        return markDao.getMarkById(id);
    }

    @Override
    public List getAllMarks() {
        return markDao.getAllMarks();
    }

    @Override
    public void deleteMark(Mark mark) {
        markDao.deleteMark(mark);
    }
}
