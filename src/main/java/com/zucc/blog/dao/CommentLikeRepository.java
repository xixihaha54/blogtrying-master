package com.zucc.blog.dao;

import com.zucc.blog.entity.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentLikeRepository extends JpaRepository<CommentLike,Long> {
    CommentLike findByAccountIdAndCommentId(Long accountId, Long commentId);
    List<CommentLike> findByCommentId(Long commentId);
    void deleteByAccountIdAndCommentId(Long accountId, Long commentId);
}
