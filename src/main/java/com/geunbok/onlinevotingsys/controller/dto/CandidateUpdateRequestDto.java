package com.geunbok.onlinevotingsys.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CandidateUpdateRequestDto {
    private String department_candidate1;
    private String name_candidate1;
    private String name_candidate2;
    private String gongyak;

    @Builder
    public CandidateUpdateRequestDto(String department_candidate1, String name_candidate1, String name_candidate2, String gongyak) {
        this.department_candidate1 = department_candidate1;
        this.name_candidate1 = name_candidate1;
        this.name_candidate2 = name_candidate2;
        this.gongyak = gongyak;
    }
}
