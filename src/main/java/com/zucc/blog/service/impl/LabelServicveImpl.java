package com.zucc.blog.service.impl;

import com.zucc.blog.dao.LabelRepository;
import com.zucc.blog.entity.Label;
import com.zucc.blog.service.LabelService;
import org.springframework.stereotype.Service;


@Service
public class LabelServicveImpl implements LabelService {

    private final LabelRepository labelRepository;

    public LabelServicveImpl(LabelRepository labelRepository) {this.labelRepository=labelRepository;}

    @Override
    public Label addLabel(Label label){
        Label label1 = labelRepository.save(label);
        return label;
    }
}
