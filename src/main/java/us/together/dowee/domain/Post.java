package us.together.dowee.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer PostId;

    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "couple_id")
    Couple couple;

    LocalDateTime createdDate = LocalDateTime.now();

    protected void setCouple(Couple couple) {
        this.couple = couple;
        couple.getPosts().add(this);
    }

    protected Post() {
    }

    public static Post createPost(String title, String content, Couple couple){

        Post post = new Post();

        post.setCouple(couple);
        post.setTitle(title);
        post.setContent(content);

        return post;
    }

}