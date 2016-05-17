package services;


import daos.UserDAO;
import models.User;

import javax.inject.Inject;
import javax.inject.Named;



@Named
public class UserServiceImpl implements UserService {

    @Inject
    private UserDAO userDAO;

    @Override
    public void addUser(User user) {
        userDAO.save(user);
    }
}