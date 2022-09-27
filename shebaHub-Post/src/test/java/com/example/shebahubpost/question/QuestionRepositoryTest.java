package com.example.shebahubpost.question;

import com.example.shebahubpost.category.Category;
import com.example.shebahubpost.post.Post;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @AfterEach
    void tearDown() {
        questionRepository.deleteAll();
    }

    @Test
    void shouldFindPostByPostId() {
        Question q = new Question(
                "this is test conetnt",
                LocalDate.now(),
                Arrays.asList("BIOLOGY")
        );
        questionRepository.save(q);

        Optional<Question> q2 = questionRepository.findById(q.getPostId());

        assertEquals(q2.get(), q);
    }

}