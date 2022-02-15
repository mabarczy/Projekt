package pl.edu.wszib.roomReservation.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "pl.edu.wszib.roomReservation.controllers",
        "pl.edu.wszib.roomReservation.services.impl",
        "pl.edu.wszib.roomReservation.session"
})
public class TestConfiguration {
}