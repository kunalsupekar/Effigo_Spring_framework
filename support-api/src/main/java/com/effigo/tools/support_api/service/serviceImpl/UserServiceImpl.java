package com.effigo.tools.support_api.service.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.effigo.tools.support_api.dto.UserDTO;
import com.effigo.tools.support_api.model.User;
import com.effigo.tools.support_api.repository.UserRepository;
import com.effigo.tools.support_api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		User savedUser = userRepository.save(user);
		return modelMapper.map(savedUser, UserDTO.class);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users.stream().map(user -> modelMapper.map(user, UserDTO.class)).toList();
	}

	@Override
	public UserDTO getUserById(Long id) {
		User user = userRepository.findById(id).orElse(null);
		return modelMapper.map(user, UserDTO.class);
	}

	@Override
	public UserDTO updateUser(Long id, UserDTO userDTO) {
		if (userRepository.existsById(id)) {
			User user = modelMapper.map(userDTO, User.class);
			user.setId(id); // Ensure the same ID is used
			User updatedUser = userRepository.save(user);
			return modelMapper.map(updatedUser, UserDTO.class);
		}
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	@Override
	public UserDTO getUserByEmail(String email) {
	    User user = userRepository.findByEmail(email);
	    return (user != null) ? modelMapper.map(user, UserDTO.class) : null;
	}


	@Override
	public UserDTO loginUser(String userName, String password) {
	    User user = userRepository.findByUserNameAndPassword(userName, password);
	    if (user != null) {
	        return modelMapper.map(user, UserDTO.class);
	    }
	    return null; // Or throw an exception for invalid credentials
	}


}
