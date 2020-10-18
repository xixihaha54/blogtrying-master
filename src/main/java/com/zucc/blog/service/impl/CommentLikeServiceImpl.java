package com.zucc.blog.service.impl;

import com.zucc.blog.common.Result;
import com.zucc.blog.common.ResultGenerator;
import com.zucc.blog.dao.CommentLikeRepository;
import com.zucc.blog.entity.CommentLike;
import com.zucc.blog.service.CommentLikeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentLikeServiceImpl implements CommentLikeService {
    private final CommentLikeRepository commentLikeRepository;

    public CommentLikeServiceImpl(CommentLikeRepository commentLikeRepository){
        this.commentLikeRepository = commentLikeRepository;
    }

    @Override
    public Result<CommentLike> addCommentLike(Long accountId, Long commentId){
        CommentLike commentLike = new CommentLike();
        commentLike.setAccountId(accountId);
        commentLike.setCommentId(commentId);
        commentLikeRepository.save(commentLike);
        return ResultGenerator.genResult(200,"评论点赞成功",commentLike);
    }

    @Override
    public Boolean findCommentLike(Long accountId ,Long commentId){
        CommentLike commentLike = commentLikeRepository.findByAccountIdAndCommentId(accountId,commentId);
        return commentLike != null;
    }

    @Override
    @Transactional
    public void deleteCommentLike(Long accountId,Long commentId){
        commentLikeRepository.deleteByAccountIdAndCommentId(accountId, commentId);
    }

    @Override
    public Result<Integer> findAllCommentLikeByComment(Long commentId){
        List<CommentLike> commentLikes = commentLikeRepository.findByCommentId(commentId);
        return ResultGenerator.genResult(200,"评论点赞数",commentLikes.size());
    }
}
