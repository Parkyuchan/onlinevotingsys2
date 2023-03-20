package com.geunbok.onlinevotingsys.service;

import com.geunbok.onlinevotingsys.config.auth.dto.OAuthAttributes;
import com.geunbok.onlinevotingsys.config.auth.dto.SessionUser;
import com.geunbok.onlinevotingsys.controller.dto.VoteDto;
import com.geunbok.onlinevotingsys.domain.CandidateRepository;
import com.geunbok.onlinevotingsys.domain.Vote;
import com.geunbok.onlinevotingsys.domain.VoteRepository;
import com.geunbok.onlinevotingsys.domain.user.User;
import com.geunbok.onlinevotingsys.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class VoteService {
    private final VoteRepository voteRepository;
    private final CandidateRepository candidateRepository;

    private final UserRepository userRepository;

    //SessionUser sessionUser;


    @Transactional
    public Long vote(VoteDto voteDto, SessionUser sessionUser){
        //User user = userRepository.findById(sessionUser.getId()).get();

        User user = userRepository.findById(sessionUser.getId()).get();

        if(!(user.getIsVoted())) {
            user.updateisVoted(true);

            Vote vote = Vote.builder()
                    //.candidate(candidateRepository.findById(voteDto.getId()).get())
                    .opposite(voteDto.isOpposite())
                    .user(user)
                    .build();
            return voteRepository.save(vote).getId();
        }
        Vote vote2 = Vote.builder()
                .build();
        return voteRepository.save(vote2).getId();
    }

    public ArrayList<Integer> getVoteResult() {

        ArrayList<Integer> result = new ArrayList<>();

        long agreeCount = voteRepository.countByVotedId();
        long disagreeCount = voteRepository.countByNotVotedId();

        result.add((int)agreeCount);
        result.add((int)disagreeCount);

        return result;
    }

}
