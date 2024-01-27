package com.encore.order.Member.controller;

import com.encore.order.Member.dto.MemberListResDto;
import com.encore.order.Member.dto.MemberSaveReqDto;
import com.encore.order.Member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("member/new")
    @ResponseBody
    public MemberSaveReqDto memberSave(MemberSaveReqDto memberSaveReqDto){
        memberService.save(memberSaveReqDto);
        return memberSaveReqDto;
        //return "Sign up is complete. Try to check the DataBase";
    }

    @GetMapping("members")
    @ResponseBody
    public List<MemberListResDto> memberList(){
        return memberService.findAll();
    }

}
