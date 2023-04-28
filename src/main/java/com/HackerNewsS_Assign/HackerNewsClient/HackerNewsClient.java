package com.HackerNewsS_Assign.HackerNewsClient;

import com.HackerNewsS_Assign.Entity.Comment;
import com.HackerNewsS_Assign.Entity.Story;
import com.HackerNewsS_Assign.Repository.CommentsRepository;
import com.HackerNewsS_Assign.Repository.StoryRepository;
import com.HackerNewsS_Assign.Response.HackerNewsCommentResponse;
import com.HackerNewsS_Assign.Response.HackerNewsStoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class HackerNewsClient {
    @Autowired
    StoryRepository storyRepository;

    @Autowired
    CommentsRepository commentsRepository;

    public HackerNewsClient(StoryRepository storyRepository, CommentsRepository commentsRepository) {
        this.storyRepository = storyRepository;
        this.commentsRepository = commentsRepository;
    }

    private static final String BASE_URL = "https://hacker-news.firebaseio.com/v0/";
    private static final String TOP_STORIES_URL = BASE_URL + "topstories.json";
    private static final String ITEM_URL = BASE_URL + "item/%s.json";

    private static final String COMMENT_URL = ".json";

    public List<Story> getTopStories() {
        RestTemplate restTemplate = new RestTemplate();
        List<Long> storyList = Arrays.asList(restTemplate.getForObject(TOP_STORIES_URL, Long[].class));
        List<Story> sList = new ArrayList<>();
        storyList = storyList.stream().limit(10).collect(Collectors.toList());
        System.out.println(storyList.size());
        storyList.forEach(id -> {
            HackerNewsStoryResponse storyResponse = new HackerNewsStoryResponse();
            storyResponse = restTemplate.getForObject(String.format(ITEM_URL, id), HackerNewsStoryResponse.class);
            Story story = convertFromResponseToStory(storyResponse);
            sList.add(story);
            System.out.println(sList);
        });

        return storyRepository.saveAll(sList);

    }

    private static Story convertFromResponseToStory(HackerNewsStoryResponse storyResponse) {
        Story story = new Story();
        story.setUrl(storyResponse.getUrl());
        story.setTitle(storyResponse.getTitle());
        story.setUser(storyResponse.getBy());
        story.setScore(storyResponse.getScore());
        story.setTimeOfSubmission(storyResponse.getTime());
        return story;
    }

    public List<Comment> getComments() {
        RestTemplate restTemplate = new RestTemplate();
        List<Long> idList = Arrays.asList(restTemplate.getForObject(TOP_STORIES_URL, Long[].class));

        idList = idList.stream().limit(10).collect(Collectors.toList());
        //System.out.println(commentList.size());

        List<HackerNewsCommentResponse> hackerNewsCommentResponseList = new ArrayList<>();
        List<Comment> cList = new ArrayList<>();
        //List<Integer> kidsList = new ArrayList<>();

        for (Long id : idList) {
            HackerNewsStoryResponse hackerNewsStoryResponse = restTemplate.getForObject(String.format(ITEM_URL, id), HackerNewsStoryResponse.class);

            List<Integer> kidsList = new ArrayList<>();

            kidsList = hackerNewsStoryResponse.getKids();


            if(kidsList != null) {

                for (Integer kidId : kidsList) {
                    HackerNewsCommentResponse hackerNewsCommentResponse = restTemplate.getForObject(String.format(ITEM_URL, kidId), HackerNewsCommentResponse.class);
                    hackerNewsCommentResponseList.add(hackerNewsCommentResponse);
                    cList = convertFromResponseToComment(hackerNewsCommentResponseList);
                }
            }
        }


        return commentsRepository.saveAll(cList);

    }

    private static List<Comment> convertFromResponseToComment(List<HackerNewsCommentResponse> hackerNewsCommentResponseList) {
        List<Comment> commentList = new ArrayList<>();
        hackerNewsCommentResponseList.forEach(response -> {
            Comment comment = new Comment();
            comment.setId(response.getId());
            comment.setText(response.getText());
            comment.setUser(response.getBy());
            commentList.add(comment);
        });

        return commentList;

    }


}
