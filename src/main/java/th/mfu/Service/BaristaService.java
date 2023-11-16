package th.mfu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.mfu.Repository.*;
import th.mfu.Domain.*;
import java.util.*;

@Service
public class BaristaService {

    private final BaristaRepository baristaRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public BaristaService(BaristaRepository baristaRepository, OrderRepository orderRepository) {
        this.baristaRepository = baristaRepository;
        this.orderRepository = orderRepository;
    }

    public List<Menu> getBaristaOrders() {
        // Implement logic to retrieve barista's orders from the repository
        
        // return orderRepository.findAllByBaristaIdNotNull();
        return null;
    }

    public void notifyBarista(Menu order) {
        // Implement logic to notify barista about a new order
        // You can use WebSocket or any other notification mechanism
        // For simplicity, let's assume we are just updating the order with the barista's ID
        
        // order.setBaristaId(baristaRepository.findBaristaById(order.getBaristaId()).orElse(null));
        // this.orderRepository.save(order);
    }

    public double calculateDailyTotalSale() {
        // Implement logic to calculate daily total sale
        // You may need to fetch orders for the day from the repository
        // and sum up the total sale amount
        return 0.0; // Placeholder, replace with actual logic
    }

    // Add more methods as needed...
}
