package com.badri.codexon.contest.entity;

import com.badri.codexon.user.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
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
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {
                                "contest_id", "user_id"
                        }
                )
        }
)
public class ContestParticipate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @PastOrPresent
    @Column(nullable = false)
    private LocalDateTime registered_at;
    private Integer score;
    private Integer rank;
    private Integer solvedProblems;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contest_id",nullable = false)
    private Contest contest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
}
