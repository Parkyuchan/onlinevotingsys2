package com.geunbok.onlinevotingsys.domain;

import com.geunbok.onlinevotingsys.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Vote extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean opposite;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @Column
    private String userName;

    @OneToOne(fetch = FetchType.LAZY)
    private Candidate candidate;
    @Builder
    public Vote(boolean opposite, User user, Candidate candidate){
        this.opposite = opposite;
        this.user = user;
        this.userName = user.getName();
        this.candidate = candidate;
    }
}
