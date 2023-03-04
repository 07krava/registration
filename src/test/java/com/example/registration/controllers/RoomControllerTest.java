package com.example.registration.controllers;

import com.example.registration.model.Room;
import com.example.registration.repository.RoomRepository;
import com.example.registration.service.OrderService;
import com.example.registration.service.RoomService;
import com.example.registration.service.UserService;
import com.example.registration.service.impl.RoomServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringJUnitConfig
class RoomControllerTest {

    @Mock
    private UserService userService;
    @Mock
    private OrderService orderService;

    @Mock
    private RoomServiceImpl roomService;

    @Before("")
    void setUp() {
         roomService = Mockito.mock(RoomServiceImpl.class);
        MockitoAnnotations.initMocks(roomService);
    }

    @Test
    void getAllRooms() {
        List<Room> rooms = new ArrayList<>();

        rooms.add(new Room(1L, 1, BigDecimal.valueOf(100), "good room"));
        rooms.add(new Room(2L,2, BigDecimal.valueOf(150), "bed room"));

        Mockito.when(roomService.getAllRooms()).thenReturn(rooms);
    }

    @Test
    void getRoomById() {
        Mockito.when(roomService.findById(1L)).thenReturn(new Room(1L, 1, BigDecimal.valueOf(100), "good room"));

        Room room = roomService.findById(1L);
        assertEquals("good room", room.getTitle());
        assertEquals(1, room.getNumber());
        assertEquals(BigDecimal.valueOf(100), room.getPrice());
    }

    @Test
    void addOrder() {
    }
}