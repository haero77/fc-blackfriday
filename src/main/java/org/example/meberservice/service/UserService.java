package org.example.meberservice.service;

import org.example.meberservice.entity.UserEntity;
import org.example.meberservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity registerUser(final String loginId, final String userName) {
        final UserEntity user = new UserEntity(loginId, userName);
        return userRepository.save(user);
    }

    public UserEntity modifyUser(final Long userId, final String userName) {
        final UserEntity user = userRepository.findById(userId).orElseThrow();
        user.userName = userName;

        return userRepository.save(user);
    }

    public UserEntity getUser(final String loginId) {
        return userRepository.findByLoginId(loginId).orElseThrow();
    }
}
