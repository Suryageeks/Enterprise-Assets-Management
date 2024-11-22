package com.eam.Fixed.Assets.service.impl;

import com.eam.Fixed.Assets.dto.UsersDto;
import com.eam.Fixed.Assets.entity.Users;
import com.eam.Fixed.Assets.repository.UserRepository;
import com.eam.Fixed.Assets.utils.StatusEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UsersimplTest {
    @InjectMocks
    private Usersimpl users;
    @Mock
    private UserRepository userRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUser() {
        UsersDto usersDto = new UsersDto(1L,"5878","Mockito","-","west bengal","N24",877858778,"DM", StatusEnum.ACTIVE);
        Users saveUser = new Users(1L,"5878","Mockito","-","west bengal","N24",877858778,"DM", StatusEnum.ACTIVE,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
        when(userRepo.save(any(Users.class))).thenReturn(saveUser);
        UsersDto createUser = users.createUser(usersDto);
        assertNotNull(createUser);
        assertEquals(saveUser.getId(), createUser.getId());
        assertEquals(saveUser.getEmpId(), createUser.getEmpId());
        assertEquals(saveUser.getEmpName(), createUser.getEmpName());
        assertEquals(saveUser.getStatus(), createUser.getStatus());
    }

    @Test
    void getUserByEmpId() {
        Users user = new Users(1L,"5878","Mockito","-","west bengal","N24",877858778,"DM", StatusEnum.ACTIVE,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
        when(
                userRepo.findByEmpId("5878")
        ).thenReturn(Optional.of(user));
        UsersDto getUserByEmpId = users.getUserByEmpId("5878");
        assertNotNull(getUserByEmpId);
        assertEquals(getUserByEmpId.getEmpId(), user.getEmpId());
        assertEquals(getUserByEmpId.getEmpName(), user.getEmpName());
        assertEquals(getUserByEmpId.getStatus(), user.getStatus());
    }

    @Test
    void listUsers() {
        Users user = new Users(1L,"5878","Mockito","-","west bengal","N24",877858778,"DM", StatusEnum.ACTIVE,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
        Users user1 = new Users(2L,"6555","Mockito1","-","west bengal","N24",877856678,"DM", StatusEnum.ACTIVE,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
        when(userRepo.findAll()).thenReturn(Arrays.asList(user,user1));
        List<UsersDto> getAllUser = users.listUsers();
        assertNotNull(getAllUser);
        assertEquals(getAllUser.get(0).getEmpId(), user.getEmpId());
        assertEquals(getAllUser.get(1).getEmpId(), user1.getEmpId());
    }

    @Test
    void deleteUser() {
        Users user = new Users(1L,"5878","Mockito","-","west bengal","N24",877858778,"DM", StatusEnum.ACTIVE,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
        when(
                userRepo.findByEmpId("5878")
        ).thenReturn(Optional.of(user));
        users.deleteUser("5878");
        verify(userRepo, times(1)).findByEmpId("5878"); // Ensure findByEmpId was called
        verify(userRepo, times(1)).deleteByEmpId("5878");
    }

    @Test
    void updateUserDetails() {
        Users user = new Users(1L,"5878","Mockito","-","west bengal","N24",877858778,"DM", StatusEnum.ACTIVE,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
        when(
                userRepo.findByEmpId("5878")
        ).thenReturn(Optional.of(user));
        when(userRepo.save(any(Users.class))).thenReturn(user);
        UsersDto usersDto = new UsersDto(1L,"5878","Mockito","-","west bengal","N24",877858778,"DM", StatusEnum.INACTIVE);
        users.updateUserDetails("5878",usersDto);
        assertEquals(usersDto.getEmpId(), user.getEmpId());
        assertEquals(usersDto.getEmpName(), user.getEmpName());
        assertEquals(usersDto.getStatus(), user.getStatus());
        verify(userRepo, times(1)).findByEmpId("5878");
        verify(userRepo, times(1)).save(user);
    }

    @Test
    void getStatus() {
        Users user = new Users(1L,"5878","Mockito","-","west bengal","N24",877858778,"DM", StatusEnum.ACTIVE,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()));
        when(
                userRepo.findByEmpId("5878")
        ).thenReturn(Optional.of(user));
        users.getStatus("5878");
        assertEquals(user.getEmpId(), user.getEmpId());
        assertEquals(user.getEmpName(), user.getEmpName());
        assertEquals(user.getStatus(), user.getStatus());
        verify(userRepo, times(1)).findByEmpId("5878");
    }
}