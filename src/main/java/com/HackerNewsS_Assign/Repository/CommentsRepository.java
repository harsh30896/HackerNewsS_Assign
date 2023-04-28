package com.HackerNewsS_Assign.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HackerNewsS_Assign.Entity.Comment;

public interface CommentsRepository extends JpaRepository<Comment,Integer> {

}
