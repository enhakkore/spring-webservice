package com.enhakkore.webservice.service;

import com.enhakkore.webservice.domain.member.MemberRepository;
import com.enhakkore.webservice.dto.user.MemberSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@AllArgsConstructor
@Service
public class MemberService {
    private MemberRepository memberRepository;

    @Transactional
    public Long save(MemberSaveRequestDto dto){
        return memberRepository.save(dto.toEntity()).getNumber();
    }
}
