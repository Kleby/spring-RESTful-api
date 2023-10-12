package me.jkleby.santander.bootcamp.service;

import me.jkleby.santander.bootcamp.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User findById(Long id);

    User create(User user);

    List<User> getAll();

    void delete(Long id);

    User updateById(Long id, User user);

}
