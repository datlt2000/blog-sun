package com.codekisu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codekisu.data.Post;
import com.codekisu.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	/**
	 * post service
	 * get data
	 */
	public List<Post> findNewestPost() {
		return postRepository.findNewestPost();
	}
	public Post findPostByTitle(String title) {
		return postRepository.findByTitle(title);
	}
	public List<String> findPostByCategory(String category) {
		return postRepository.findByCategory(category);
	}
	public Post findPostById(long id) {
		return postRepository.findById(id);
	}
	public List<Post> findPostByArthur(String name) {
		return postRepository.findByArthur(name);
	}
	public List<Post> findRelatedPost(Long id) {
		return postRepository.findRelatedPost(id);
	}
	/**
	 * save data
	 */
	public void savePost(Post post) {
		this.postRepository.save(post);
	}
}
