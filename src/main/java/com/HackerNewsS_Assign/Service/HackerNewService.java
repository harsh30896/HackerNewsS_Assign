package com.HackerNewsS_Assign.Service;

import com.HackerNewsS_Assign.Entity.Comment;
import com.HackerNewsS_Assign.Entity.Story;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HackerNewService {

    public List<Story> getTopStory();

    public List<Service> getTopService();

    public List<Comment> getComments();

}
