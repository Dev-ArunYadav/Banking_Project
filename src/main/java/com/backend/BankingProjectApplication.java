package com.backend;

import com.backend.entity.EnunRole;
import com.backend.entity.User;
import com.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BankingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingProjectApplication.class, args);
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner createDefaultUser(UserRepository userRepository) {
		return (args) -> {
			if (userRepository.findBySystemAdminId("784100000501").isEmpty()) {
				User user = new User();
				user.setSystemAdminId("784100000501");
				user.setPassword(passwordEncoder.encode("123456"));
				user.setRole(EnunRole.SYSTEM_ADMIN);
				user.setLastLogin(null);
				userRepository.save(user);
				System.out.println("Default user created");
			} else {
				System.out.println("Default user already exists");
			}
		};
	}
}
