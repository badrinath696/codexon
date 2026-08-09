package com.badri.codexon.submission.entity;

import com.badri.codexon.common.enums.ProgramLanguage;
import com.badri.codexon.common.enums.Verdict;
import com.badri.codexon.contest.entity.Contest;
import com.badri.codexon.problem.entity.Problem;
import com.badri.codexon.user.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name= "submissions",
        indexes = {
                @Index(name = "idx_submissionBy_user",columnList = "user_id"),
                @Index(name="idx_submissionBy_problem",columnList="problem_id"),
                @Index(name="idx_submissionBy_contest",columnList = "contest_id"),
                @Index(name = "idx_submissionBy_user_problem",columnList = "user_id,problem_id"),
                @Index(name="idx_submissionBy_contest_problem",columnList = "contest_id,problem_id")
        }
)
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull
    private ProgramLanguage language;
    @Column(columnDefinition = "TEXT")
    private String sourceCode;
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false)
    private Verdict verdict;
    @NotNull
    @Column(nullable = false)
    private Integer executionTimeMs;
    @NotNull
    @Column(nullable = false)
    private Integer memoryUsedKb;
    @NotNull
    @Column(nullable = false)
    private LocalDateTime submittedAt;

    @NotNull
    @Column(nullable = false)
    private Integer passedTestCases;
    @NotNull
    @Column(nullable = false)
    private Integer totalTestCases;
    private Long codeSize;
    @Column(nullable = true)
    private String compileOutput;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id",nullable = false)
    private Problem problem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "contest_id",nullable = true)
    private Contest contest;
}
