package com.badri.codexon.contest.entity;

import com.badri.codexon.contest.enums.ContestPublishStatus;
import com.badri.codexon.submission.entity.Submission;
import com.badri.codexon.user.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max=150)
    private String title;
    @NotBlank
    @Size(max=100_000)
    @Column(columnDefinition = "TEXT")
    private String description;
    @Future
    @NotNull
    @Column(nullable = false)
    private LocalDateTime startTime;
    @Future
    @NotNull
    @Column(nullable = false)
    private LocalDateTime endTime;
    @NotNull
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @NotNull
    @Column(nullable = false)
    private ContestPublishStatus published;
    private Integer durationTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by",nullable = false)
    private User createdBy;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "contest")
    private List<Submission> submissions;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContestParticipate> contestParticipates;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContestProblem> ContestProblems;
}
