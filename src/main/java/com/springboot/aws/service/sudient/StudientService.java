package com.springboot.aws.service.sudient;

import com.springboot.aws.domain.room.Room;
import com.springboot.aws.domain.room.RoomDTO;
import com.springboot.aws.domain.room.RoomNotFoundException;
import com.springboot.aws.domain.studient.Studient;
import com.springboot.aws.domain.studient.StudientDTO;
import com.springboot.aws.domain.studient.StudientNotFoundException;
import com.springboot.aws.repository.RoomRepository;
import com.springboot.aws.repository.StudientRepository;
import com.springboot.aws.service.room.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudientService {

    private final RoomService roomService;
    private final StudientRepository studientRepository;

    public StudientService(StudientRepository studientRepository, RoomService roomService){
        this.studientRepository = studientRepository;
        this.roomService=roomService;
    }

    public Studient createStudient(StudientDTO studientDTO){
        Studient newStudient = new Studient(studientDTO);

        if(!studientDTO.roomStudient().isEmpty()){
            Room roomStudient = this.roomService.findRoomById(studientDTO.roomStudient());
            newStudient.setRoomStudient(roomStudient);
        }
        this.studientRepository.save(newStudient);
        return newStudient;
    }

    public List<Studient> getAllStudient(){
        return this.studientRepository.findAll();
    }

    public Studient updateStudient(String id, StudientDTO studientDTO){
        Studient newStudient = this.studientRepository.findById(id).orElseThrow(StudientNotFoundException::new);

        if(!studientDTO.name().isEmpty()) newStudient.setName(studientDTO.name());
        if(studientDTO.age() != null) newStudient.setAge(studientDTO.age());
        if(!studientDTO.email().isEmpty()) newStudient.setEmail(studientDTO.email());
        if(!studientDTO.phone().isEmpty()) newStudient.setPhone(studientDTO.phone());
        if(!studientDTO.roomStudient().isEmpty()){
            Room roomStudient = this.roomService.findRoomById(studientDTO.roomStudient());
            newStudient.setRoomStudient(roomStudient);
        }

        this.studientRepository.save(newStudient);
        return newStudient;
    }

    public void deleteStudient(String id){
        Studient studientDeleted = this.studientRepository.findById(id).orElseThrow(StudientNotFoundException::new);
        this.studientRepository.delete(studientDeleted);
    }
}
