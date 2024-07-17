package com.kitcat.likelion.domain;

import com.kitcat.likelion.domain.enumration.GrowthStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.*;

@Getter
@Entity
@NoArgsConstructor
public class Pet {
    @Id
    @Column(name = "pet_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double weight;

    @Enumerated
    private GrowthStatus growthStatus;

    @ManyToOne(fetch = LAZY)
    private User user;
}
