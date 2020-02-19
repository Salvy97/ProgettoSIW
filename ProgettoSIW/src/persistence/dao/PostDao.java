package persistence.dao;

import java.util.List;
import model.Post;

public interface PostDao {
	
	public void save(Post post);  // Create
	public Post findByPrimaryKey(String id);  // Retrieve
	public List<Post> findAll();
	public List<Post> findPostsOfThatContent(String contenuto);
	public void update(Post post); //Update
	public void delete(Post post); //Delete
	public List<Post> findAllByContentDeep0(String content);
}