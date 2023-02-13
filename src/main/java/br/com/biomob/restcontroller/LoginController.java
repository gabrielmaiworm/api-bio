package br.com.biomob.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.biomob.entity.Admin;
import br.com.biomob.entity.Evaluation;
import br.com.biomob.entity.User;
import br.com.biomob.repository.AdminRepository;
import br.com.biomob.repository.UserRepository;

@CrossOrigin
@RestController
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	@PostMapping("/user/register")
		public User register(@RequestBody User user) {
			
		return userRepository.save(user);
	}
	

	
	
	
	
	@PostMapping("/user/login")
	public ResponseEntity<User> login(@RequestBody User userBody) {
		
		Optional<User> user = userRepository.findById(userBody.getEmail());
		
		if(user.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		if(userBody.getPassword().equals(user.get().getPassword())) {
			return ResponseEntity.ok()
					.body(user.get());
		}
		if(!userBody.getPassword().equals(user.get().getPassword())) {
			return ResponseEntity.badRequest().build();
					
		}
		return null;
			
		}
	
	@GetMapping("/user/list")
	public ResponseEntity<List<User>> listarTodos() {
		return ResponseEntity.ok(userRepository.findAll());
	}
	
	@DeleteMapping("/user/{email}")
	public void removeUser(@PathVariable String email) {
		userRepository.deleteById(email);
	}	
	
	
	@PostMapping("/admin/login")
	public ResponseEntity<Admin> login(@RequestBody Admin adminBody) {
	Optional<Admin> admin = adminRepository.findById(adminBody.getEmail());

	if (admin.isEmpty()) {
	return ResponseEntity.notFound().build();
	}

	boolean isPasswordMatched = bcryptEncoder.matches(adminBody.getPassword(), admin.get().getPassword());
	if (isPasswordMatched) {
	return ResponseEntity.ok(admin.get());
	} else {
	return ResponseEntity.badRequest().build();
	}
	}
	
	
	@GetMapping("/admin/list")
	public ResponseEntity<List<Admin>> listar() {
		return ResponseEntity.ok(adminRepository.findAll());
	}

	@PutMapping("/admin/{email}")
	public void changeAdmin(@PathVariable String email, @RequestBody Admin admin) {
		admin.setEmail(email);
		adminRepository.save(admin);
	}
	
	@PostMapping("/admin/register")
	public Admin register(@RequestBody Admin admin) {
		
		String password = admin.getPassword();
		String encryptedPassword = bcryptEncoder.encode(password);
		String hash = "#4frtegh6778465hhkakatybg987%$bbdknnk";
		admin.setToken( bcryptEncoder.encode(password)+bcryptEncoder.encode(hash));
		admin.setPassword(encryptedPassword);
		
		return adminRepository.save(admin);
	}

	@DeleteMapping("/admin/{email}")
	public void removeAdmin(@PathVariable String email) {
		adminRepository.deleteById(email);
	}
	
}
