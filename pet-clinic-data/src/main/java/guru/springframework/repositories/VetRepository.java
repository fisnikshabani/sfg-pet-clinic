package guru.springframework.repositories;

import guru.springframework.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Pet, Long> {
}
