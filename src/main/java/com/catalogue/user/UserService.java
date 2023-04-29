package com.catalogue.user;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.catalogue.user.dto.UserDto;
import com.catalogue.user.entity.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Long id) {
        return modelMapper.map(userRepository.findById(id).get(), UserDto.class);
    }

    public Long registerNewUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        userRepository.saveAndFlush(user);
        return user.getId();
    }

}
