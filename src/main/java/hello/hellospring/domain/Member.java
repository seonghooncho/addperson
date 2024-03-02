package hello.hellospring.domain;

import jakarta.persistence.*;

@Entity
public class Member {
    @Id//primary key임
    @GeneratedValue(strategy = GenerationType.IDENTITY)//id에 식별자 값 생성(strategy = GenerationType.IDENTITY : id의 값 1씩 증가)
    private Long id;
    //name위에는 어노테이션 없기떄문에 상관없음
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
