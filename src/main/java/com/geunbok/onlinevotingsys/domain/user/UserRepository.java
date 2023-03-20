package com.geunbok.onlinevotingsys.domain.user;

import com.geunbok.onlinevotingsys.domain.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT p FROM Candidate p ORDER BY p.id DESC")
    List<User> findAllDesc();
    Optional<User> findByEmail(String email);
    //findByEmail은 소셜 로그인으로 반한되는 값 중 email을 통해 이미 생성된 사용자인지 처음 가입하는 사용자인지 판단하는 메소드
}
