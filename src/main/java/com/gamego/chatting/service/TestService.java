package com.gamego.chatting.service;

import com.gamego.chatting.model.entity.Category;
import com.gamego.chatting.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TestService {

    private final TestRepository testRepository;

    public String getCategoryTitle() {

        Category category = testRepository.findById(1L).get();

        return category.getTitle();
    }
}
