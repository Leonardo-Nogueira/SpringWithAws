package com.springboot.aws.repository.studient;

import com.springboot.aws.domain.studient.Studient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudientRepository extends MongoRepository<Studient,String> {
}
