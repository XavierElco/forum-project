package com.xav.codeproject.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@Controller
@RequestMapping("/alpha")
public class ExampleController {
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello Spring Boot.";
    }


    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) {
        //request data
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration .hasMoreElements()) {
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + ": " + value);
        }

        System.out.println(request.getParameter("code"));

        //返回响应数据
        response.setContentType("text/html;charset=utf8");
        try (PrintWriter writer = response.getWriter();) {
            writer.write("<h1>牛客网<h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //GET请求

    //students?current=1&limit=20
    @GetMapping("/students")
    @ResponseBody
    public String getStudents(
         @RequestParam(name = "current", required = false, defaultValue = "1") int current,
         @RequestParam(name = "limit", required = false, defaultValue = "10") int limit) {
        System.out.println(current);
        System.out.println(limit);
        return "100 students";
    }

    // /student.html/113
    @GetMapping(path = "/student/{id}")
    @ResponseBody
    public String getAstudent(@PathVariable("id") int id) {
        System.out.println((id));
        return "a student.html";
    }

    //POST请求
    @PostMapping(path = "/student")
    @ResponseBody
    public String saveStudent(String name, int age) {
        System.out.println(name);
        System.out.println(age);
        return "提交成功!";
    }
}
