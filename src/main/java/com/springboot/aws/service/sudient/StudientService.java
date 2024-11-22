package com.springboot.aws.service.sudient;

import com.springboot.aws.domain.aws.MessageAwsDTO;
import com.springboot.aws.domain.room.Room;
import com.springboot.aws.domain.studient.Studient;
import com.springboot.aws.domain.studient.StudientDTO;
import com.springboot.aws.domain.studient.StudientNotFoundException;
import com.springboot.aws.repository.studient.StudientRepository;
import com.springboot.aws.service.aws.AwsService;
import com.springboot.aws.service.room.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudientService {

    private final RoomService roomService;
    private final StudientRepository studientRepository;
    private final AwsService awsService;


    public Studient createStudient(StudientDTO studientDTO){
        Studient newStudient = new Studient(studientDTO);

        if(studientDTO.roomId() != null){
            Room roomStudient = this.roomService.getByIdRoom(studientDTO.roomId());
            newStudient.setRoomId(roomStudient.getId());
        }
        this.studientRepository.save(newStudient);

        this.awsService.publishMessage(new MessageAwsDTO(newStudient.toString()));
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

        if(studientDTO.roomId() != null){
            Room roomStudient = this.roomService.getByIdRoom(studientDTO.roomId());
            newStudient.setRoomId(roomStudient.getId());
        }

        this.studientRepository.save(newStudient);

        this.awsService.publishMessage(new MessageAwsDTO(newStudient.toString()));

        return newStudient;
    }

    public void deleteStudient(String id){
        Studient studientDeleted = this.studientRepository.findById(id).orElseThrow(StudientNotFoundException::new);
        this.studientRepository.delete(studientDeleted);
    }

    public Studient getByIdStudient(String id){
        return this.studientRepository.findById(id).orElseThrow(StudientNotFoundException::new);
    }
}
