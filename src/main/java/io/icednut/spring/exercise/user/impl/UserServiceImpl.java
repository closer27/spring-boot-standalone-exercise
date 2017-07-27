package io.icednut.spring.exercise.user.impl;

import io.icednut.spring.exercise.user.UserDTO;
import io.icednut.spring.exercise.user.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void createUser() { userDAO.createUser(); }

    @Override
    public UserDTO getUser(UserDTO dto) {
        return userDAO.getUser(dto);
    }
}
