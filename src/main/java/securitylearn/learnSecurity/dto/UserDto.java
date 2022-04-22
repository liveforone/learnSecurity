package securitylearn.learnSecurity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter  //dto는 setter 열자
public class UserDto {

    private String email;
    private String password;
    private String auth;
}
