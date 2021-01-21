package inti.SAhomepage;

import inti.SAhomepage.Rental.domain.Product;
import inti.SAhomepage.Rental.service.RentalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class RentalServiceTest {

    @Autowired RentalService rentalService;

    @Test
    void 상품등록(){
        Product product = new Product();
        product.setProduct_id(1);
        product.setProduct_name("우산");
        product.setProduct_num(1);
        product.setState(0);
        product.setImage_path("hihi");

        rentalService.addProduct(product);


        Product result = rentalService.findOneProduct(product.getProduct_id()).get();
        assertThat(product.getProduct_name()).isEqualTo(result.getProduct_name());
    }



}
