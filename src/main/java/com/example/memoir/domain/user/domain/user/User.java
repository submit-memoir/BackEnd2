package com.example.memoir.domain.user.domain.user;

import com.example.memoir.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.context.annotation.Primary;

import javax.persistence.Column;
import javax.persistence.Entity;


@NoArgsConstructor
@DynamicInsert
@Getter
@Entity
public class User extends BaseIdEntity {

    @Column(length = 10, unique = true)
    private String nickName;

    @Column(length = 30, unique = true)
    private String userId;

    private String password;



    @Column(columnDefinition = "varchar(3000) default '자기소개를 입력해주세요'")
    private String introduce;

    @Builder
    public User(String nickName, String userId, String password, String introduce) {
        this.nickName = nickName;
        this.userId = userId;
        this.password = password;
        this.introduce = introduce;
    }

    public void updateUser(String nickName, String introduce) {
        this.nickName = nickName;
        this.introduce = introduce;
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}
