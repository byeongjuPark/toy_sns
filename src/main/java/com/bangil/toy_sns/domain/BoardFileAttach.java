package com.bangil.toy_sns.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardFileAttach {
    int boardSeq;
    String originalFileName;
    String filePath;
}
