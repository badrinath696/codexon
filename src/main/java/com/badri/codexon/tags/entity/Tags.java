package com.badri.codexon.tags.entity;

import com.badri.codexon.problem.entity.ProblemTag;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true,length = 50)
    private String name;

    @OneToMany(mappedBy = "tag",fetch=FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProblemTag> problemTags;
}
