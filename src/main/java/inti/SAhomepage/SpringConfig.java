package inti.SAhomepage;

import inti.SAhomepage.Rental.domain.Rental;
import inti.SAhomepage.Rental.repository.*;
import inti.SAhomepage.Rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public ProductRepository productRepository() {
        return new JdbcProductRepository(dataSource);
    }

    @Bean
    public RentalRepository rentalRepository(){
        return new JdbcRentalRepository(dataSource);
    }

    @Bean
    public ReservationRepository reservationRepository() {
        return new JdbcReservationRepository(dataSource);
    }

    @Bean
    public RentalService rentalService() {
        return new RentalService(productRepository(), rentalRepository(), reservationRepository());
    }

}
