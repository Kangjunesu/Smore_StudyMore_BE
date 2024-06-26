package com.als.SMore.domain.entity;

import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "problem_options")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProblemOptions {

    @Id @Tsid
    @Column(name = "problem_options_pk")
    private Long problemOptionsPk;

    @ManyToOne
    @JoinColumn(name = "problem_pk", nullable = false)
    private Problem problem;

    @Column(name = "options_num", nullable = false)
    private Integer optionsNum;

    @Column(name = "options_content", nullable = false)
    private String optionsContent;
}
