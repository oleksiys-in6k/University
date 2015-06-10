package com.MarkIO.writer;

import com.dao.markDao.MarkDao;
import com.entity.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Transactional
public class MarkWriterImpl implements MarkWriter {

    @Autowired
    private MarkDao markDao;

    public void saveMark(Mark mark) throws SQLException {
        markDao.addMark(mark);
    }

    public void setMarkDao(com.dao.markDao.MarkDaoImpl markDao) {
        this.markDao = markDao;
    }
}
