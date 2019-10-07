package com.enhakkore.webservice.dto.user;

import com.enhakkore.webservice.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@NoArgsConstructor
public class MemberSaveRequestDto {

    private String userId;
    private String password;

    @Builder
    public MemberSaveRequestDto(String userId, String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        this.userId = userId;
        this.password = passwordEncoder.encode(password);
        System.out.println(this.password+"\n" + password);
    }

    public Member toEntity(){
        System.out.println("dto entity");
        return Member.builder()
                .userId(userId)
                .password(password)
                .build();
    }

}
