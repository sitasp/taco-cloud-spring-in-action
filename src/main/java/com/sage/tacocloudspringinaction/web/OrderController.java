package com.sage.tacocloudspringinaction.web;

import com.sage.tacocloudspringinaction.Order;
import com.sage.tacocloudspringinaction.UserP;
import com.sage.tacocloudspringinaction.data.OrderRepository;
import com.sage.tacocloudspringinaction.data.UserRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepo;
    private UserRepository userRepo;

    @Autowired
    public OrderController(OrderRepository orderRepo, UserRepository userRepo) {
        this.orderRepo = orderRepo;
        this.userRepo=userRepo;
    }

    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus, Principal principal){
        if(errors.hasErrors()){
            return "orderForm";
        }

        UserP userP = userRepo.findByUsername(principal.getName());
        order.setUserP(userP);

        orderRepo.save(order);
        sessionStatus.setComplete();
        log.info("Order Submitted: " + order);
        return "redirect:/";
    }
}
