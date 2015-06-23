package university.dao.roleDao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import university.entity.UserRole;

@Repository("roleDao")
@Transactional
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public UserRole findRoleByName(String name) {
        return (UserRole) sessionFactory
                .getCurrentSession()
                .createCriteria(UserRole.class)
                .add(Restrictions.eq("userRole", name))
                .uniqueResult();
    }
}
