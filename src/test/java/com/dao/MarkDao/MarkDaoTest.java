package com.dao.MarkDao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class MarkDaoTest {

    @Test
    public void testingSQLQuery() throws Exception {



        Session session = getSession();

        SQLQuery query = session.createSQLQuery(
                "CREATE *" +
                        "from Mark " +
                        ";");

//        "SELECT Mark.studentId, student.name, AVG(Mark.mark)"+
//                "from Mark INNER JOIN student on student.studentId = Mark.studentId"+
//                "GROUP BY Mark.studentId"+
//                "ORDER BY mark DESC LIMIT 1;");



        assertThat(query, null);


    }


}
