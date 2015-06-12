package university.searchingRequests;

import university.entity.Student;

import java.sql.SQLException;

public interface SearchBestStudent {
    Student getBestStudent() throws SQLException;

}
