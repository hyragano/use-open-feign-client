package com.example.demo;

import java.math.BigDecimal;
import java.util.UUID;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.domrf.order.api.api.OrderApi;
import ru.domrf.order.api.dto.RequestOrderDTO;

@Component

public class Service {
    @Autowired
    private OrderApi orderApi;

    @PostConstruct
    public void after() {
        var orderById = orderApi.findOrderById(UUID.randomUUID());
        System.out.println(orderById);
        System.out.println(orderApi.createOrder(RequestOrderDTO
            .builder()
            .amount(BigDecimal.ONE)
            .description("hx")
            .build()));
    }

}
