
package org.example.tacocloud.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.tacocloud.configs.OrderProps;
import org.example.tacocloud.domains.TacoOrder;
import org.example.tacocloud.domains.User;
import org.example.tacocloud.repositories.OrderRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private OrderRepository orderRepository;
    private OrderProps props;

    public OrderController(OrderRepository orderRepository, OrderProps props) {
        this.orderRepository = orderRepository;
        this.props = props;
    }

    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors,
                               SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();
        return "redirect:/";
    }

//    @GetMapping
//    public String ordersForUser(
//            @AuthenticationPrincipal User user, Model model) {
//
//        Pageable pageable = PageRequest.of(0, props.getPageSize());
//        model.addAttribute("orders",
//                orderRepository.findByUserOrderByPlacedAtDesc(user, pageable));
//
//        return "orderList";
//    }
}
