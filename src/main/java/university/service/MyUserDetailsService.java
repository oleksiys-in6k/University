package university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import university.dao.studentDao.StudentDao;
import university.entity.Student;
import university.entity.UserRole;
import university.service.studentService.StudentService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    public StudentService studentService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        return studentService.findStudentByName(username);

        Student student = studentService.findStudentByName(username);

        List<GrantedAuthority> authorities = buildUserAuthority(student.getUserRoles());

        return buildUserForAuthentication(student, authorities);
    }

    private UserDetails buildUserForAuthentication(Student student, List<GrantedAuthority> authorities) {
        return new User(student.getName(), student.getPassword(), student.isEnabled(), true, true, true, authorities);
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
