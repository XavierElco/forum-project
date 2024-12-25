package com.Xforum.community.service;

import com.Xforum.community.dao.DiscussPostMapper;
import com.Xforum.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {
    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPost (int userId, int offSet, int limit) {
        return discussPostMapper.selectDiscussPost(userId, offSet, limit);
    }

    public int findDiscussPostRows (int userId) {
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
