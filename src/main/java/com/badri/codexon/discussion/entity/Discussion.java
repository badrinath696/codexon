package com.badri.codexon.discussion.entity;

import com.badri.codexon.problem.entity.Problem;
import com.badri.codexon.user.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class Discussion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String content;
    @NotNull
    @Column(nullable = false)
    private LocalDateTime created_at;
    private Integer upvote;
    private Integer downvote;
    private Integer views;
    private LocalDateTime editedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id")
    private Problem problem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
