package hello.core.member;

import hello.core.member.Grade;
/**
 *  회원 Entity
 *  lombok 라이브러리를 사용하지 않으므로, 생성자와 getter,setter를 생성해준다.
 */
public class Member { // step 01.

    private Long id;
    private String name;
    private Grade grade;

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

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
}
