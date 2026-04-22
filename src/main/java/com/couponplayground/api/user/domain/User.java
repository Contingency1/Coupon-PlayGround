package com.couponplayground.api.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {

    private Long id;
    private String username;
    private String email;
}
