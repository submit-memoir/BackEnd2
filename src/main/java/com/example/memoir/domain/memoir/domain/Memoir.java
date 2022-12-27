package com.example.memoir.domain.memoir.domain;

import com.example.memoir.domain.user.domain.user.User;
import com.example.memoir.global.entity.BaseTimeEntity;
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
public class Memoir extends BaseTimeEntity {

    @Column(length = 50)
    private String title;

    @Column(length = 100)
    private String goal;

    @Column(columnDefinition = "TEXT")
    private String learned;

    @Column(columnDefinition = "TEXT")
    private String felt;

    @Column(length = 100)
    private String nextGoal;

    @ManyToOne(fetch = FetchType.LAZY) // FetchType.LAZY : 지연로딩
    @JoinColumn(nullable = false, name = "userId")
    private User user;

    @Builder
    public Memoir(String title, String goal, String learned, String felt, String nextGoal, User user) {
        this.title = title;
        this.goal = goal;
        this.learned = learned;
        this.felt = felt;
        this.nextGoal = nextGoal;
        this.user = user;
    }

    public void updateMemoir(String title, String goal, String learned, String felt, String nextGoal) {
        this.title = title;
        this.goal = goal;
        this.learned = learned;
        this.felt = felt;
        this.nextGoal = nextGoal;
    }

    public String getNickName() {
        return user.getNickName();
    }
}
