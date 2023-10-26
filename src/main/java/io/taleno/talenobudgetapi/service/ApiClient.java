package io.taleno.talenobudgetapi.service;

import io.taleno.talenobudgetapi.entity.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="localhost:8081/", value="USER-SERVICE")
public interface ApiClient {

    @GetMapping("api/users/{id}")
    public UserDto get (@PathVariable("id") Long id);
}
