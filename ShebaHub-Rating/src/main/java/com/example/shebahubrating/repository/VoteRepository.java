package com.example.shebahubrating.repository;

import com.example.shebahubrating.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    Optional<Vote> findVoteByPostId(Long postId);

    Optional<Vote> findVoteByUserId(Long userId);

}
