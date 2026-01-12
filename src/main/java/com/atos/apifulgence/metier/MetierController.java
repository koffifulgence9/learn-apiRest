package com.atos.apifulgence.metier;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/metier")
@AllArgsConstructor
public class MetierController {
    private final MetierRepository metierRepository;

    @GetMapping
    public ResponseEntity<List<MetierEntity>> getAllMetier(){
        return new ResponseEntity<>(metierRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MetierEntity> createMetier(@RequestBody MetierEntity metierEntity){
        MetierEntity metier = metierRepository.save(metierEntity);
        return  new ResponseEntity<>(metier, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MetierEntity> getById(@PathVariable Long id){
        Optional<MetierEntity> metier = metierRepository.findById(id);
        return metier.map(metierEntity -> new ResponseEntity<>(metierEntity, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MetierEntity> deletedMetier(@PathVariable Long id){
        Optional<MetierEntity> metier = metierRepository.findById(id);
        if (metier.isPresent()){
            metierRepository.deleteById(id);
            return new ResponseEntity<>(metier.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MetierEntity> updateMetier(@PathVariable Long id,@RequestBody MetierEntity metierDetails){
        Optional<MetierEntity> metier = metierRepository.findById(id);
        if (metier.isPresent()){
            MetierEntity metierEntity = metier.get();
            metierEntity.setNomMetier(metierDetails.getNomMetier());
            metierEntity.setAmont(metierDetails.getAmont());
            metierEntity.setDateNaissance(metierDetails.getDateNaissance());
            MetierEntity updateMetier = metierRepository.save(metierEntity);
            return new ResponseEntity<>(updateMetier, HttpStatus.OK);
         }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
