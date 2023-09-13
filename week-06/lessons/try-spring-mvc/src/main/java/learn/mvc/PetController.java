package learn.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PetController {

    private int nextId = 1;

    private ArrayList<Pet> pets = new ArrayList<>();

    @GetMapping
    public List<Pet> findAll(){
        return pets;

    }

    @PostMapping("/pet")
    public ResponseEntity<Pet> add(@RequestBody Pet pet){
        pet.setId(nextId++);
        pets.add(pet);

        return new ResponseEntity<>(pet, HttpStatus.CREATED);
    }

    @PutMapping("/pet/{petId}")
    public ResponseEntity<Object> update(@PathVariable int petId, @RequestBody Pet pet) {
        // TODO: actually update

        for (Pet p : pets){
            if (p.getId()== petId){
                pets.set(pets.indexOf(p), pet);
                return new ResponseEntity<>(pet, HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(pet, HttpStatus.NO_CONTENT);
    }

}
