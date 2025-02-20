package com.springboot.aws.domain.category;


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
@Document(collection = "categories")
public class Category {

    @Id
    private String id;
    private String titleName;
    private String ownerId;
    private String description;

    public Category(CategoryDTO categoryDTO){
        this.titleName = categoryDTO.titleName();
        this.description = categoryDTO.description();
        this.ownerId = categoryDTO.ownerId();
    }

    @Override
    public String toString(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",this.id);
        jsonObject.put("name",this.titleName);
        jsonObject.put("ownerId",this.ownerId);
        jsonObject.put("description",this.description);
        jsonObject.put("type","categoria");
        return jsonObject.toString();
    }

    public String deleteToString(){
        JSONObject json = new JSONObject();
        json.put("id", this.id);
        json.put("ownerId", this.ownerId);
        json.put("type", "delete-categoria");

        return json.toString();
    }
}
