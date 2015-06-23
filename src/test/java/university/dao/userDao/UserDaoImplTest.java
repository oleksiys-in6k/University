package university.dao.userDao;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import university.entity.User;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:testUniversity.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class UserDaoImplTest {

    @Autowired
    UserDao userDao;

    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void testFindStudentByName() throws Exception {
        //given
        User user = new User("bob", "bob");
        userDao.addUser(user);

        //when
        User someUser = userDao.findUserByName(user.getLogin());

        System.out.println("user" + user);
        System.out.println("someUser" + someUser);

        //then
        assertThat(someUser, is(user));

    }

}