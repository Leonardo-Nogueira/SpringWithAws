package com.springboot.aws.service.room;

import com.springboot.aws.domain.room.Room;
import com.springboot.aws.domain.room.RoomDTO;
import com.springboot.aws.domain.room.RoomNotFoundException;
import com.springboot.aws.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository classRepository){
        this.roomRepository = classRepository;
    }

    public Room createRoom(RoomDTO roomDTO){
        Room newRoom = new Room(roomDTO);
        this.roomRepository.save(newRoom);
        return newRoom;
    }

    public List<Room> getAllRoom(){
       return this.roomRepository.findAll();
    }

    public Room updateRoom(String id, RoomDTO roomDTO){
        Room newRoom = this.roomRepository.findById(id).orElseThrow(RoomNotFoundException::new);
        if(!roomDTO.name().isEmpty()) newRoom.setName(roomDTO.name());
        if(!roomDTO.description().isEmpty()) newRoom.setDescription(roomDTO.description());
        if(!roomDTO.block().isEmpty()) newRoom.setBlock(roomDTO.block());
        this.roomRepository.save(newRoom);
        return newRoom;
    }

    public void deleteRoom(String id){
        Room roomDeleted = this.roomRepository.findById(id).orElseThrow(RoomNotFoundException::new);
        this.roomRepository.delete(roomDeleted);
    }

    public Room findRoomById(String id){
        return this.roomRepository.findById(id).orElseThrow(RoomNotFoundException::new);
    }

}
