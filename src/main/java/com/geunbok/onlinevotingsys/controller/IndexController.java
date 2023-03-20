package com.geunbok.onlinevotingsys.controller;

import com.geunbok.onlinevotingsys.config.auth.LoginUser;
import com.geunbok.onlinevotingsys.config.auth.dto.SessionUser;
import com.geunbok.onlinevotingsys.controller.dto.CandidateResponseDto;
import com.geunbok.onlinevotingsys.service.CandidateService;
import com.geunbok.onlinevotingsys.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final CandidateService candidateService;
    private final VoteService voteService;

    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("candidate", candidateService.findAllDesc());

        if(user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }
    @GetMapping("/candidate/save")
    public String candidateSave() {
        return "candidate-save";
    }
    @GetMapping("/candidate/update/{id}")
    public String candidateUpdate(@PathVariable Long id, Model model) {
        CandidateResponseDto dto = candidateService.findById(id);
        model.addAttribute("candidate", dto);

        return "candidate-update";
    }
    @GetMapping("/votelist")
    public String voteList(Model model) {
        model.addAttribute("candidate", candidateService.findAllDesc());

        return "votelist";
    }
    @GetMapping("/vote/{id}")
    public String vote(@PathVariable Long id, Model model) {
        CandidateResponseDto dto = candidateService.findById(id);
        model.addAttribute("candidate", dto);

        return "vote";
    }
    @GetMapping("/voteresult/{id}")
    public String voteResult(@PathVariable Long id, Model model) {
        CandidateResponseDto dto = candidateService.findById(id);
        model.addAttribute("candidate", dto);

        return "voteresult";
    }
}
