package com.example.shebahubrating;

import com.example.shebahubrating.model.Vote;
import com.example.shebahubrating.repository.VoteRepository;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class RatingRepositoryTest {
    @Autowired
    private VoteRepository voteRepoMock;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
        voteRepoMock.deleteAll();
    }

    @Test
    void shouldFindUserById() {
        Vote vote = new Vote(10L, 10L);
        voteRepoMock.save(vote);
        Optional<Vote> v = voteRepoMock.findById(vote.getId());
        assertEquals(v.get(), vote);
    }
    @Test
    void shouldFindUserByPostId() {
        Vote vote = new Vote(10L, 10L);
        voteRepoMock.save(vote);
        Optional<Vote> v = voteRepoMock.findVoteByPostId(vote.getPostId());
        assertEquals(v.get(), vote);
    }
    @Test
    void shouldFindUserByUserId() {
        Vote vote = new Vote(10L, 10L);
        voteRepoMock.save(vote);
        Optional<Vote> v = voteRepoMock.findVoteByUserId(vote.getUserId());
        assertEquals(v.get(), vote);
    }



}