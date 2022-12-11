package com.company.ProyectoFinalBack.security;

import com.company.ProyectoFinalBack.model.AppUser;
import com.company.ProyectoFinalBack.model.AppUserRol;
import com.company.ProyectoFinalBack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.CryptoPrimitive;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository){
        this.userRepository =  userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // encriptamos la contra
        String password = passwordEncoder.encode("password");
        String password2 = passwordEncoder.encode("password2");

        userRepository.save(new AppUser("Andy", "AndyProfeBack", "AndyDH@gmail.com", password, AppUserRol.ADMIN));
        userRepository.save(new AppUser("Victor", "VictorValencia", "rayovalenciav@gmail.com", password2, AppUserRol.USER));

    }
}