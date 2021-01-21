package inti.SAhomepage.Rental;

import inti.SAhomepage.Rental.domain.Product;
import inti.SAhomepage.Rental.domain.Rental;
import inti.SAhomepage.Rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RentalController {

    private final RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/products")
    public String productsStatus(Model model) {
        List<Product> products = rentalService.findProducts();
        model.addAttribute("products", products);

        System.out.println(products.get(1).getProduct_id());
        System.out.println(products.get(1).getProduct_name());
        return "rental/allProduct";
    }

}
