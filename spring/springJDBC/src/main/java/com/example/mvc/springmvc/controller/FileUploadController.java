package com.example.mvc.springmvc.controller;

import com.example.mvc.springmvc.model.Report;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Log4j2
@Controller
@RequestMapping("/report")
public class FileUploadController {
    @GetMapping
    public String getReportFrom() {
        return "/report/reportForm";
    }

    @PostMapping("/submit1")
    public String result1(
            @RequestParam(name="report", required = false) MultipartFile report,
            HttpServletRequest request,
            Model model
    ) {
        log.info(report.getOriginalFilename());
        log.info(report.getContentType());
        log.info(report.getSize());

        String uploadURI = "/uploadfile/report";
        String dirRealPath = request.getSession().getServletContext().getRealPath(uploadURI);

        log.info(dirRealPath);

        try {
            // 파일 저장하기
            report.transferTo(new File(dirRealPath, report.getOriginalFilename()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("fileName",report.getOriginalFilename());

        return "report/submit1";
    }

    @PostMapping("/submit2")
    public String result2(
            MultipartHttpServletRequest request,
            Model model
    ) {
        String uploadURI = "/uploadfile/report";
        String dirRealPath = request.getSession().getServletContext().getRealPath(uploadURI);

        log.info(dirRealPath);

        MultipartFile report = request.getFile("report");

        try {
            report.transferTo(new File(dirRealPath, report.getOriginalFilename()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("fileName",report.getOriginalFilename());

        return "report/submit1";
    }

    @PostMapping("/submit3")
    public String result3(
            Report report,
            HttpServletRequest request,
            Model model
    ) {
        String uploadURI = "/uploadfile/report";
        String dirRealPath = request.getSession().getServletContext().getRealPath(uploadURI);

        log.info(dirRealPath);

        try {
            report.getReport().transferTo(new File(dirRealPath, report.getReport().getOriginalFilename()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("fileName",report.getReport().getOriginalFilename());

        return "report/submit1";
    }
}
