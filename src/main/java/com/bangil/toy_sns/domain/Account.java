package com.bangil.toy_sns.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Account {
    private int seq;
    private String id;
    private String pw;
    private String sex;
}
