package com.badri.codexon.user.entity;

import com.badri.codexon.common.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.Instant;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3, max = 30)
    @Column(nullable =false,unique =true,length =30)
    private String userName;
    @Email
    @NotBlank
    @Column(nullable =false, unique =true,length =250)
    private String email;
    @NotBlank
    @Column(name ="password_hash", nullable =false)
    private String passwordHash;
    @NotNull
    @Column(nullable =false)
    @Enumerated(EnumType.STRING)
    private Role role;
    private Integer rating;
    @NotNull
    @Column(nullable = false)
    private Instant createdAt;
    @NotNull
    @Column(nullable = false)
    private Instant updatedAt;
    @Column(name = "last_login_at")
    private Instant lastLoginAt;
    @Column(name = "solved_problems", nullable = false)
    private Integer solvedProblems = 0;
    @Column(name = "attempted_problems", nullable = false)
    private Integer attemptedProblems = 0;
    private Integer contestRating;

    private String profileImageUrl;

    //constructor for registered the user
    protected User(String userName, String email, String passwordHash,Role role){
        this.userName=userName;
        this.email=email;
        this.passwordHash=passwordHash;
        this.role=role;
    }

    @PrePersist
    protected void onCreat(){
        Instant now=Instant.now();

        this.updatedAt=now;
        this.createdAt=now;
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt=Instant.now();
    }

    //After successful Authentication
    public void recordSuccessfulLogin(){
        this.lastLoginAt=Instant.now();
    }

}
