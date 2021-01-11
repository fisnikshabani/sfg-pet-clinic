package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component //becomes as spring bean
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtiesService specialtiesService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Chapi");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Shakry");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtiesService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtiesService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtiesService.save(dentistry);

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
        owner2.setFirstName("Trazovac");
        owner2.setLastName("Kadriu");
        owner1.setAddress("Gllazhnje");
        owner1.setCity("Dardani");
        owner1.setTelephone("+38977773018");

        Pet trazoCat = new Pet();
        trazoCat.setPetType(savedCatPetType);
        trazoCat.setOwner(owner2);
        trazoCat.setBirthdate(LocalDate.now());
        trazoCat.setName("Vuchjaki Arbenit ReactJS");
        owner2.getPets().add(trazoCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(trazoCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");
        visitService.save(catVisit);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Vet1 firstName");
        vet1.setLastName("Vet1 lastName");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vet2 firstName");
        vet2.setLastName("Vet2 lastName");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
