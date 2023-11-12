package org.jobhacker.user_service_api.service;

import org.jobhacker.user_service_api.dto.UserDTO;
import org.jobhacker.user_service_api.model.User;

import java.util.List;

public interface UserService {
    UserDTO addUser(User user);
    List<UserDTO> getAllUsers();
    void deleteUser(String email);
    UserDTO getUser(String email);
    UserDTO updateUser(User user);

    UserDTO loginUser(User user);
}
