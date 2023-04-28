package com.HackerNewsS_Assign.ServiceImpl;

import com.HackerNewsS_Assign.Entity.Comment;
import com.HackerNewsS_Assign.Entity.Story;
import com.HackerNewsS_Assign.HackerNewsClient.HackerNewsClient;
import com.HackerNewsS_Assign.Repository.CommentsRepository;
import com.HackerNewsS_Assign.Repository.StoryRepository;
import com.HackerNewsS_Assign.Response.HackerNewsCommentResponse;
import com.HackerNewsS_Assign.Response.HackerNewsStoryResponse;
import com.HackerNewsS_Assign.Service.HackerNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HackerNewServiceImpl implements HackerNewService {

    @Autowired
    StoryRepository storyRepository;

    @Autowired
    CommentsRepository commentsRepository;


    @Cacheable(value="storyInfo")
    @Override
    public List<Story> getTopStory() {
       HackerNewsClient hackerNewsClient = new HackerNewsClient(storyRepository,commentsRepository);
        Sort sort = Sort.by(Sort.Direction.ASC,"score");
       List<Story> storyList = storyRepository.findAll(sort);
       if(storyList.isEmpty()){
           System.out.println("getting from hacker news api");
           return hackerNewsClient.getTopStories();
       }else {
           //System.out.println("gettting from DB");
           return storyList;
       }
    }

    @Override
    public List<Service> getTopService() {
        return null;
    }


    @Override
    public List<Comment> getComments() {
        HackerNewsClient hackerNewsClient = new HackerNewsClient(storyRepository,commentsRepository);
        return hackerNewsClient.getComments();
    }
}
