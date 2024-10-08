package com.bangil.toy_sns.service.board;

import org.springframework.stereotype.Service;

import com.bangil.toy_sns.domain.Board;
import com.bangil.toy_sns.domain.BoardFileAttach;
import com.bangil.toy_sns.mapper.BoardMapper;

@Service
public class BoardServiceImp implements BoardService{
    
    BoardMapper boardMapper;
    public BoardServiceImp(BoardMapper boardMapper){
        this.boardMapper = boardMapper;
    }

    @Override
    public int addBoard(Board board) {
        boardMapper.insertBoard(board);
        int boardSeq = boardMapper.insertBoard(board);
        System.err.println();
        return boardSeq;
    }
    @Override
    public void addBoardFileAttach(BoardFileAttach boardFileAttach) {
        boardMapper.insertBoardFileAttach(boardFileAttach);
        
    }
    
}
