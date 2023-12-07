package com.joyuna.delivery.domain.member;

import com.joyuna.delivery.domain.common.BaseTimeEntity;
import com.joyuna.delivery.domain.member.dto.MemberDeleteRequest;
import com.joyuna.delivery.domain.member.dto.MemberUpdateRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String loginId;

    @Column(nullable = false)
    private String loginPw;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String tel;

    @Column(nullable = false)
    @ColumnDefault("'N'")
    private String deletedYn;

    @Builder
    public Member(String name, String loginId, String loginPw, String email, String tel) {
        this.name = name;
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.email = email;
        this.tel = tel;
    }

    public Member(Long id) {
        this.id = id;
    }

    public void updateMember(MemberUpdateRequest memberUpdateRequest) {
        this.name = memberUpdateRequest.getName();
        this.loginPw = memberUpdateRequest.getLoginPw();
        this.email = memberUpdateRequest.getEmail();
        this.tel = memberUpdateRequest.getTel();
    }

    public void changeToDelete() {
        this.deletedYn = "Y";
    }
}