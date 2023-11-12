package org.jobhacker.user_service_api.service;

import org.jobhacker.user_service_api.dto.UserDTO;
import org.jobhacker.user_service_api.exception.UserAlreadyExistsException;
import org.jobhacker.user_service_api.exception.UserNotFoundException;
import org.jobhacker.user_service_api.mapper.UserMapper;
import org.jobhacker.user_service_api.model.User;
import org.jobhacker.user_service_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO loginUser(User userData) {
        System.out.println(userData);
        User user = userRepository.findByEmail(userData.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userData.setPassword(passwordEncoder.encode(userData.getPassword()));

        if(user.getPassword().equals(userData.getPassword())){
            System.out.println(user);
            return userMapper.mapToDTO(user);
        }
        else{
            throw new UserNotFoundException("Bad Credentials");
          }
    }


    @Override
    public UserDTO addUser(User user) {
        Optional<User> theUser = userRepository.findByEmail(user.getEmail());
        if (theUser.isPresent()){
            throw new UserAlreadyExistsException("A user with " +user.getEmail() +" already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userMapper.mapToDTO(userRepository.save(user));
    }

    @Override
    public List<UserDTO> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(userMapper::mapToDTO).toList();
    }

    @Override
    public void deleteUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Requested User to be deleted does not exist!!"));

        userRepository.delete(user);
    }

    @Override
    public UserDTO getUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return userMapper.mapToDTO(user);
    }

    @Override
    public UserDTO updateUser(User user) {
        User oldUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new UserNotFoundException("No Such User exists!!"));

            oldUser.setId(user.getId());
            oldUser.setUsername(user.getUsername());
            oldUser.setEmail(user.getEmail());
            oldUser.setPhone(user.getPhone());
            oldUser.setActive(user.isActive());

            return userMapper.mapToDTO(userRepository.save(oldUser));
    }

}
