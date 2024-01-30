package com.encore.order.Ordering.controller;

import com.encore.order.Member.dto.MemberListResDto;
import com.encore.order.Ordering.dto.CreateOrderingReqDto;
import com.encore.order.Ordering.dto.OrderingListResDto;
import com.encore.order.Ordering.service.OrderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderingController {
    private final OrderingService orderingService;
    @Autowired
    public OrderingController(OrderingService orderingService) {
        this.orderingService = orderingService;
    }

    @GetMapping("orders")
    @ResponseBody
    public List<OrderingListResDto> orderingList(){
        return orderingService.findAll();
    }

    //@PostMapping("/order/new")
    //@ResponseBody
    //public String createOrder(@RequestBody CreateOrderingReqDto createOrderingReqDto){
    //    orderingService.createOrder(createOrderingReqDto);
    //    return "Order created!";
    //}
}
