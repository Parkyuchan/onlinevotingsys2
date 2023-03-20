package com.geunbok.onlinevotingsys.controller.dto;

import com.geunbok.onlinevotingsys.domain.Candidate;
import com.geunbok.onlinevotingsys.domain.Vote;
import com.geunbok.onlinevotingsys.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VoteDto implements Serializable {
    private Long id;
    private boolean opposite;
    private User user;
    private String userName;
    private Candidate candidate;

    public VoteDto(Long id, boolean opposite, User user, Candidate candidate) {

        this.id = id;
        this.opposite = opposite;
        this.user = user;
        this.userName = user.getName();
        this.candidate = candidate;
    }
}
