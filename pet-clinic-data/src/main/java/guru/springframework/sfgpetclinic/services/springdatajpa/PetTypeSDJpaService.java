package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.repositories.PetTypeRespository;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

    private final PetTypeRespository petTypeRespository;

    public PetTypeSDJpaService(PetTypeRespository petTypeRespository) {
        this.petTypeRespository = petTypeRespository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRespository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRespository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRespository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRespository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRespository.deleteById(aLong);
    }
}
