package org.sopt.sopkathon.domain.problem.api.controller;

import java.time.format.DateTimeFormatter;
import java.util.List;
import org.sopt.sopkathon.domain.problem.api.dto.request.CreateProblemRequestDTO;
import org.sopt.sopkathon.domain.problem.api.dto.request.PathRequest;
import org.sopt.sopkathon.domain.problem.api.dto.response.ProblemsApiResponse;
import org.sopt.sopkathon.domain.problem.api.service.ProblemService;
import org.sopt.sopkathon.domain.problem.api.vo.ProblemVo;
import org.sopt.sopkathon.domain.problem.api.vo.ProblemsVo;
import org.sopt.sopkathon.domain.problem.api.vo.response.ProblemCurrentApiResponse;
import org.sopt.sopkathon.domain.problem.api.vo.response.ProblemResponseVo;
import org.sopt.sopkathon.domain.problem.api.vo.response.ProblemsResponseVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PutMapping("/{problemId}")
    public ResponseEntity<String> patchProblem(
            final @PathVariable Long problemId,
            final @RequestBody PathRequest pathRequest
            ) {
        problemService.patchProblem(problemId, pathRequest.itemId());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping
    public ResponseEntity<Void> createProblems(@RequestBody CreateProblemRequestDTO request){
        problemService.createProblem(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/current")
    public ResponseEntity<ProblemCurrentApiResponse> getProblem() {
        ProblemVo problem = problemService.getProblem();

        ProblemCurrentApiResponse problemCurrentApiResponse = ProblemCurrentApiResponse.of(
                problem == null,
                problem
        );

        return ResponseEntity.ok(problemCurrentApiResponse);
    }
}
