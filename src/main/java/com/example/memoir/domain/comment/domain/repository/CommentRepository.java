package com.example.memoir.domain.comment.domain.repository;

import com.example.memoir.domain.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByMemoirId(Long id);
}
