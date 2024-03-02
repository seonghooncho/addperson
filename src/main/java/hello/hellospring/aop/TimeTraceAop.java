package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//aop는 여러 곳에서 공통으로 반복하는 기능(시간측정 등)을 핵심로직과 분리하여 적용
@Aspect
@Component
public class TimeTraceAop {
    //@Around("execution([반환타입] [패키지명..아래][메서드명]([매개변수]))")
    //@Component가 아닌 Bean에 직접등록했으므로 @Around가 SpringConfig에는 적용 안되게 해야함
    //              ↓ 아래 내용을 어디에 적용할 것인지        ↓ SpringConfig는 타겟에서 제외함
    //@Around("execution(* hello.hellospring..*(..)) && !target(hello.hellospring.SpringConfig)")
    @Around("execution(* hello.hellospring..*(..))")
    public Object execut(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try{
            return joinPoint.proceed();

        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }

    }
}
