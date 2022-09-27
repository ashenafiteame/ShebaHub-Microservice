package com.example.shebahubrating.service;

import com.example.shebahubrating.model.Vote;
import com.example.shebahubrating.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoteService {
    @Autowired
    private VoteRepository voteRepository;

    public VoteService(VoteRepository voteRepository) {
        this.voteRepository=voteRepository;
    }

    public void createVote(Vote vote) {
        voteRepository.save(vote);
    }

    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    public void updateVote(Vote vote) {
        voteRepository.save(vote);
    }

    public String deleteVote(Long id) {
        voteRepository.deleteById(id);
        return "vote deleted";


    }

    public Optional<Vote> getVoteById(Long id) {
        return voteRepository.findById(id);
    }

    public Optional<Vote> getVoteByPost(Long id) {
        return voteRepository.findVoteByPostId(id);
    }

    public Optional<Vote> getVoteByUser(Long id) {
        return voteRepository.findVoteByUserId(id);
    }


}
