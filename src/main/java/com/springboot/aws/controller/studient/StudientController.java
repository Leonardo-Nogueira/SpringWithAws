package com.springboot.aws.controller.studient;

import com.springboot.aws.domain.studient.Studient;
import com.springboot.aws.domain.studient.StudientDTO;
import com.springboot.aws.service.sudient.StudientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/studient")
public class StudientController {

    private StudientService studientService;

    public StudientController(StudientService studientService){
        this.studientService = studientService;
    }

    @PostMapping
    public ResponseEntity<Studient> createStudient(@RequestBody StudientDTO roomData){
        Studient newStudient = this.studientService.createStudient(roomData);
        return ResponseEntity.ok().body(newStudient);

    }

    @GetMapping
    public ResponseEntity<List<Studient>> geStudient(){
        List<Studient> listRoom = this.studientService.getAllStudient();
        return ResponseEntity.ok().body(listRoom);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Studient> getByIdStudient(@PathVariable("id") String id){
        return ResponseEntity.ok().body(this.studientService.getByIdStudient(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Studient> updateStudient(@PathVariable("id") String id, @RequestBody StudientDTO studientData){
        return ResponseEntity.ok().body(this.studientService.updateStudient(id, studientData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Studient> deleteStudient(@PathVariable("id") String id){
        this.studientService.deleteStudient(id);
        return ResponseEntity.noContent().build();
    }
}
