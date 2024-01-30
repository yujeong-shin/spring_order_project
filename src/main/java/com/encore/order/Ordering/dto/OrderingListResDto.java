package com.encore.order.Ordering.dto;

import com.encore.order.Member.domain.Member;
import com.encore.order.Ordering.domain.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
public class OrderingListResDto {
    private Long id;
    private String name; //member.name
    private OrderStatus orderStatus;
    private LocalDateTime createdTime;
}
