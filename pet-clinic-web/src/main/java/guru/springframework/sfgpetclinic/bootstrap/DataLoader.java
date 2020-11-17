package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component //becomes as spring bean
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Fisnik");
        owner1.setLastName("Shabani");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fisnik 2");
        owner2.setLastName("Shabani 2");

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
