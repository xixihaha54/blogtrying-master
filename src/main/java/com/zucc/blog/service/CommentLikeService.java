package com.zucc.blog.service;

import com.zucc.blog.common.Result;
import com.zucc.blog.entity.CommentLike;
import org.springframework.stereotype.Service;

@Service
public interface CommentLikeService {
    Result<CommentLike> addCommentLike(Long accountId, Long commentId);
    Boolean findCommentLike(Long accountId, Long commentId);
    void deleteCommentLike(Long accountId, Long commentId);
    Result<Integer> findAllCommentLikeByComment(Long commentId);
}
