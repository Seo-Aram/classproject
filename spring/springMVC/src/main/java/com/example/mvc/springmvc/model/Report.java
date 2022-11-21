package com.example.mvc.springmvc.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Report {
    private MultipartFile report;
}
