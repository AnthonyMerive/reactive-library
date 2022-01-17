package co.com.sofka.library.services;

import co.com.sofka.library.dtos.ResourceDTO;
import co.com.sofka.library.repositories.IResourceDAO;
import co.com.sofka.library.utils.LibraryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ResourceService {

    @Autowired
    private IResourceDAO repository;

    public Flux<ResourceDTO> getAll(){
        return repository.findAll().map(LibraryUtils::modelToDTO);
    }

    public Mono<ResourceDTO> getById(String id){
        return repository.findById(id).map(LibraryUtils::modelToDTO);
    }

    public Mono<ResourceDTO> add(Mono<ResourceDTO> resourceDTOMono){
        return resourceDTOMono.map(LibraryUtils::DTOToModel)
                 .flatMap(repository::insert)
                 .map(LibraryUtils::modelToDTO);
    }

    public Mono<ResourceDTO> update(Mono<ResourceDTO> resourceDTOMono, String id){
        return repository.findById(id)
                .flatMap(resource -> resourceDTOMono.map(LibraryUtils::DTOToModel)
                        .doOnNext(e-> e.setId(id)))
                .flatMap(repository::save)
                .map(LibraryUtils::modelToDTO);
    }

    public Mono<Void> delete(String id){
        return repository.deleteById(id);
    }
}
