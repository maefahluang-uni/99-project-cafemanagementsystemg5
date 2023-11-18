package th.mfu.Controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.messaging.simp.SimpMessagingTemplate;
// import org.springframework.web.bind.annotation.*;

// import th.mfu.Domain.*;
// import th.mfu.Service.*;
// import java.util.*;

// @RestController
// public class BaristaController {

//     private final BaristaService baristaService;
//     private final SimpMessagingTemplate messagingTemplate;

//     @Autowired
//     public BaristaController(BaristaService baristaService, SimpMessagingTemplate messagingTemplate) {
//         this.baristaService = baristaService;
//         this.messagingTemplate = messagingTemplate;
//     }

    // @GetMapping("/orders")
    // public List<Order> getBaristaOrders() {
    //     return baristaService.getBaristaOrders();
    // }

    // @PostMapping("/notify")
    // public void notifyBarista(@RequestBody Order order) {
    //     baristaService.notifyBarista(order);    

        // Notify the barista through WebSocket
    //     messagingTemplate.convertAndSend("/topic/barista", "New order received!");
    // }

    // @PostMapping("/close-shop")
    // public void closeShop() {
    //     // Perform logic for closing the shop

    //     // Send daily total sale to admin
    //     double dailyTotalSale = baristaService.calculateDailyTotalSale();
    //     messagingTemplate.convertAndSend("/topic/admin", "Daily total sale: " + dailyTotalSale);
    // }

    // Add more methods as needed...

// }
