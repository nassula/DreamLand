package com.diegonassula.dreamland;

import com.diegonassula.dreamland.application.usecase.BrandUseCase;
import com.diegonassula.dreamland.domain.Brand;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DreamLandApplication {

    @Autowired
    private ServletContext servletContext;

    @Value("${server.port}")
    String serverPort = "";

    public static void main(String[] args) {
        SpringApplication.run(DreamLandApplication.class, args);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void startupBanner() {

        System.out.println("----------------------------------------");
        System.out.println("http://127.0.0.1:" + serverPort);
        System.out.println("----------------------------------------");

    }

    @Bean
    public CommandLineRunner dataLoader(BrandUseCase brandUseCase){
        return args -> {


            String[] brands = {"Ford", "Fiat", "Chevrolet", "Mercedez", "Volvo"};

            for (String brand: brands) {
                brandUseCase.post(new Brand(brand));
            }
        };
    }
}
