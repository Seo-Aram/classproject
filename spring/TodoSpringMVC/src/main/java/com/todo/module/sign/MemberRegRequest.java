package com.todo.module.sign;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class MemberRegRequest {
    private String userId;
    private String password;
    private MultipartFile profileImg;

    public Member toMember(){
        Member member = Member.builder()
                .id(this.userId)
                .pw(this.password)
                .profileUrl(profileImg.getOriginalFilename())
                .build();

        return member;
    }
}
