package com.geunbok.onlinevotingsys.controller;

import com.geunbok.onlinevotingsys.controller.dto.CandidateResponseDto;
import com.geunbok.onlinevotingsys.controller.dto.CandidateSaveRequestDto;
import com.geunbok.onlinevotingsys.controller.dto.CandidateUpdateRequestDto;
import com.geunbok.onlinevotingsys.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CandidateApiController {
    private final CandidateService candidateService;

    @PostMapping("/api/v1/candidate")
    public Long save(@RequestBody CandidateSaveRequestDto requestDto) {
        return candidateService.save(requestDto);
    }
    @PutMapping("/api/v1/candidate/{id}")
    public Long update(@PathVariable Long id, @RequestBody CandidateUpdateRequestDto requestDto) {
        return candidateService.update(id, requestDto);
    }
    @DeleteMapping("/api/v1/candidate/{id}")
    public Long delete(@PathVariable Long id) {
        candidateService.delete(id);

        return id;
    }
    @GetMapping("/api/v1/candidate/{id}")
    public CandidateResponseDto findById(@PathVariable Long id) {
        return candidateService.findById(id);
    }
}
