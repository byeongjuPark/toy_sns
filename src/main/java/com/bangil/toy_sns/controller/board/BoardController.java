package com.bangil.toy_sns.controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.bangil.toy_sns.domain.Board;
import com.bangil.toy_sns.domain.BoardFileAttach;
import com.bangil.toy_sns.service.AccountService;
import com.bangil.toy_sns.service.board.BoardService;
import com.bangil.toy_sns.util.FileUploader;
import com.bangil.toy_sns.util.JwtProvider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.servlet.http.HttpSession;



@Controller
public class BoardController {
    @Autowired
    AccountService accountService;
    @Autowired
    BoardService boardService;
    @Autowired
    JwtProvider jwtProvider;
  
    @GetMapping("/board")
    public ModelAndView writeBoard(ModelAndView mv){


        mv.setViewName("edit_board");
        return mv;
    }

    @PostMapping("/board")
    public ModelAndView postMethodName(ModelAndView mv, @RequestParam("file") MultipartFile file, @RequestParam("content") String content, HttpSession session) {
        //JwtProvider jwtProvider = new JwtProvider();
        
        String token = session.getAttribute("token").toString().substring(7);
        String userName = jwtProvider.validate(token); // 유효하지 않은 토큰은 null 반환
        int userSeq = accountService.findSeqById(userName);
        String fileExisted;
        
        String path ="";
        
        // 오리진 파일 이름
        String originalFilename = file.getOriginalFilename();
        
        // 파일 변경된 파일 이름 저장
        // 저장될 파일 경로 저장
        if(!file.isEmpty()){
            FileUploader fileUploader = new FileUploader();
            path = fileUploader.upload(file, "board");
            fileExisted = "1"; // 파일 있음
        } else {
            fileExisted = "0"; // 파일 없음
        }

        // board db에 들어갈 정보
        // 1. 유저 seq
        // 2. content
        // 3. 파일 유무
        Board board = new Board();
        board.setBoardSeq(0);
        board.setLikeCount(0);
        board.setWriteDate("");
        
        board.setContent(content);
        board.setFileExisted(fileExisted);
        board.setWriterSeq(userSeq);
        int boardSeq = boardService.addBoard(board);

        // file db에 들어갈 정보
        // 1. 실제 파일 경로
        // 2. 파일 오리진 이름
        // 3. 게시글 번호 (다시 가져와야 하는데...)
        
        // 파일 존재 시 인서트
        if(!file.isEmpty()){
            BoardFileAttach boardFileAttach = new BoardFileAttach();
            boardFileAttach.setBoardSeq(boardSeq);
            boardFileAttach.setOriginalFileName(originalFilename);
            boardFileAttach.setFilePath(path);
            boardService.addBoardFileAttach(boardFileAttach);
        }
        

        mv.setViewName("/");
        return mv;
    }
    
}
