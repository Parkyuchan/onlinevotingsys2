package com.geunbok.onlinevotingsys.service;

import com.geunbok.onlinevotingsys.controller.dto.CandidateResponseDto;
import com.geunbok.onlinevotingsys.controller.dto.CandidateSaveRequestDto;
import com.geunbok.onlinevotingsys.controller.dto.CandidateUpdateRequestDto;
import com.geunbok.onlinevotingsys.controller.dto.CandidateListResponseDto;
import com.geunbok.onlinevotingsys.domain.Candidate;
import com.geunbok.onlinevotingsys.domain.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;

    @Transactional
    public Long save(CandidateSaveRequestDto requestDto) {
        return candidateRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, CandidateUpdateRequestDto requestDto) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 후보자가 없습니다. id = " + id));

        candidate.update(requestDto.getDepartment_candidate1(), requestDto.getName_candidate1(), requestDto.getName_candidate2(),
                requestDto.getGongyak());

        return id;
    }

    @Transactional
    public void delete(Long id) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 후보자가 없습니다. id = " + id));

        candidateRepository.delete(candidate);
    }

    public CandidateResponseDto findById(Long id) {
        Candidate entity = candidateRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 후보자가 없습니다. id = " + id));

        return new CandidateResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<CandidateListResponseDto> findAllDesc() {
        return candidateRepository.findAllDesc().stream()
                .map(CandidateListResponseDto::new)
                .collect(Collectors.toList());
    }
}
