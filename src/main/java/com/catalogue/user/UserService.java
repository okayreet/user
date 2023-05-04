package com.catalogue.user;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.catalogue.user.client.LoginFeign;
import com.catalogue.user.dto.LoginDto;
import com.catalogue.user.dto.UserDto;
import com.catalogue.user.entity.User;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final LoginFeign loginFeign;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Long id) {

        // try {
        // LoginDto loginDto = loginFeign.getlogin(id);

        // } catch (FeignException e) {
        // log.info("Openfeign client exception was: {}", e.getMessage());
        // }
        UserDto userDto = modelMapper.map(userRepository.findById(id).get(), UserDto.class);
        try {
            LoginDto loginDto = loginFeign.getlogin(id);
            userDto.setEmail(loginDto.email());
            userDto.setRole(loginDto.role());
        } catch (FeignException e) {
            log.info("Openfeign client exception was: {}", e.getMessage());
            // throw new RuntimeException(e.getMessage());
            throw new RuntimeException("Openfeign client exception");
        }
        return userDto;
    }

    public Long registerNewUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        userRepository.saveAndFlush(user);
        return user.getId();
    }

}
