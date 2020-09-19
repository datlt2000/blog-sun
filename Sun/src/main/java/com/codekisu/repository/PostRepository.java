package com.codekisu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codekisu.data.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	public Post findById(long id);
	public Post findByTitle(String title);
	public List<Post> findByArthur(String name);
	public List<String> findByCategory(String category);
	@Query(value = "SELECT * FROM post ORDER BY date_post DESC LIMIT 0, 5", nativeQuery = true)
	public List<Post> findNewestPost();
	@Query(value = "SELECT * FROM post WHERE  id > ? -1 LIMIT 0, 3", nativeQuery = true)
	public List<Post> findRelatedPost(Long id);
}
