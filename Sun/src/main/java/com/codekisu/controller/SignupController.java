package com.codekisu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codekisu.data.User;
import com.codekisu.service.UserService;

@Controller
public class SignupController {
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/signup/CheckEmail/{email}")
	public @ResponseBody String checkEmail(@PathVariable String email) {
		System.out.println(email);
		if (userService.findUserByEmail(email)!=null) {
			return "false";
		}
		return "true";
	}
	@RequestMapping(value="/signup/CheckName/{name}")
	public @ResponseBody String checkName(@PathVariable("name") String userName) {
		System.out.println(userName);
		User temp = userService.findUserByName(userName);
		if(temp != null) {
			return "false";
		}
		return "true";
	}
	@PostMapping(value="/signup")
	public String signup(@RequestParam(value="userName", required = true) String name,
						@RequestParam(value="password", required = true) String pass,
						@RequestParam(value="email", required = true) String email) {
		User user = new User();
		user.setName(name);
		user.setPass(passwordEncoder.encode(pass));
		user.setEmail(email);
		user.setRole("ROLE_MEMBER");
		userService.saveUser(user);
		return "redirect:/";
	}
}
