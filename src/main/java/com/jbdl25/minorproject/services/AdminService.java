package com.jbdl25.minorproject.services;

import com.jbdl25.minorproject.model.Admin;
import com.jbdl25.minorproject.model.User;
import com.jbdl25.minorproject.repositories.AdminRepository;
import com.jbdl25.minorproject.repositories.UserRepository;
import com.jbdl25.minorproject.requests.AdminCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Value("${app.security.admin_role}")
    String ADMIN_ROLE;

    public void saveAdmin(AdminCreateRequest adminCreateRequest) {
        Admin admin = Admin.builder()
                .name(adminCreateRequest.getName())
                .email(adminCreateRequest.getEmail())
                .build();

        adminRepository.save(admin);

        User user = User.builder()
                .username(admin.getEmail())
                .password(passwordEncoder.encode(adminCreateRequest.getPassword()))
                .authorities(ADMIN_ROLE)
                .build();

        userRepository.save(user);
    }
}
