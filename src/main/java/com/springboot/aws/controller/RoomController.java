package com.springboot.aws.controller;


import com.springboot.aws.domain.room.Room;
import com.springboot.aws.domain.room.RoomDTO;
import com.springboot.aws.service.room.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    private RoomService roomService;

    public RoomController(RoomService roomService){
        this.roomService=roomService;
    }

    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody RoomDTO roomData){
        Room newRoom = this.roomService.createRoom(roomData);
        return ResponseEntity.ok().body(newRoom);

    }

    @GetMapping
    public ResponseEntity<List<Room>> getRoom(){
        List<Room> listRoom = this.roomService.getAllRoom();
        return ResponseEntity.ok().body(listRoom);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable("id") String id, @RequestBody RoomDTO roomData){
        return ResponseEntity.ok().body(this.roomService.updateRoom(id, roomData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Room> deleteRoom(@PathVariable("id") String id){
        this.roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }
}
