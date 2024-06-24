package com.bangil.toy_sns.controller;

import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bangil.toy_sns.domain.Account;
import com.bangil.toy_sns.service.AccountService;

import lombok.RequiredArgsConstructor;


@Controller
public class IndexController {


    //private DataSource dataSource;
    private final AccountService accountService;

    public IndexController(AccountService accountService){
        this.accountService = accountService;
    }

	
	// @Autowired
	// public IndexController(DataSource dataSource) {
	// 	this.dataSource = dataSource;
	// }

   //INSERT INTO accounts values(tmp_seq.NEXTVAL, 'id2', 'pw2', 'info');



    // @GetMapping("")
    // public String getMethodName() {
    //     Connection conn = null;
	// 	//PreparedStatement pstmt = null;
	// 	//ResultSet rs = null;
    //     try{
    //         conn = dataSource.getConnection();
    //         conn.prepareStatement("INSERT INTO accounts values(tmp_seq.NEXTVAL, 'id4', 'pw2', 'info')").executeQuery();

    //         conn.close();

    //     }catch(Exception e){

    //     }


    //     return "ss";
    // }

    @GetMapping("/accounts")
    public List<Account> getUsers() {
        ArrayList<Account> accounts = (ArrayList<Account>)accountService.findAll();
        return accounts;
    }

    //@GetMapping("/accountsbymap")
    @RequestMapping(value = "/accountsbymap", method = RequestMethod.GET)
    public ModelAndView getUsersByMap(ModelAndView mv) {
        ArrayList<HashMap<String, Object>> accounts = accountService.findAllByMap();
        mv.addObject("accounts", accounts);
        mv.setViewName("index");

        return mv;
    }
    
    @GetMapping("/home")
    public String home() {
        return "index"; 
    }
    
}