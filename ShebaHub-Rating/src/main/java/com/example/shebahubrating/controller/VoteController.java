package com.example.shebahubrating.controller;

import com.example.shebahubrating.model.Vote;
import com.example.shebahubrating.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vote")
public class VoteController {
    @Autowired
    private VoteService voteService;


    @GetMapping("/votes")
    public List<Vote> getVotes() {
        return voteService.getAllVotes();
    }
    @GetMapping("/votebyid/{id}")
    public Optional<Vote> getVoteById(@PathVariable("id") Long id) {
        return voteService.getVoteById(id);
    }
    @GetMapping("/votebypost/{id}")
    public Optional<Vote> getVoteByPost(@PathVariable("id") Long postId) {
        return voteService.getVoteByPost(postId);
    }
    @GetMapping("/votebyuser/{id}")
    public Optional<Vote> getVoteByUser(@PathVariable("id") Long userId) {
        return voteService.getVoteByUser(userId);
    }

    @PostMapping("/createvote")
    public String addVote(@RequestBody Vote vote) {
        voteService.createVote(vote);
        return "Vote with id= " + vote.getId() + " created successfully";
    }

    @PutMapping("/updateVote")
    public String updateVote(@RequestBody Vote vote) {
        voteService.updateVote(vote);
        return "Vote with id= " + vote.getUserId() + " updated successfully";

    }

    @DeleteMapping("/delete/{id}")
    public String deleteVote(@PathVariable("id") Long id) {
        voteService.deleteVote(id);
        return "Vote with id= " + id + " updated successfully";

    }
}
