package com.example.memoir.domain.memoir.controller;

import com.example.memoir.domain.memoir.controller.dto.request.MemoirUpdateRequest;
import com.example.memoir.domain.memoir.controller.dto.request.MemoirWriteRequest;
import com.example.memoir.domain.memoir.controller.dto.response.MemoirDetailsResponse;
import com.example.memoir.domain.memoir.controller.dto.response.MemoirResponse;
import com.example.memoir.domain.memoir.service.MemoirService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/memoir")
@RestController
public class MemoirController {

    private final MemoirService memoirService;

    // 작성
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/write")
    public void memoirWrite(@RequestBody @Valid MemoirWriteRequest request) {
        memoirService.memoirWrite(request);
    }

    // 삭제
    @DeleteMapping
    public void memoirDelete(@RequestParam("memoirId") Long memoirId) {
        memoirService.memoirDelete(memoirId);
    }

    @PatchMapping("/update")
    public void memoirUpdate(@RequestParam("memoirId") Long memoirId,
                             @RequestBody @Valid MemoirUpdateRequest request) {
        memoirService.memoirUpdate(memoirId, request);
    }

    @GetMapping
    public MemoirDetailsResponse memoirDetails(@RequestParam("memoirId") Long memoirId) {
        return memoirService.memoirDetails(memoirId);
    }

    @GetMapping("/list")
    public List<MemoirResponse> memoirList() {
        return memoirService.memoirList();
    }

    @GetMapping("/mypage")
    public List<MemoirResponse> myMemoirList() {
        return memoirService.myMemoirList();
    }

    @GetMapping("/search")
    public List<MemoirResponse> searchMemoir(@PathParam("keyword") String keyword) {
        return memoirService.searchMemoir(keyword);
    }
}
