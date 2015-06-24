package university.dao.roleDao;


import university.entity.UserRole;

public interface RoleDao {
    UserRole findRoleByName(String name);
    UserRole findRoleById(Integer id);
}
