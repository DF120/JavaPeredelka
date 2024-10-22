package com.example.demo;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                user.getRoles().stream()
                        .map(role -> new org.springframework.security.core.authority.SimpleGrantedAuthority(role.getName()))
                        .toList());
    }

    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findById(2L).orElseThrow()); // роль по умолчанию USER
        user.setRoles(roles);
        userRepository.save(user);
    }
}
