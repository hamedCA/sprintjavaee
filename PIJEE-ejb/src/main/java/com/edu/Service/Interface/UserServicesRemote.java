package com.edu.Service.Interface;

import java.util.List;

import javax.ejb.Remote;

import com.edu.PiJEE.User;

@Remote
public interface UserServicesRemote {
	public void addUser(User user);
	public void deletUser(User user);
	public void updateUser(User user);
	public User findUserById(String id);
	public List<User> allUsers();
	public User bestUser();
}
