package com.springboot.aws.domain.room;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;
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
    private String ownerId;
    private String description;
    private String block;

    public Room(RoomDTO roomDTO){
        this.name = roomDTO.name();
        this.description = roomDTO.description();
        this.ownerId = roomDTO.ownerId();
        this.block = roomDTO.block();
    }

    @Override
    public String toString(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",this.id);
        jsonObject.put("name",this.name);
        jsonObject.put("ownerId",this.ownerId);
        jsonObject.put("description",this.description);
        jsonObject.put("block",this.block);
        jsonObject.put("type","room");
        return jsonObject.toString();
    }
}
