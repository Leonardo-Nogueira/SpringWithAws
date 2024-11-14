package com.springboot.aws.domain.studient;

import com.springboot.aws.domain.room.Room;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Document(collection = "teste")
public class Studient {

    @Id
    private String id;
    private String name;
    private Integer age;
    private String email;
    private String phone;
    private Room RoomStudient;

    public Studient(StudientDTO studientDTO){
        this.name=studientDTO.name();
        this.age=studientDTO.age();
        this.email=studientDTO.email();
        this.phone=studientDTO.phone();
    }



}
