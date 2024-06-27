package com.bangil.toy_sns.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.bangil.toy_sns.util.FileUploader;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class BoardController {
    
  
    @GetMapping("/board")
    public ModelAndView writeBoard(ModelAndView mv){


        mv.setViewName("edit_board");
        return mv;
    }

    @PostMapping("/board")
    public ModelAndView postMethodName(ModelAndView mv, @RequestParam("file") MultipartFile file, @RequestParam("content") String content) {
        String path;
        
        // 오리진 파일 이름
        String originalFilename = file.getOriginalFilename();
        
        // 파일 변경된 파일 이름 저장
        // 저장될 파일 경로 저장
        if(!file.isEmpty()){
            FileUploader fileUploader = new FileUploader();
            path = fileUploader.upload(file, "board");
        }

        // board db에 들어갈 정보
        // 1. board seq
        // 2. content
        // 3. writer

        // file db에 들어갈 정보
        // 1. 실제 파일 경로
        // 2. 파일 오리진 이름
        // 3. 게시글 번호


        mv.setViewName("/");
        return mv;
    }
    
}
