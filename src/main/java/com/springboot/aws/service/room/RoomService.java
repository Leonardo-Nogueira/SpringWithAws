package com.springboot.aws.service.room;

import com.springboot.aws.domain.aws.MessageAwsDTO;
import com.springboot.aws.domain.room.Room;
import com.springboot.aws.domain.room.RoomDTO;
import com.springboot.aws.domain.room.RoomNotFoundException;
import com.springboot.aws.repository.room.RoomRepository;
import com.springboot.aws.service.aws.AwsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final AwsService awsService;

    public RoomService(RoomRepository classRepository, AwsService awsService){
        this.roomRepository = classRepository;
        this.awsService=awsService;
    }

    public Room createRoom(RoomDTO roomDTO){
        Room newRoom = new Room(roomDTO);
        this.roomRepository.save(newRoom);
        this.awsService.publishMessage(new MessageAwsDTO(newRoom.toString()));
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
        this.awsService.publishMessage(new MessageAwsDTO(newRoom.toString()));
        return newRoom;
    }

    public void deleteRoom(String id){
        Room roomDeleted = this.roomRepository.findById(id).orElseThrow(RoomNotFoundException::new);
        this.roomRepository.delete(roomDeleted);
    }

    public Room getByIdRoom(String id){
        return this.roomRepository.findById(id).orElseThrow(RoomNotFoundException::new);
    }

}
