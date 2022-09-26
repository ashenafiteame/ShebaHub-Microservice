package com.example.shebahubpost.post;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance
public abstract class Post {
    @Id
    @SequenceGenerator(
            name = "post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_sequence"

    )
    private Long postId;

    private String content;

    private LocalDate postedDate;

    public Post() {
    }

    public Post (String content, LocalDate postedDate) {
        this.content = content;
        this.postedDate = postedDate;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", content='" + content + '\'' +
                ", postedDate=" + postedDate +
                '}';
    }
}
