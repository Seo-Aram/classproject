package com.todo.module.sign;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Member {
    private long idx;
    private String uuid;
    private String id;
    private String pw;
    private String profileUrl;

    public LoginInfo toLoginInfo(){
        return LoginInfo.builder()
                .userId(id)
                .uuid(uuid)
                .profileUrl(profileUrl)
                .build();
    }
}
