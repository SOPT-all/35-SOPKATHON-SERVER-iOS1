package org.sopt.sopkathon.domain.item.core;

import jakarta.persistence.*;
import org.sopt.sopkathon.domain.problem.core.Problem;

@Entity
@Table(name="item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String content;

    @Column(columnDefinition = "BOOLEAN")
    private Boolean isSelected;

    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;

    protected Item() {}

    public Item(
            final String content,
            final Boolean isSelected
    ) {
        this.content = content;
        this.isSelected = isSelected;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public Problem getProblems() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public void setIsSelected(final boolean isSelected) {
        this.isSelected = isSelected;
    }
}
