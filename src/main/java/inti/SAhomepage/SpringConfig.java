package inti.SAhomepage;

import inti.SAhomepage.Demerit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource=dataSource;
    }
    @Bean
    public DemeritService demeritService(){
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
