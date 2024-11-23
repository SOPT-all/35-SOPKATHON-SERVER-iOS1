package org.sopt.sopkathon.domain.problem.core;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    private String title;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime completedAt;

    private boolean isCompleted;

    public Long getId() { return id; }

    public String getTitle() { return title; }

    public boolean isCompleted() { return false; }

    public Item getItem() { return item; }
}
