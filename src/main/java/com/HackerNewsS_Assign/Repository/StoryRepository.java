package com.HackerNewsS_Assign.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HackerNewsS_Assign.Entity.Story;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends JpaRepository<Story, Integer> {
}
