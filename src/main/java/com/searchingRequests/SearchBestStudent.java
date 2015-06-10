package com.searchingRequests;

import com.entity.Student;

import java.sql.SQLException;

public interface SearchBestStudent {
    Student getBestStudent() throws SQLException;

}
