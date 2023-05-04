package com.catalogue.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.catalogue.user.dto.LoginDto;

@FeignClient(url = "${login.service.url}", value = "login-feign-client")
public interface LoginFeign {

    @GetMapping(path = "/getlogin")
    LoginDto getlogin(Long user_id);
}