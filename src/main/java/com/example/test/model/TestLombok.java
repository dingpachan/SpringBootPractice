package com.example.test.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class TestLombok {
    private String username;
    private String password;
    @NonNull
    private Integer id;
}
