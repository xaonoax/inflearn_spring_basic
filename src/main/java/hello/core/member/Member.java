package hello.core.member;

public class Member {

    private Long Id;      // 아이디
    private String name;  // 이름
    private Grade grade;  // 등급

    public Member(Long id, String name, Grade grade) {
        Id = id;
        this.name = name;
        this.grade = grade;
    }

    // 데이터를 가져오고 사용하기 위해 getter, setter를 만들어준다.

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

}
