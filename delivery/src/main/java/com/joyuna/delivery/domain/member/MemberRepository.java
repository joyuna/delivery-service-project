package com.joyuna.delivery.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
     boolean existsByLoginId(String loginId);

     Optional<Member> findByLoginIdAndLoginPw(String loginId, String loginPw);

//     Optional<Member> findByLoginId(String loginId);
}
