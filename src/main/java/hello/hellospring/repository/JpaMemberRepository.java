package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import jakarta.persistence.EntityManager;//JPA에서 엔티티 객체 관리, 데이터베이스와의 상호작용 담당 인터페이스
//                                                엔티티 = 테이블의 속성(회원테이블의 나이가 엔티티임)
import java.util.List;
import java.util.Optional;
public class JpaMemberRepository implements MemberRepository{
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }
    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }
    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }
    @Override
    public List<Member> findAll() {
        return em.createQuery("select m  from Member m", Member.class).getResultList();

    }

}
