package com.example.memoir.domain.comment.domain;

import com.example.memoir.domain.memoir.domain.Memoir;
import com.example.memoir.domain.user.domain.user.User;
import com.example.memoir.global.entity.BaseIdEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends BaseIdEntity {

    @Column(length = 3000)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "memoirId")
    private Memoir memoir;

    @Builder
    public Comment(String content, User user, Memoir memoir) {
        this.content = content;
        this.user = user;
        this.memoir = memoir;
    }

    public void commentUpdate(String content) {
        this.content = content;
    }

    public String getNickName() {
        return user.getNickName();
    }
}
