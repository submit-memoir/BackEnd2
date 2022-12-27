package com.example.memoir.domain.memoir.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Builder
public class MemoirDetailsResponse {

    private String title;
    private String nickName;
    private String goal;
    private String learned;
    private String felt;
    private String nextGoal;
    private LocalDate modifiedAt;
}
