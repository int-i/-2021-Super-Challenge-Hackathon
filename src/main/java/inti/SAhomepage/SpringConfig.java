package inti.SAhomepage;

import inti.SAhomepage.Locker.Repository.JdbcLockerRepository;
import inti.SAhomepage.Locker.Repository.JdbcPayerRepository;
import inti.SAhomepage.Locker.Repository.LockerRepository;
import inti.SAhomepage.Locker.Repository.PayerRepository;
import inti.SAhomepage.Locker.Service.PayerService;
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
}
