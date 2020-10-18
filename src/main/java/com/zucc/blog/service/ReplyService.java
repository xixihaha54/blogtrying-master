package com.zucc.blog.service;

import com.zucc.blog.entity.Reply;

import java.util.List;
import java.util.Map;

public interface ReplyService {
    Reply addReply(Reply reply);

    List<Map<Long, Object>> findReplysByCommentIdLikeSql2(Long commentId);
}
