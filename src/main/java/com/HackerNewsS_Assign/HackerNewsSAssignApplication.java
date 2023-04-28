package com.HackerNewsS_Assign;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.HackerNewsS_Assign.Entity.Story;
import com.HackerNewsS_Assign.HackerNewsClient.HackerNewsClient;
import com.HackerNewsS_Assign.Repository.StoryRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication

public class HackerNewsSAssignApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackerNewsSAssignApplication.class, args);

	}

}
