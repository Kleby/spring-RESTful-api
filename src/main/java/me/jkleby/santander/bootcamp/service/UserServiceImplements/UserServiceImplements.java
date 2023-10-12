package me.jkleby.santander.bootcamp.service.UserServiceImplements;

import me.jkleby.santander.bootcamp.model.User;
import me.jkleby.santander.bootcamp.repository.UserRepository;
import me.jkleby.santander.bootcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImplements implements UserService {

    @Autowired
    private final UserRepository userRepository;

    UserServiceImplements(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user){
        if(userRepository.existsByAccountNumber(user.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account number already exists!");
        }
        System.out.println(user);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User updateById(Long id, User userUpdate){
        Optional<User> userDb = userRepository.findById(id);
        if (userDb.isPresent()){
            this.create(userUpdate);
        }
        return userUpdate;
    }

    @Override
    public void delete(Long id){
        userRepository.deleteById(id);
    }



}
