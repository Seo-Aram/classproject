package com.todo.module.sign;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class LoginInfo {
    private String uuid;
    private String userId;
    private String profileUrl;
}
