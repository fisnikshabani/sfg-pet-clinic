package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component //becomes as spring bean
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Chapi");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Xhudi");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Fisnik");
        owner1.setLastName("Shabani");
        owner1.setAddress("HoShiMin 363B");
        owner1.setCity("Shkup");
        owner1.setTelephone("+38977773015");

        Pet fisniksPet = new Pet();
        fisniksPet.setPetType(savedDogPetType);
        fisniksPet.setOwner(owner1);
        fisniksPet.setBirthdate(LocalDate.now());
        fisniksPet.setName("Chapi");
        owner1.getPets().add(fisniksPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fisnik 2");
        owner2.setLastName("Shabani 2");
        owner1.setAddress("HoShiMin2 363B");
        owner1.setCity("Shkup2");
        owner1.setTelephone("+38977773018");

        Pet trazoCat = new Pet();
        trazoCat.setPetType(savedCatPetType);
        trazoCat.setOwner(owner2);
        trazoCat.setBirthdate(LocalDate.now());
        trazoCat.setName("Maca Arbenit");
        owner2.getPets().add(trazoCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Vet1 firstName");
        vet1.setLastName("Vet1 lastName");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vet2 firstName");
        vet2.setLastName("Vet2 lastName");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
