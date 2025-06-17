package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.Arrays;
import java.util.List;

import com.cts.model.Users;
import com.cts.repository.UserRepository;
import com.cts.service.UserServiceImpl;

import org.mockito.InjectMocks;
import org.mockito.Mock;

@SpringBootTest
class UserServiceImplTests {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testAddUser() {
        Users user = new Users();
        
        when(repository.save(user)).thenReturn(user);
        
        String result = userService.addUser(user);
        assertEquals("User Details are successfully saved", result);
    }

    @Test
    void testUpdateUser() {
        Users user = new Users();
        
        when(repository.save(user)).thenReturn(user);
        
        String result = userService.updateUser(user);
        assertEquals("Updated Successfully", result);
    }

    @Test
    void testDeleteUser() {
        doNothing().when(repository).deleteById(1);

        String result = userService.deleteUser(1);
        assertEquals("Deleted the User with userId 1 successfully", result);
    }

    @Test
    void testViewAllUsers() {
        List<Users> mockUsers = Arrays.asList(new Users(), new Users());
        when(repository.findAll()).thenReturn(mockUsers);

        List<Users> result = userService.viewAllUsers();
        assertEquals(2, result.size());
    }

    @Test
    void testGetById_Found() {
        Users user = new Users();
        
        when(repository.findById(1)).thenReturn(Optional.of(user));

        Optional<Users> result = userService.getById(1);
        assertEquals(Optional.of(user), result);
    }

    @Test
    void testGetById_NotFound() {
        when(repository.findById(99)).thenReturn(Optional.empty());

        Optional<Users> result = userService.getById(99);
        assertEquals(Optional.empty(), result);
    }
}

