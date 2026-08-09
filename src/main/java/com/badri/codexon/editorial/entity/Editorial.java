package com.badri.codexon.editorial.entity;

import com.badri.codexon.common.enums.ProgramLanguage;
import com.badri.codexon.problem.entity.Problem;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String explanation;
    @Column(columnDefinition = "TEXT",nullable = false)
    private String code;
    @NotNull
    @Column(nullable = false)
    private ProgramLanguage language;
    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
   private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "problem_id",unique = true)
    private Problem problem;
}
