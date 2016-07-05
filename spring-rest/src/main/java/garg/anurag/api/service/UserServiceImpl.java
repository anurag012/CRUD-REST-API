package garg.anurag.api.service;

import garg.anurag.api.entity.User;
import garg.anurag.api.exception.UserAlreadyExistException;
import garg.anurag.api.exception.UserNotFound;
import garg.anurag.api.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public User findOne(String id) {

		User existing = repository.findOne(id);
		if(existing==null){
			throw new UserNotFound("User with id = "+id+" not found");
		}
		return existing;
	}

	@Override
	public User create(User user) {

		User existing = repository.findByEmail(user.getEmail());
		if(existing != null){
			throw new UserAlreadyExistException("User with email already exists.");
		} 
		return repository.create(user);
	}

	@Override
	public User update(String id, User user) {
		User existing = repository.findOne(id);
		if(existing==null){
			throw new UserNotFound("User with id = "+id+" not found");
		}
		return repository.update(user);
	}

	@Override
	public void delete(String id) {
		User existing = repository.findOne(id);
		if(existing==null){
			throw new UserNotFound("User with id = "+id+" not found");
		}
		repository.delete(existing);
	}

}
