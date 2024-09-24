package com.bangil.toy_sns.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Board {
    int boardSeq;
    int writerSeq;
    String content;
    int likeCount;
    String writeDate;
    String fileExisted;
}
