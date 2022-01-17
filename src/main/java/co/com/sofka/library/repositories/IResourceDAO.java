package co.com.sofka.library.repositories;

import co.com.sofka.library.models.Resource;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResourceDAO extends ReactiveMongoRepository<Resource,String> {
}
