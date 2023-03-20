package com.geunbok.onlinevotingsys.controller.dto;

import com.geunbok.onlinevotingsys.domain.Candidate;
import lombok.Getter;

@Getter
public class CandidateResponseDto {
    private Long id;
    private String department_candidate1;
    private String name_candidate1;
    private String id_candidate1;
    private String department_candidate2;
    private String name_candidate2;
    private String id_candidate2;
    private String gongyak;
    private int agree;

    public CandidateResponseDto(Candidate entity) {
        this.id = entity.getId();
        this.department_candidate1 = entity.getDepartment_candidate1();
        this.name_candidate1 = entity.getName_candidate1();
        this.id_candidate1 = entity.getId_candidate1();
        this.department_candidate2 = entity.getDepartment_candidate2();
        this.name_candidate2 = entity.getName_candidate2();
        this.id_candidate2 = entity.getId_candidate2();
        this.gongyak = entity.getGongyak();
        this.agree = entity.getAgree();
    }
}
