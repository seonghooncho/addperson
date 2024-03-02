package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//스프링 컨테이너가 클래스 인식
public class SpringConfing {
    private final MemberRepository memberRepository;
    @Autowired //사용시 스프링컨테이너가 자동으로 호출해줌, 의존성 주입
    public SpringConfing(MemberRepository memberRepository) {
        //@Autowired아래 메서드의 매개변수는 다른 bean에 담긴객체가 들어가야함
        //JpaRepository를 상속받은 인터페이스는 자동으로 bean에 등록
        //이 경우 SpringDataJpaMemberRepository가 JpaRepository를 상속함
        this.memberRepository = memberRepository;
    }
    @Bean//bean 객체 생성
    public MemberService memberService(){
        return new MemberService(memberRepository);//bean에 반환
    }//반환값(MemberService)을 보고 그 반환값에 맞는 매개변수 타입이 있으면 거기에 넣어줌
    //여기선 MemberController에 넣었음



    /*
    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();//그냥 클래스 위에 @Component 해도됨
    }*/



    /*
    //private DataSource dataSource; jdbc에서사용
    //jpa에서 사용
    private EntityManager em;
    @Autowired
    public SpringConfing(EntityManager em) {
        this.em = em;
    }
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        //return new JdbcMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }*/
}
