package com.springboot.aws.repository.room;

import com.springboot.aws.domain.room.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends MongoRepository<Room,String> {
}
