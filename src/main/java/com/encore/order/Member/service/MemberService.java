package com.encore.order.Member.service;

import com.encore.order.Member.domain.Member;
import com.encore.order.Member.domain.Role;
import com.encore.order.Member.dto.MemberListResDto;
import com.encore.order.Member.dto.MemberOrderingListResDto;
import com.encore.order.Member.dto.MemberSaveReqDto;
import com.encore.order.Member.repository.MemberRepository;
import com.encore.order.Ordering.domain.Ordering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void save(MemberSaveReqDto memberSaveReqDto) throws IllegalArgumentException{
        if(memberRepository.findByEmail(memberSaveReqDto.getEmail()).isPresent())
            throw new IllegalArgumentException("중복 이메일");

        Role role = null;
        if(memberSaveReqDto.getRole() == null || memberSaveReqDto.getRole().equals("user")){
            role = Role.USER;
        }else{
            role = Role.ADMIN;
        }

        Member member = Member.builder()
                        .name(memberSaveReqDto.getName())
                        .email(memberSaveReqDto.getEmail())
                        .password(memberSaveReqDto.getPassword())
                        .address(memberSaveReqDto.getAddress())
                        .role(role)
                        .build();

        memberRepository.save(member);
    }

    public List<MemberListResDto> findAll(){
        List<MemberListResDto> memberListResDtos = new ArrayList<MemberListResDto>();
        List<Member> members = memberRepository.findAll();
        for(Member member : members){
            MemberListResDto memberListResDto = new MemberListResDto();
            memberListResDto.setId(member.getId());
            memberListResDto.setName(member.getName());
            memberListResDto.setEmail(member.getEmail());
            memberListResDtos.add(memberListResDto);
        }
        return memberListResDtos;
    }

    public Member findById(Long id) throws EntityNotFoundException {
        Member member = memberRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("검색하신 ID의 Member가 없습니다."));
        return member;
    }
    public List<MemberOrderingListResDto> orderingList(Long id){
        Member member = this.findById(id);
        List<Ordering> orderings = member.getOrderings();
        List<MemberOrderingListResDto> memberOrderingListResDtos = new ArrayList<>();
        for(Ordering ordering : orderings){
            MemberOrderingListResDto memberOrderingListResDto = new MemberOrderingListResDto();
            memberOrderingListResDto.setEmail(ordering.getMember().getEmail());
            memberOrderingListResDto.setOrderStatus(ordering.getOrderStatus());
            memberOrderingListResDto.setCreatedTime(ordering.getCreatedTime());
            memberOrderingListResDtos.add(memberOrderingListResDto);
        }
        return memberOrderingListResDtos;
    }
}
