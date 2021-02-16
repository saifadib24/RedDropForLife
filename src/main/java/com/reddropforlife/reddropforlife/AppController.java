package com.reddropforlife.reddropforlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private MemberRepository repo;

    @Autowired
    private SearchedRepositoryService srepo;

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model){
        model.addAttribute("member", new Members());
        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(Members member){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(member.getPassword());
        member.setPassword(encodedPassword);
        repo.save(member);
        return "register_success";
    }

    @GetMapping("/list_members")
    public String viewMembersList(Model model){
        List<Members> listMembers = repo.findAll();
        model.addAttribute("listMembers", listMembers);
        return "members";
    }

    @RequestMapping("/search_donor")
    public String viewSearchedResult(Model model, @Param("bldgrp") String bldgrp) {
        List<Members> searchResult = srepo.listAll(bldgrp);
        model.addAttribute("searchResult", searchResult);
        model.addAttribute("bldgrp", bldgrp);
        return "search_result";
    }


}
