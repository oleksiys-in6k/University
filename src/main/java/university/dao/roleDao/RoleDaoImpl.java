package university.dao.roleDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import university.entity.Faculty;
import university.entity.UserRole;

@Repository("roleDao")
@Transactional
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public UserRole findRoleByName(String name) {
        Session session = getSession();
        UserRole userRole = (UserRole) session
                .createCriteria(UserRole.class)
                .add(Restrictions.eq("name", name));


        return userRole;
    }

    @Override
    public UserRole findRoleById(Integer id) {
        Session session = getSession();
        return (UserRole) session.get(UserRole.class, id);
    }

}
