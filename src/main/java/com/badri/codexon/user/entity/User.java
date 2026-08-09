package com.badri.codexon.user.entity;

import com.badri.codexon.common.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3, max = 30)
    @Column(nullable =false,unique =true,length =30)
    private String username;
    @Email
    @NotBlank
    @Column(nullable =false, unique =true,length =250)
    private String email;
    @NotBlank
    @Column(nullable =false)
    private String password_hash;
    @NotNull
    @Column(nullable =false)
    @Enumerated(EnumType.STRING)
    private Role role;
    private Integer rating;
    @NotNull
    @Column(nullable = false)
    private LocalDateTime created_at;
    @NotNull
    @Column(nullable = false)
    private LocalDateTime updated_at;
    @NotNull
    @Column(nullable = false)
    private LocalDateTime last_login_at;
    private Integer solvedProblems;
    private Integer attemptedProblems;
    private Integer contestRating;

    private String profileImageUrl;

}
