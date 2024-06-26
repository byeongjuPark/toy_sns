package com.bangil.toy_sns.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BoardController {
    
  
    @GetMapping("/board")
    public ModelAndView writeBoard(ModelAndView mv){


        mv.setViewName("edit_board");
        return mv;
    }
}
