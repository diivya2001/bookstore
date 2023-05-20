package com.example.books.service;

import com.example.books.exception.DuplicateEntryException;
import com.example.books.model.User;
import com.example.books.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(User user) {
        Optional<User> hasUser = userRepository.findByEmail(user.getEmail());
        if (hasUser.isPresent()) {
            throw new DuplicateEntryException("User with " + user.getEmail() + "already exists");
        } else {
            User result = userRepository.save(user);
            result.setPassword(null);
            return result;
        }
    }


    @Override
    public User authenticate(User user) {
        Optional<User> result = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (result.isPresent()) {
            result.get().setPassword(null);
            return result.get();
        } else {
            throw new DuplicateEntryException("Invalid Credentials");
        }
    }
}
