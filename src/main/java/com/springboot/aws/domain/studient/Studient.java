package com.springboot.aws.domain.studient;

import lombok.*;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Document(collection = "studient")
public class Studient {

    @Id
    private String id;
    private String name;
    private Integer age;
    private String email;
    private String ownerId;
    private String phone;
    private String roomId;

    public Studient(StudientDTO studientDTO){
        this.name=studientDTO.name();
        this.age=studientDTO.age();
        this.email=studientDTO.email();
        this.ownerId=studientDTO.ownerId();
        this.phone=studientDTO.phone();
        this.roomId=studientDTO.roomId();
    }

    @Override
    public String toString(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",this.id);
        jsonObject.put("name",this.name);
        jsonObject.put("age",this.age);
        jsonObject.put("email",this.email);
        jsonObject.put("ownerId",this.ownerId);
        jsonObject.put("phone",this.phone);
        jsonObject.put("roomId",this.roomId);
        jsonObject.put("type","studient");
        return jsonObject.toString();
    }
}
