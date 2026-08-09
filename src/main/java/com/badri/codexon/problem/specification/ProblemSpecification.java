package com.badri.codexon.problem.specification;

import com.badri.codexon.common.enums.Difficulty;
import com.badri.codexon.common.enums.ProblemStatus;
import com.badri.codexon.problem.entity.Problem;
import com.badri.codexon.problem.entity.ProblemTag;
import jakarta.persistence.criteria.*;
import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.domain.Specification;

public final class ProblemSpecification {

    public static Specification<Problem> isPublic(ProblemStatus status){
        return new Specification<Problem>(){
            @Override
            public Predicate toPredicate(
                    Root<Problem> root,
                    CriteriaQuery<?> query,
                    CriteriaBuilder cb){
                return cb.equal(root.get("ProblemStatus"),status);
            }
        };
    }
    public static Specification<Problem> hasDifficulty(Difficulty difficulty){
        return new Specification<Problem>(){
            @Override
            public Predicate toPredicate(
                    Root<Problem> root,
                    CriteriaQuery<?> query,
                    CriteriaBuilder cb){
                return cb.equal(root.get("difficulty"),difficulty);
            }
        };
    }
    public static Specification<Problem> search(String searchKey){
        return new Specification<Problem>() {
            @Override
            public @Nullable Predicate toPredicate(Root<Problem> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(cb.lower(root.get("title")),"%"+searchKey.trim().toLowerCase()+"%");
            }
        };
    }
    public static Specification<Problem> hasTag(String tag) {
        return (root, query, cb) -> {
            Join<Problem,ProblemTag> problemTags=root.join("problemTags");
            Join<Problem,ProblemTag> tags=problemTags.join("tag");
            return cb.equal(cb.lower(tags.get("name")),tag.toLowerCase());
        };
    }
    public static Specification<Problem> isPremium(boolean premium){
            return (root, query, cb) -> {
                return cb.equal(root.get("premiumOnly"), premium);
            };
    }

}
