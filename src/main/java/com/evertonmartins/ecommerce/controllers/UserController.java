package com.evertonmartins.ecommerce.controllers;

import com.evertonmartins.ecommerce.dto.UserDTO;
import com.evertonmartins.ecommerce.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @GetMapping(value = "/me")
    public ResponseEntity<UserDTO> getMe(){
        UserDTO userDTO = userService.getMe();
        return ResponseEntity.ok(userDTO);
    }
}
