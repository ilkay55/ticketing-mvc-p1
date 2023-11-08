package com.ilkay.entity;

import com.ilkay.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;
    private boolean enabled;
    private String phone;
    private Role role;
    private Gender gender;

    public User(Long id, LocalDateTime insertDateTime,
                Long insertUserID, LocalDateTime lastUpdateTime,
                Long lastUpdateUserID, String firstName, String lastName,
                String userName, String passWord, boolean enabled, String phone,
                Role role, Gender gender) {

        super(id, insertDateTime, insertUserID, lastUpdateTime, lastUpdateUserID);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.enabled = enabled;
        this.phone = phone;
        this.role = role;
        this.gender = gender;
    }
}
