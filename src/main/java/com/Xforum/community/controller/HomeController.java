package com.Xforum.community.controller;

import com.Xforum.community.entity.DiscussPost;
import com.Xforum.community.entity.User;
import com.Xforum.community.service.DiscussPostService;
import com.Xforum.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model) {
        List<DiscussPost> list = discussPostService.findDiscussPost(0, 0, 10);
        List<Map<String, Object>> discussPost = new ArrayList<>();
        if (list != null) {
            for (DiscussPost post : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserid());
                map.put("user", user);
                discussPost.add(map);
            }

        }
        model.addAttribute("discussPost", discussPost);
        return "/index";
    }
}
