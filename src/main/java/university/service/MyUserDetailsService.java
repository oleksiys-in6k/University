package university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import university.dao.userDao.UserDao;
import university.entity.User;
import university.entity.UserRole;
import university.service.studentService.StudentService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
@EnableTransactionManagement
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    public StudentService studentService;

    @Autowired
    public UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        return studentService.findStudentByName(username);

//        Student student = studentService.findStudentByName(username);
        User user = userDao.findUserByName(username);

        List<GrantedAuthority> authorities = buildUserAuthority((List<UserRole>) user.getUserRole());

        return buildUserForAuthentication(user, authorities);
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(), user.getPassword(), true, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(List<UserRole> userRoles) {
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getUserRoles()));
        }

        return new ArrayList<GrantedAuthority>(setAuths);
    }
}
