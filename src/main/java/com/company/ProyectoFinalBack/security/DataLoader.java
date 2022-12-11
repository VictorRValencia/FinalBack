package com.company.ProyectoFinalBack.security;

import com.company.ProyectoFinalBack.model.AppUser;
import com.company.ProyectoFinalBack.model.AppUserRol;
import com.company.ProyectoFinalBack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("vv");
        String password1 = passwordEncoder.encode("vi");

        userRepository.save(new AppUser("vv", "vv", "vv", password, AppUserRol.ADMIN));
        userRepository.save(new AppUser("vi", "vi", "vi", password1, AppUserRol.USER));
    }
}
