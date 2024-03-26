package com.springStart.SpringProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springStart.SpringProject.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

    
}
