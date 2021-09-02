package com.pexon.api.book;

import com.pexon.api.author.Author;
import lombok.*;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String title;

    @NonNull
    private int pages;

    @ManyToOne
    @JoinColumn(name="authorId")
    @NonNull
    private Author author;
}
