package com.springboot.aws.domain.studient;

import com.springboot.aws.domain.room.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "studient")
public class Studient {

    @Id
    private String Id;
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
