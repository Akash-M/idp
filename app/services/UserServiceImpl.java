package services;


import daos.UserRepository;
import models.User;

import javax.inject.Inject;
import javax.inject.Named;



@Named
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }
}