//step 1 in loosely decoupling code

package com.revature.dao;

import java.util.List;
import com.revature.models.User;

public interface IntrfUserDAO {
	
	//These methods handle CRUD ops and read info back to Java
	
	public List<User> findAll();
	public User findById(int id);
	public boolean addUser(User addUser);
	public boolean updateUser(User updateUser);
	boolean deleteUser(int id);
}
	



