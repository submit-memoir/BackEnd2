package com.example.memoir.domain.memoir.service;

import com.example.memoir.domain.memoir.controller.dto.request.MemoirUpdateRequest;
import com.example.memoir.domain.memoir.controller.dto.request.MemoirWriteRequest;
import com.example.memoir.domain.memoir.controller.dto.response.MemoirDetailsResponse;
import com.example.memoir.domain.memoir.controller.dto.response.MemoirResponse;
import com.example.memoir.domain.memoir.domain.Memoir;
import com.example.memoir.domain.memoir.domain.repository.MemoirRepository;
import com.example.memoir.domain.memoir.exception.MemoirNotDeleteException;
import com.example.memoir.domain.memoir.exception.MemoirNotUpdateException;
import com.example.memoir.domain.memoir.facade.MemoirFacade;
import com.example.memoir.domain.user.domain.user.User;
import com.example.memoir.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@RequiredArgsConstructor
@Service
public class MemoirService {

    private final MemoirRepository memoirRepository;
    private final UserFacade userFacade;
    private final MemoirFacade memoirFacade;

    public void memoirWrite(MemoirWriteRequest request) {
        User user = userFacade.getCurrentUser();

        memoirRepository.save(Memoir.builder()
                .title(request.getTitle())
                .goal(request.getGoal())
                .felt(request.getFelt())
                .learned(request.getLearned())
                .nextGoal(request.getNextGoal())
                .user(user)
                .build());
    }

    @Transactional
    public void memoirDelete(Long memoirId) {
        Memoir memoir = memoirFacade.getMemoirId(memoirId);
        User user = userFacade.getCurrentUser();

        if(!user.equals(memoir.getUser())) {
            throw MemoirNotDeleteException.EXCEPTION;
        }

        memoirRepository.delete(memoir);
    }

    @Transactional
    public void memoirUpdate(Long memoirId, MemoirUpdateRequest request) {
        User user = userFacade.getCurrentUser();
        Memoir memoir = memoirFacade.getMemoirId(memoirId);

        if(!user.equals(memoir.getUser())) {
            throw MemoirNotUpdateException.EXCEPTION;
        }

        memoir.updateMemoir(
                request.getTitle(),
                request.getGoal(),
                request.getLearned(),
                request.getFelt(),
                request.getNextGoal()
        );
    }

    @Transactional
    public MemoirDetailsResponse memoirDetails(Long memoirId) {
        Memoir memoir = memoirFacade.getMemoirId(memoirId);

        return MemoirDetailsResponse.builder()
                .title(memoir.getTitle())
                .felt(memoir.getFelt())
                .goal(memoir.getGoal())
                .learned(memoir.getLearned())
                .nextGoal(memoir.getNextGoal())
                .nickName(memoir.getUser().getNickName())
                .modifiedAt(memoir.getModifiedAt())
                .build();
    }

    @Transactional(readOnly = true)
    public List<MemoirResponse> memoirList() {
        return memoirRepository.findAll()
                .stream().map(memoir -> MemoirResponse.builder()
                        .id(memoir.getId())
                        .title(memoir.getTitle())
                        .goal(memoir.getGoal())
                        .felt(memoir.getFelt())
                        .nextGoal(memoir.getNextGoal())
                        .learned(memoir.getLearned())
                        .modifiedAt(memoir.getModifiedAt())
                        .nickName(memoir.getNickName())
                        .build())
                .collect(Collectors.toList());
    }

    // readOnly라고 명시하므로 읽기 전용 메소드라는 것을 알게 해주고 JPA를 사용할 경우 변경감지 작업을 수행하지 않아 성능상의 이점이 있다.
    // 영속성 컨텍스트(엔티티를 영구 저장하는 환경)에 관리를 받지 않는다.
    @Transactional(readOnly = true)
    public List<MemoirResponse> myMemoirList() {

        User user = userFacade.getCurrentUser();

        return memoirRepository.findAllByUserId(user.getId())

                .stream().map(memoir -> MemoirResponse.builder()
                        .id(memoir.getId())
                        .title(memoir.getTitle())
                        .goal(memoir.getGoal())
                        .felt(memoir.getFelt())
                        .nextGoal(memoir.getNextGoal())
                        .learned(memoir.getLearned())
                        .modifiedAt(memoir.getModifiedAt())
                        .nickName(memoir.getNickName())
                        .build())
                .collect(Collectors.toList());

    }

    @Transactional(readOnly = true)
    public List<MemoirResponse> searchMemoir(String keyword) {
        return memoirRepository.findByTitleContaining(keyword)
                .stream().map(memoir -> MemoirResponse.builder()
                        .id(memoir.getId())
                        .title(memoir.getTitle())
                        .goal(memoir.getGoal())
                        .felt(memoir.getFelt())
                        .nextGoal(memoir.getNextGoal())
                        .learned(memoir.getLearned())
                        .modifiedAt(memoir.getModifiedAt())
                        .nickName(memoir.getNickName())
                        .build())
                .collect(Collectors.toList());
    }

}