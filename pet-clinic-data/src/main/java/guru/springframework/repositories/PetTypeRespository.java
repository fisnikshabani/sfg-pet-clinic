package guru.springframework.repositories;

import guru.springframework.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRespository extends CrudRepository<PetType, Long> {
}
