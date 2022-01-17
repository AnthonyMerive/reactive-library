package co.com.sofka.library.controllers;

import co.com.sofka.library.dtos.ResourceDTO;
import co.com.sofka.library.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*",
        methods = {RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.POST,
                RequestMethod.DELETE}
)
@RequestMapping("/api")
public class ResourceController {

    @Autowired
    private ResourceService service;

    @GetMapping("/")
    public ResponseEntity<Flux<ResourceDTO>> getAll(){

        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<ResourceDTO>> getById(
            @PathVariable
                    String id
    ){
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PostMapping("/resource")
    public ResponseEntity<Mono<ResourceDTO>> create(
            @RequestBody
                    Mono<ResourceDTO> resource
    ){
        return new ResponseEntity<>(service.add(resource), HttpStatus.OK);
    }

    @PutMapping("/resource/{id}")
    public ResponseEntity<Mono<ResourceDTO>> edit(
            @PathVariable
                    String id,
            @Validated
            @RequestBody
                    Mono<ResourceDTO> resource
    ){
        return new ResponseEntity<>(service.update(resource, id), HttpStatus.OK);
    }

    @DeleteMapping("/resource/{id}")
    public ResponseEntity<Mono<Void>> delete(
            @PathVariable
                    String id
    ){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

}
