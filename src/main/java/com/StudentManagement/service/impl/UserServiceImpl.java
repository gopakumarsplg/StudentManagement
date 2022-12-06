package com.StudentManagement.service.impl;

import com.StudentManagement.dto.BaseDto;
import com.StudentManagement.dto.LoginDto;

import com.StudentManagement.entity.Role;
import com.StudentManagement.entity.Student;
import com.StudentManagement.entity.User;
import com.StudentManagement.repository.RoleRepository;
import com.StudentManagement.repository.StudentRepository;
import com.StudentManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    @Lazy
    AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository userRoleRepository;

    @Autowired
    private StudentRepository studentRepository;

    public BaseDto login(LoginDto loginDto) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        return new BaseDto();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("#user.not.found"));
        Optional<Student> student = studentRepository.findByUserId(user.getId());
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                getAuthorities(userRoleRepository.findAllRolesByUser(student.get().getUserId().getId())));
    }

    private List<SimpleGrantedAuthority> getAuthorities(List<Role> userRoles) throws UsernameNotFoundException {
        if (userRoles == null || userRoles.isEmpty()) {
            throw new UsernameNotFoundException("#user.no.roles.asssigned");
        }
        return getAuthoritiesFromRoleString(
                userRoles.stream().map(Role -> Role.getRole()).collect(Collectors.toList()));
    }

    public List<SimpleGrantedAuthority> getAuthoritiesFromRoleString(List<String> userRoles)
            throws UsernameNotFoundException {
        if (userRoles == null || userRoles.isEmpty()) {
            throw new UsernameNotFoundException("#user.no.roles.asssigned");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        userRoles.forEach((role) -> {
            authorities.add(new SimpleGrantedAuthority(role));
        });
        return authorities;
    }
}
