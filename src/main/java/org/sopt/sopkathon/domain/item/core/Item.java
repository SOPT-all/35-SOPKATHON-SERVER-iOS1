package org.sopt.sopkathon.domain.item.core;

import jakarta.persistence.*;

@Entity
@Table(name="item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private Boolean isSelected;

    public Long getId() { return id; }

    public String getContent() { return content; }
}
