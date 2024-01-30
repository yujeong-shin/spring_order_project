package com.encore.order.Ordering.service;

import com.encore.order.Member.domain.Member;
import com.encore.order.Member.dto.MemberListResDto;
import com.encore.order.Ordering.domain.Ordering;
import com.encore.order.Ordering.dto.OrderingListResDto;
import com.encore.order.Ordering.repository.OrderingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderingService {
    private final OrderingRepository orderingRepository;
    @Autowired
    public OrderingService(OrderingRepository orderingRepository) {
        this.orderingRepository = orderingRepository;
    }

    public List<OrderingListResDto> findAll(){
        List<OrderingListResDto> orderingListResDtos = new ArrayList<>();
        List<Ordering> orderings = orderingRepository.findAll();
        for(Ordering ordering : orderings){
            OrderingListResDto orderingListResDto = new OrderingListResDto();
            orderingListResDto.setId(ordering.getId());
            orderingListResDto.setName(ordering.getMember().getName());
            orderingListResDto.setOrderStatus(ordering.getOrderStatus());
            orderingListResDto.setCreatedTime(ordering.getCreatedTime());
            orderingListResDtos.add(orderingListResDto);
        }
        return orderingListResDtos;
    }
}