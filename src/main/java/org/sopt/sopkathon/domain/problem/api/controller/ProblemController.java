package org.sopt.sopkathon.domain.problem.api.controller;

import java.time.format.DateTimeFormatter;
import java.util.List;
import org.sopt.sopkathon.domain.problem.api.dto.response.ProblemsApiResponse;
import org.sopt.sopkathon.domain.problem.api.service.ProblemService;
import org.sopt.sopkathon.domain.problem.api.vo.ProblemsVo;
import org.sopt.sopkathon.domain.problem.api.vo.response.ProblemResponseVo;
import org.sopt.sopkathon.domain.problem.api.vo.response.ProblemsResponseVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/problems")
public class ProblemController {

    private final ProblemService problemService;

    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping
    public ResponseEntity<ProblemsApiResponse> getProblems() {
        ProblemsVo problems = problemService.getNotCompletedProblems();
        List<ProblemResponseVo> problemResponseVos = problems.problems().stream()
                .map(problem -> ProblemResponseVo.of(
                        problem,
                        problem.createdAt().format(DateTimeFormatter.ofPattern("yyyy.MM.dd")),
                        problem.completedAt().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"))
                )).toList();
        ProblemsApiResponse problemsApiResponse = ProblemsApiResponse.toProblemsApiResponse(
                ProblemsResponseVo.toProblemsResponseVo(problemResponseVos)
        );

        return ResponseEntity.ok(problemsApiResponse);
    }
}
