package dev.peter.inventoryservice;

import dev.peter.inventoryservice.model.Inventory;
import dev.peter.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	//loading initial data via bean for development purposes
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			inventoryRepository.deleteAll();

			Inventory inventory = new Inventory();
			inventory.setSkuCode("iphone_x");
			inventory.setQuantity(100);

			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("iphone_x_red");
			inventory1.setQuantity(30);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
	}
}
