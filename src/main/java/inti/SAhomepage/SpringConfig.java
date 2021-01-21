package inti.SAhomepage;


import inti.SAhomepage.Locker.Repository.JdbcLockerRepository;
import inti.SAhomepage.Locker.Repository.JdbcPayerRepository;
import inti.SAhomepage.Locker.Repository.LockerRepository;
import inti.SAhomepage.Locker.Repository.PayerRepository;
import inti.SAhomepage.Locker.Service.PayerService;


import inti.SAhomepage.Demerit.*;
import inti.SAhomepage.Rental.repository.*;
import inti.SAhomepage.Rental.service.RentalService;
import inti.SAhomepage.Demerit.DemeritRepository;
import inti.SAhomepage.Demerit.DemeritService;
import inti.SAhomepage.Demerit.MemoryDemeritRepository;

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
    public LockerRepository lockerRepository() {
        return new JdbcLockerRepository(dataSource);
    }

    @Bean
    public PayerRepository payerRepository() {
        return new JdbcPayerRepository(dataSource);
    }

    @Bean
    public PayerService payerService() {
        return new PayerService(payerRepository(), lockerRepository());
    }
    @Bean
    public ProductRepository productRepository() {
        return new JdbcProductRepository(dataSource);
    }

    @Bean
    public RentalRepository rentalRepository() {
        return new JdbcRentalRepository(dataSource);
    }

    @Bean
    public ReservationRepository reservationRepository() {
        return new JdbcReservationRepository(dataSource);
    }

    @Bean
    public RentalService rentalService() {
        return new RentalService(productRepository(), rentalRepository(), reservationRepository(), payerRepository());
    }

    @Bean
    public DemeritService demeritService() {
        return new DemeritService(demeritRepository());
    }

    @Bean
    public AdministratorService administratorService(){
        return new AdministratorService(administratorRepository());
    }

    @Bean
    public DemeritRepository demeritRepository(){
        return new MemoryDemeritRepository(dataSource);
    }
    @Bean
    public AdministratorRepository administratorRepository(){
        return new MemoryAdministratorRepository(dataSource);
    }
}
