package org.sopt.sopkathon.domain.problem.api.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.sopt.sopkathon.domain.item.core.Item;
import org.sopt.sopkathon.domain.problem.api.dto.request.CreateProblemRequestDTO;
import org.sopt.sopkathon.domain.problem.api.vo.ProblemVo;
import org.sopt.sopkathon.domain.problem.api.vo.ProblemsVo;
import org.sopt.sopkathon.domain.problem.core.Problem;
import org.sopt.sopkathon.domain.problem.core.ProblemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProblemService {

    private final ProblemRepository problemRepository;

    public ProblemService(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    @Transactional(readOnly = true)
    public ProblemsVo getNotCompletedProblems() {
        return ProblemsVo.toProblemsVo(
                problemRepository.getProblemByIsCompleted(true).stream()
                        .map(ProblemVo::toProblemVo)
                        .toList()
        );
    }

    @Transactional
    public void patchProblem(
            final long problemId,
            final long itemId
    ) {
        Problem problem = problemRepository.findById(problemId).orElseThrow(
                () -> new IllegalArgumentException()
        );

        problem.getItems().forEach(item -> {
            if (item.getId() == itemId) {
                item.setIsSelected(true);
            }
        });

        problem.setCompletedAt(LocalDateTime.now());
        problem.setCompleted(true);
    }

    @Transactional
    public void createProblem(CreateProblemRequestDTO createProblemRequestDTO) {

        boolean randomSelection = Math.random() < 0.5;
        Item item1 = new Item(createProblemRequestDTO.getItems().get(0).getContent(), randomSelection);
        Item item2 = new Item(createProblemRequestDTO.getItems().get(1).getContent(), randomSelection);
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        Problem problem = new Problem(createProblemRequestDTO.getTitle(), items);
        problemRepository.save(problem);
    }

    @Transactional(readOnly = true)
    public ProblemVo getProblem() {
        Optional<Problem> first = problemRepository.getProblemByIsCompleted(false).stream().findFirst();
        System.out.println(first.get().getItems().get(0).getContent());
        System.out.println(first.get().getItems().get(1).getContent());
        return first.map(ProblemVo::toProblemVo).orElse(null);
    }
}
