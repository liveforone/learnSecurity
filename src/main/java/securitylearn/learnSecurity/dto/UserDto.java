package securitylearn.learnSecurity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter  //dto는 setter 열자
public class UserDto {  //dto는 수정이 불가능한 객체

    private String email;
    private String password;
    private String auth;
}
