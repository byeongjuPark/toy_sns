package com.bangil.toy_sns.service.board;

import com.bangil.toy_sns.domain.Board;
import com.bangil.toy_sns.domain.BoardFileAttach;

public interface BoardService {
    public Long addBoard(Board board);
    public void addBoardFileAttach(BoardFileAttach boardFileAttach);
}
