package inti.SAhomepage;

import inti.SAhomepage.Demerit.Demerit;
import inti.SAhomepage.Demerit.DemeritRepository;
import inti.SAhomepage.Demerit.DemeritService;
import inti.SAhomepage.Demerit.MemoryDemeritRepository;
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
    public DemeritRepository demeritRepository(){
        return new MemoryDemeritRepository(dataSource);
    }
}
