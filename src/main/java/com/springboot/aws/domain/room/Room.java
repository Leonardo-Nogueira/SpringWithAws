package com.springboot.aws.domain.room;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "room")
public class Room {

    @Id
    private String id;
    private String name;
    private String description;
    private String block;

    public Room(RoomDTO roomDTO){
        this.name = roomDTO.name();
        this.description = roomDTO.description();
        this.block = roomDTO.block();
    }
}
