package com.example.mvc.springmvc.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class LoginRequest {
    private String uid;
    private String pw;

}
