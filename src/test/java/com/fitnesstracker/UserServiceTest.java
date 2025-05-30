package com.fitnesstracker;

import com.fitnesstracker.model.User;
import com.fitnesstracker.service.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserServiceTest {

    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserService();
    }

    @Test
    public void testAddUser() {
        User user = new User("John Doe", "jdoe");
        userService.addUser(user);

        List<User> users = userService.getAllUsers();
        assertEquals(1, users.size());
        assertEquals("jdoe", users.get(0).getUsername());
    }

    @Test
    public void testFindUserByUsername() {
        User user1 = new User("Jane Smith", "jsmith");
        User user2 = new User("Alice Brown", "abrown");

        userService.addUser(user1);
        userService.addUser(user2);

        User found = userService.findUserByUsername("jsmith");
        assertNotNull(found);
        assertEquals("Jane Smith", found.getName());
    }

    @Test
    public void testFindUserByUsername_CaseInsensitive() {
        User user = new User("Eve Adams", "eAdAmS");
        userService.addUser(user);

        User found = userService.findUserByUsername("EADAMS");
        assertNotNull(found);
        assertEquals("Eve Adams", found.getName());
    }

    @Test
    public void testFindUserByUsername_NotFound() {
        User found = userService.findUserByUsername("nonexistent");
        assertNull(found);
    }

    @Test
    public void testGetAllUsers() {
        userService.addUser(new User("User A", "a"));
        userService.addUser(new User("User B", "b"));

        List<User> allUsers = userService.getAllUsers();
        assertEquals(2, allUsers.size());
    }
}
