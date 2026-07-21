package com.example.medicalcoding.user.service;

import com.example.medicalcoding.common.enums.UserRole;
import com.example.medicalcoding.common.exception.ResourceNotFoundException;
import com.example.medicalcoding.user.dto.UserRequest;
import com.example.medicalcoding.user.dto.UserResponse;
import com.example.medicalcoding.user.entity.User;
import com.example.medicalcoding.user.mapper.UserMapper;
import com.example.medicalcoding.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {


        private final UserRepository userRepository;
        private final UserMapper userMapper;

        public List<UserResponse> getAllUsers() {
            return userRepository.findAll().stream()
                    .map(userMapper::toResponse)
                    .toList();
        }

        public UserResponse getUserById(Long id) {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found: " + id));
            return userMapper.toResponse(user);
        }

        public UserResponse createUser(UserRequest request) {
            User user = new User();
            user.setUsername(request.getUsername());
            user.setPassword(request.getPassword()); // will be BCrypt-hashed in Week 5
            user.setEmail(request.getEmail());
            user.setRole(request.getRole() != null ? request.getRole() : UserRole.MEDICAL_CODER);
            user.setStatus("ACTIVE");
            User saved = userRepository.save(user);
            return userMapper.toResponse(saved);
        }

        public void deleteUser(Long id) {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found: " + id));
            userRepository.delete(user);
        }

}
