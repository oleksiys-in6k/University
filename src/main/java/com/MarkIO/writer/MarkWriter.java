package com.MarkIO.writer;

import com.entity.Mark;

import java.sql.SQLException;


public interface MarkWriter {
    void saveMark(Mark mark) throws SQLException;
}
