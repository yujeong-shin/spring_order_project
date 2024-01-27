package com.encore.order.Member.dto;

import com.encore.order.Member.domain.Role;

import lombok.Data;

@Data
public class MemberSaveReqDto {
    private String name;
    private String email;
    private String password;
    private String address;
    private Role role;
}
