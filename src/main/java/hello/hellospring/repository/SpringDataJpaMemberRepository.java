package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//JpaRepository를 상속받으면 springdatajpa가 같이 상속받은 인터페이스의
// 오버라이드한 메서드의 이름을 토대로 목적성에 맞게 메서드를 구현해준다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);
}
