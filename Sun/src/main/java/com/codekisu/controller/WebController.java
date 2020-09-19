package com.codekisu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codekisu.data.Post;
import com.codekisu.service.PostService;

@Controller
public class WebController {
	@Autowired
	private PostService postService;
	@GetMapping("/")
	public String home(Model model) {
		List<Post> newestTitle = postService.findNewestPost();
		model.addAttribute("newestPost", newestTitle);
		return "index";
	}
	@RequestMapping(value = "/post/{id}")
	public String post(Model model, @PathVariable Long id) {
		Post post = postService.findPostById(id);
		model.addAttribute("heading", post.getTitle());
		model.addAttribute("subHeading", post.getSubTitle());
		model.addAttribute("date", post.getDate().toString());
		model.addAttribute("content", post.getContent());
		model.addAttribute("arthur", post.getArthur());
		List<Post> newestTitle = postService.findNewestPost();
		List<Post> relatedTitle = postService.findRelatedPost(post.getId());
		model.addAttribute("relatedPost", relatedTitle);
		model.addAttribute("newestPost", newestTitle);
		return "/layout/Post_Layout";
	}
	@GetMapping(value="/login")
	public String login() {
		return "/layout/Login";
	}
	@GetMapping(value="/signup")
	public String signup() {
		return "/layout/signup";
	}
	@GetMapping(value="/login/error")
	public String loginError() {
		return "/layout/403";
	}
	@GetMapping(value="/admin")
	public String admin() {
		return "/layout/admin";
	}
	@GetMapping(value="/403")
	public String error() {
		return "/layout/403";
	}
	@GetMapping(value="/logout")
	public String logout() {
		return "redirect:/login";
	}
}
