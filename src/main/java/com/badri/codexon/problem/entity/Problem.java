package com.badri.codexon.problem.entity;

import com.badri.codexon.common.enums.Difficulty;
import com.badri.codexon.common.enums.ProblemSolvedStatus;
import com.badri.codexon.common.enums.ProblemStatus;
import com.badri.codexon.contest.entity.ContestProblem;
import com.badri.codexon.example.entity.Example;
import com.badri.codexon.testcase.entity.TestCase;
import com.badri.codexon.user.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique =true,nullable=false)
    private String title;
    @NotBlank
    @Column(columnDefinition = "TEXT",nullable = true)
    private String description;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Difficulty difficulty;
    @NotBlank
    @Column(columnDefinition = "TEXT",nullable = false)
    private String constraints;
    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
    @NotNull
    @Column(nullable = false)
    private Integer timeLimitMs;
    @NotNull
    @Column(nullable = false)
    private Integer memoryLimitMb;
    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProblemStatus problemStatus;

//    @ManyToOne
//    @JoinColumn(name = "created_by",nullable = false)
//    private User createdBy;

    @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Example> examples;

    @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<TestCase> testCases;

    @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ProblemTag> problemTags;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true,mappedBy = "problem")
    private List<ContestProblem> contestProblems;


}
