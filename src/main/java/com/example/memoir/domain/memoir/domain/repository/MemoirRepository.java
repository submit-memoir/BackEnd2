package com.example.memoir.domain.memoir.domain.repository;

import com.example.memoir.domain.memoir.domain.Memoir;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemoirRepository extends CrudRepository<Memoir, Long> {

    List<Memoir> findAll();
    List<Memoir> findAllByUserId(Long userId);

    List<Memoir> findByTitleContaining(String keyword);
}
