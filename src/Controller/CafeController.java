

import java.lang.annotation.Inherited;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.List;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;

import th.CustomerRepository;
import th.mfu.Domain.Customer;
import th.mfu.Domain.Stock;
import th.AdminRepository;

@Controller
public class CafeController{

    @Autowired
    CustomerRepository cusrepo;
    AdminRepository adrepo;

    @GetMapping("/cafe")
    public String cafe(Model model) {
        // TODO: list all concerts
        model.addAttribute("cafe", cusrepo.findAll());
        // TODO: return a template to list concerts
        return "cafe";
    }

    //TODO: add proper annotation for GET method
    @GetMapping("/cafe/concerts/{concertId}")
    public String reserveSeatForm(@PathVariable Long concertId, Model model) {
        // TODO: add concert to model
        model.addAttribute("concert", adrepo.findById(concertId).get());
        // TODO: add empty reservation to model
        Stock stock = new Stock();
        model.addAttribute("reservation", stock);
        // TODO: find available seats (booked=false) by given concert's id to the model
        List<Admin> admin = adrepo.findAllById();
        model.addAttribute("seats", stock);
        return "reserve-seat";
    }
 
    @Transactional
    //TODO: add proper annotation for POST method
    @PostMapping("/cafe/concerts/{concertId}")
    public String reserveSeat(@ModelAttribute Reservation reservation, @PathVariable Long concertId, Model model) {
        // TODO: find selectd seat by id
        Seat seat = seatRepo.findById(reservation.getSeat().getId()).get();
        //TODO: set booked to true
        seat.setBooked(true);
        //TODO: save seat
        adrepo.save(seat);
        // TODO: save reservation using reservationRepo
        reservationRepo.save(reservation);
        return "redirect:/book";
    }

    /*************************************/
    /* No Modification beyond this line */
    /*************************************/

    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/concerts")
    public String listConcerts(Model model) {
        model.addAttribute("concerts", concertRepo.findAll());
        return "list-concert";
    }

    @GetMapping("/add-concert")
    public String addAConcertForm(Model model) {
        model.addAttribute("concert", new Concert());
        return "add-concert-form";
    }

    @PostMapping("/concerts")
    public String saveConcert(@ModelAttribute Concert concert) {
        concertRepo.save(concert);
        return "redirect:/concerts";
    }

    @Transactional
    @GetMapping("/delete-concert/{id}")
    public String deleteConcert(@PathVariable long id) {
        seatRepo.deleteByConcertId(id);
        concertRepo.deleteById(id);
        return "redirect:/concerts";
    }

    @GetMapping("/concerts/{id}/seats")
    public String showAddSeatForm(Model model, @PathVariable Long id) {
        model.addAttribute("seats", seatRepo.findByConcertId(id));

        Concert concert = concertRepo.findById(id).get();
        Seat seat = new Seat();
        seat.setConcert(concert);
        model.addAttribute("newseat", seat);
        return "seat-mgmt";
    }

    @PostMapping("/concerts/{id}/seats")
    public String saveSeat(@ModelAttribute Seat newseat, @PathVariable Long id) {
        Concert concert = concertRepo.findById(id).get();
        newseat.setConcert(concert);
        seatRepo.save(newseat);
        return "redirect:/concerts/" + id + "/seats";
    }

   

}