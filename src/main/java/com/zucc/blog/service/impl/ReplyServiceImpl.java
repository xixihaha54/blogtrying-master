package com.zucc.blog.service.impl;

import com.zucc.blog.dao.ReplyRepository;
import com.zucc.blog.entity.Reply;
import com.zucc.blog.service.ReplyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;

    public ReplyServiceImpl(ReplyRepository replyRepository) {this.replyRepository=replyRepository;}

    @Override
    public Reply addReply(Reply reply){
        Reply reply1 = replyRepository.save(reply);
        return reply1;
    }

    @Override
    public List<Map<Long, Object>> findReplysByCommentIdLikeSql2(Long commentid){
        List<Map<Long, Object>> replys = replyRepository.findReplysByCommentIdLikeSql2(commentid);
        return  replys;
    }
}
