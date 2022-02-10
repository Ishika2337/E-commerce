package com.ecommerce.WomensDressStore;

import com.ecommerce.WomensDressStore.repository.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = CustomerRepository.class)
public class WomensDressStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(WomensDressStoreApplication.class, args);
	}

}
