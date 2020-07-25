package ca.sheridancollege.controller;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import ca.sheridancollege.Repositories.RoleRepository;
import ca.sheridancollege.Repositories.StudentRepository;
import ca.sheridancollege.Repositories.UserRepository;

import ca.sheridancollege.beans.Student;
import ca.sheridancollege.beans.User;

@Controller
public class HomeController {
	
	@Autowired
	RoleRepository roleRepo;
	

	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	@Lazy
	UserRepository userRepo;
	
	
	
	@GetMapping("/")
	public String goHome() {
		return "homeg.html";
	}
	
	@GetMapping("/login")
	public String goLogin() {
		return "Login.html";
	}
	
	
	@GetMapping("/access-denied")
	public String goaccessdenied() {
		return "/error/accessdenied.html";
	}
	

	
	
	@GetMapping("/professor")
	public String goprofessor(Authentication authentication, Model model) {
			String name = authentication.getName();
			ArrayList<String> roles = new ArrayList<String>();
			for (GrantedAuthority ga: authentication.getAuthorities()) {
				roles.add(ga.getAuthority());
				}
			model.addAttribute("name", name);
			model.addAttribute("roles", roles);
		return "/professor/phome.html";
	}
	
	@GetMapping("/createNewStudent")
	public String gocreatestudent(Model model) {
		model.addAttribute("students", new Student());
		return "/professor/createNewStudent.html";
	}
	
	private String encodePassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
	
	@GetMapping("/viewAllStudent")
	public String GoToViewStudent(@ModelAttribute Student p, 
			Model model) {
		model.addAttribute("mystudents", studentRepo.findAll()); //this is the variable from which we are getting the data to the next page.
		return "/professor/viewStudents.html";
		
	}
	
	@PostMapping("/registerStudent")
	public String addRegister(@ModelAttribute Student student,
				Model model) {
		
		String Name = student.getName();
		String Studentid =student.getStudentid();
		User user = new User(null, Name, encodePassword(Studentid), null);
		
		user.getRoles().add(roleRepo.findByRolename("ROLE_STUDENT"));
		
		userRepo.save(user);
		
		studentRepo.save(student);
		model.addAttribute("mystudents", studentRepo.findAll());
		model.addAttribute("students", new Student());
		
		return "redirect:/viewAllStudent";
	}
	
	@GetMapping("/student")
	public String myusermain(Authentication authentication, Model model) {
		String name = authentication.getName();
		ArrayList<String> roles = new ArrayList<String>();
		for (GrantedAuthority ga: authentication.getAuthorities()) {
			roles.add(ga.getAuthority());
			}
		model.addAttribute("name", name);
		model.addAttribute("roles", roles);

		List<Student> conn = studentRepo.findByName(name);
		model.addAttribute("mystudents", conn);

		return "/student/shome.html";
		
	}
	@GetMapping("/deletelink/{id}")
	public String delete(@ModelAttribute Student p,@PathVariable int id, Model model){
	if (studentRepo.findById(id) != null) {
      studentRepo.deleteById(id);
 	 	model.addAttribute("mystudents", studentRepo.findAll()); //this is the variable from which we are getting the data to the next page.
	

	return "/professor/viewStudents.html";
	}else {
	return "redirect:/";
	}
	}
	
	@GetMapping("/editlink/{id}")
	public String edit( @PathVariable int id, Model model){
	if (studentRepo.findById(id) != null) {
	Student play = studentRepo.findById(id);
	model.addAttribute("mystudents", play);
	return "/professor/editStudent.html";
	}else {
	return "redirect:/";
	}
	}
	
	@GetMapping("/modify")
	public String modify(@ModelAttribute Student p,
			Model model) {
		studentRepo.save(p);
		
		Student con = studentRepo.save(p);
		model.addAttribute("mystudents", studentRepo.findAll()); //this is the variable from which we are getting the data to the next page.
		model.addAttribute("mystudent", new Student());

	return "/professor/viewStudents.html";
	}
	
	
	
}
