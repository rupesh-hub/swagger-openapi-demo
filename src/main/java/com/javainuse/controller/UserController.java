package com.javainuse.controller;

import com.javainuse.model.ErrorResponse;
import com.javainuse.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
@Api(value = "User Management System")
public class UserController {

    final List<User> users = new ArrayList<>();

    @ApiOperation(value = "Get all users", notes = "Returns list of available users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = String.class),
            @ApiResponse(code = 400, message = "Parameter you passed is in wrong format or in wrong type", response = ErrorResponse.class),
            @ApiResponse(code = 401, message = "The client request has not been completed because it lacks valid authentication credentials for the requested resource", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "A client is forbidden from accessing a valid URL", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "Internal server error", response = ErrorResponse.class)
    })
    @GetMapping("/all")
    public List<User> allUsers() {
        return this.users;
    }

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody final User user) {
        return new ResponseEntity(this.users.add(user), HttpStatus.CREATED);
    }

}