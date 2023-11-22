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

  
}
