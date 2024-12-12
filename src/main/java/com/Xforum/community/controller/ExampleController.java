package com.Xforum.community.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

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
    @ResponseBody// 这个注解不加默认返回html
    public String saveStudent(String name, int age) {
        System.out.println(name);
        System.out.println(age);
        return "提交成功!";
    }

    // 响应HTML数据
    @GetMapping(path = "/teacher")
    public ModelAndView getTeacher() {
        ModelAndView  mav = new  ModelAndView();
        mav.addObject("name", "吴雨欣");
        mav.addObject("age", "24");
        mav.setViewName("/demo/view");
        return mav;
    }

    @GetMapping(path = "/school")
    public String getSchool(Model model) {
        model.addAttribute("name", "北体");
        model.addAttribute("age", 200);
        return "/demo/view";
    }

    // 响应JSON数据（异步请求）
    //Java对象 --》 JSON --》 JS对象
    @GetMapping (path = "/emp")
    @ResponseBody
    public Map<String, Object> getEmp() {
        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "小吴");
        emp.put("age", "24");
        emp.put("salary", "20");
        return emp;

    }

    @GetMapping (path = "/emps")
    @ResponseBody
    public List<Map<String, Object> > getEmps() {
        List<Map<String, Object> > list = new ArrayList<>();
        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "小吴");
        emp.put("age", "24");
        emp.put("salary", "20");
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name", "小李");
        emp.put("age", "22");
        emp.put("salary", "200000000");
        list.add(emp);
        return list;
    }
}
