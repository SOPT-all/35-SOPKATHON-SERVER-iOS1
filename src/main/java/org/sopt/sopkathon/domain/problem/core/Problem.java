package org.sopt.sopkathon.domain.problem.core;

import jakarta.persistence.*;
import java.util.List;
import org.sopt.sopkathon.domain.item.core.Item;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="problem")
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "problem")
    private List<Item> items;

    private String title;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime completedAt;

    @Column(columnDefinition = "BOOLEAN")
    private Boolean isCompleted;

    protected Problem() {}

    public Problem(
            final String title,
            final List<Item> items
    ) {
        this.title = title;
        this.items = items;
        this.completedAt = null;
        this.isCompleted = false;

        items.forEach(item -> {
            item.setProblem(this);
        });
    }

    public Long getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
