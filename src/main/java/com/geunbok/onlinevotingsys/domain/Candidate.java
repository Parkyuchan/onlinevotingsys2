package com.geunbok.onlinevotingsys.domain;

import com.geunbok.onlinevotingsys.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Candidate extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String department_candidate1; //학회장 학과

    @Column
    private String name_candidate1; //학회장 이름

    @Column
    private String id_candidate1; //학번

    @Column
    private String department_candidate2; //부학회장 학과

    @Column
    private String name_candidate2; //부학회장 이름

    @Column
    private String id_candidate2; //부학회장 학번

    @Column
    private String gongyak; //공약

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @Column
    private int agree;

    @Builder
    public Candidate(String department_candidate1, String name_candidate1, String id_candidate1, String department_candidate2,
                     String name_candidate2, String id_candidate2, String gongyak, User user) {
        this.department_candidate1 = department_candidate1;
        this.name_candidate1 = name_candidate1;
        this.id_candidate1 = id_candidate1;
        this.department_candidate2 = department_candidate2;
        this.name_candidate2 = name_candidate2;
        this.id_candidate2 = id_candidate2;
        this.gongyak = gongyak;
        this.user = user;
        this.agree = 0;
    }

    public void update(String department_candidate1, String name_candidate1, String name_candidate2, String gongyak) {
        this.department_candidate1 = department_candidate1;
        this.name_candidate1 = name_candidate1;
        this.name_candidate2 = name_candidate2;
        this.gongyak = gongyak;
    }

    public void setAgree() { this.agree++; }
}

