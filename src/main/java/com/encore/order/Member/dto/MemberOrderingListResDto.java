package com.encore.order.Member.dto;

import com.encore.order.Ordering.domain.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberOrderingListResDto {
    private String email;
    private OrderStatus orderStatus;
    private LocalDateTime createdTime;
}