package th.mfu;

import java.lang.annotation.Inherited;
import java.util.Date;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import th.CustomerRepository;
import th.mfu.Domain.Customer;

@Controller
public class CafeController{

    @Autowired
    CustomerRepository cusrepo;

     @GetMapping("/cafe")
    public String cafe(Model model) {
        // TODO: list all concerts
        model.addAttribute("cafe", cusrepo.findAll());
        // TODO: return a template to list concerts
        return "cafe";
    }

    @GetMapping("/cafe/tea/{cafeId}")
    public String reserveSeatForm(@PathVariable Long cafeId, Model model) {
        // TODO: add concert to model
        model.addAttribute("concert", concertRepo.findById(concertId).get());
        // TODO: add empty reservation to model
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);
        // TODO: find available seats (booked=false) by given concert's id to the model
        List<Seat> seats = seatRepo.findByBookedFalseAndConcertId(concertId);
        model.addAttribute("seats", seats);
        return "reserve-seat";
    }


}