package com.example.shebahubpost.answer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DataJpaTest
class AnswerRepositoryTest {

    @Autowired
    private AnswerRepository answerRepository;

    @AfterEach
    void tearDown() {
        answerRepository.deleteAll();
    }

    @Test
    void shouldFindAnswerByPostId() {
        Answer a = new Answer(
                "this is Answer test content",
                LocalDate.now()

        );
        answerRepository.save(a);

        Optional<Answer> a2 = answerRepository.findById(a.getPostId());

        assertEquals(a2.get(), a);
    }
}