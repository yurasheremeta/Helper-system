package ua.logos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

import ua.logos.entity.UserEntity;
import ua.logos.entity.enums.UserRole;
import ua.logos.repository.UserRepository;



@SpringBootApplication
@EnableJpaRepositories(basePackages = "ua.logos.repository")
public class HelperApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(HelperApplication.class, args);
	}
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public void run(String... args) throws Exception {
		if(userRepository.count() == 0) {
			UserEntity userEntity = new UserEntity();
		userEntity.setFirstName("Admin");
		userEntity.setLastName("Admin");
		userEntity.setUsername("admin");
		userEntity.setRole(UserRole.ROLE_ADMIN);
		userEntity.setPassword(passwordEncoder.encode("admin"));
		
		userRepository.save(userEntity);
		
	}
		
	}
	
	
	
	
}
