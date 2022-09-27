package com.example.shebahubrating;

import com.example.shebahubrating.model.Vote;
import com.example.shebahubrating.repository.VoteRepository;
import com.example.shebahubrating.service.VoteService;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
@ExtendWith({MockitoExtension.class})
class RatingServiceTest {
    private final Faker faker = new Faker();
    @Mock
    private VoteRepository voteRepository;
    private VoteService voteService;

    @BeforeEach
    void setUp() {
        voteService=new VoteService(voteRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
    }
    @Test
    void canGetAllVotes() {
        voteService.getAllVotes();
        verify(voteRepository).findAll();
    }


    @Test
    void canAddVote() {
        Vote vote=new Vote(10L,10L);
        voteService.createVote(vote);
        ArgumentCaptor<Vote> voteArgumentCaptor=ArgumentCaptor.forClass(Vote.class);
        verify(voteRepository).save(voteArgumentCaptor.capture());
        Vote voteArgumentCaptorValue=voteArgumentCaptor.getValue();
        assertThat(voteArgumentCaptorValue).isEqualTo(vote);

    }
}