package com.pexon.api.author;

import lombok.*;

import javax.persistence.*;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Author
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
}
