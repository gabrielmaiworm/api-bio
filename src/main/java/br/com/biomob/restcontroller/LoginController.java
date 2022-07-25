package br.com.biomob.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.biomob.entity.User;
import br.com.biomob.repository.UserRepository;

@CrossOrigin
@RestController
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;
	
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
		
}
