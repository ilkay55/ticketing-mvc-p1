package com.ilkay.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseEntity {

    private Long id;
    private LocalDateTime insertDateTime;
    private Long insertUserID;
    private LocalDateTime lastUpdateTime;
    private Long lastUpdateUserID;

}
