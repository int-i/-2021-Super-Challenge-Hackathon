package inti.SAhomepage.Rental;

import inti.SAhomepage.Rental.domain.Product;
import inti.SAhomepage.Rental.domain.Rental;
import inti.SAhomepage.Rental.domain.Reservation;
import inti.SAhomepage.Rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
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
        model.addAttribute("pay", false);
        return "/rental/allProduct";
    }

    @GetMapping("/products/{product_id}/reserve")
    public String reservationForm(Model model, @PathVariable int product_id) {
        Product product = rentalService.findOneProduct(product_id).get();
        model.addAttribute("product", product);
        return "/rental/reservation_page";
    }

    @PostMapping("/products/{product_id}/reserve")
    public String createReservation(RentalForm form, @PathVariable int product_id, Model model) {
        if (rentalService.paid(form.getPayer_id())) {
            Reservation reservation = new Reservation();
            reservation.setProduct_id(product_id);
            reservation.setPayer_id(form.getPayer_id());
            Long ms = System.currentTimeMillis();
            ms -= ms % 86400000;
            ms += 15 * 3600000;
            Date date = new Date(ms);
            reservation.setDate(new Date(ms));
            rentalService.reserve(reservation);
            return "redirect:/products";
        } else {
            List<Product> products = rentalService.findProducts();
            model.addAttribute("products", products);
            model.addAttribute("pay", true);
            return "/rental/allProduct";
        }
    }

    @GetMapping("/products/{product_id}/rent")
    public String rentalForm(Model model, @PathVariable int product_id) {
        Product product = rentalService.findOneProduct(product_id).get();
        Reservation reservation = null;
        if (rentalService.reserved(product_id)) {
            reservation = rentalService.findOneReservation(product_id).get();
        }
        model.addAttribute("product", product);
        model.addAttribute("reservation", reservation);
        return "/rental/rental";
    }

    @PostMapping("/products/{product_id}/rent")
    public String createRental(RentalForm form, @PathVariable int product_id, Model model) {
        if (rentalService.paid(form.getPayer_id())) {
            Rental rental = new Rental();
            rental.setProduct_id(product_id);
            rental.setPayer_id(form.getPayer_id());
            rental.setChecker(form.getChecker());
            rentalService.rent(rental);
            return "redirect:/products";
        } else {
            List<Product> products = rentalService.findProducts();
            model.addAttribute("products", products);
            model.addAttribute("pay", true);
            return "/rental/allProduct";
        }
    }

    @GetMapping("/products/{product_id}/return")
    public String returnProduct(@PathVariable int product_id) {
        rentalService.back(product_id);
        return "redirect:/products";
    }
}
