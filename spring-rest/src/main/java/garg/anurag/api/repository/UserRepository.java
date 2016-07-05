package garg.anurag.api.repository;

import garg.anurag.api.entity.User;

import java.util.List;

public interface UserRepository {
	
	public List<User> findAll();
	
	public User findOne(String id);
	
	public User create(User user);
	
	public User findByEmail(String email);
	
	public User update(User user);
	
	public void delete(User user);

}
