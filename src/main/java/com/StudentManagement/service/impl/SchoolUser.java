package com.StudentManagement.service.impl;

import com.StudentManagement.dto.BaseDto;
import com.StudentManagement.dto.LoginDto;
import com.StudentManagement.entity.Student;
import com.StudentManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class SchoolUser implements UserDetailsService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    StudentRepository studentRepository;

    public BaseDto login (LoginDto loginDto){
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        return null;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            Student user = studentRepository.findByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException("#user.not.found"));
            return new User(user.getEmail(), user.getPassword(),
                    getAuthorities(user.getId());
        } catch (UsernameNotFoundException e) {
            // TODO to be removed
        }

    }

    private List<String> getAuthorities(List<String> userRoles) throws UsernameNotFoundException {
        return getAuthoritiesFromRoleString(
                userRoles.stream().map(ocpRole -> ocpRole.getRole()).collect(Collectors.toList()));
    }
}
