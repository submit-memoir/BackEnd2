package com.example.memoir.domain.memoir.facade;

import com.example.memoir.domain.memoir.domain.Memoir;
import com.example.memoir.domain.memoir.domain.repository.MemoirRepository;
import com.example.memoir.domain.memoir.exception.MemoirNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemoirFacade {

    private final MemoirRepository memoirRepository;

    public Memoir getMemoirId(Long memoirId) {
        return memoirRepository.findById(memoirId)
                .orElseThrow(()-> MemoirNotFoundException.EXCEPTION);
    }
}
