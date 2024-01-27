package com.encore.order.Ordering.dto;

import com.encore.order.Ordering.domain.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderingDetailResDto {
    private String memberEmail; //순환참조 해결
    private OrderStatus orderStatus;
    private LocalDateTime createdTime;
}
