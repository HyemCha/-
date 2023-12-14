package springmvc.reqandres.data;

import lombok.Data;

@Data
public class MemberDto {
    private Long id;
    private String name;
    private int grade;

    public MemberDto(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
}
