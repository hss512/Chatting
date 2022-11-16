package com.gamego.chatting.repository;

import com.gamego.chatting.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Category, Long> {
}
