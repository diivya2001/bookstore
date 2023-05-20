package com.example.books.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Book")
public class Book
{
    @Id
    @Column(name = "bookId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(name = "bookName")
    private String bookName;

    @Column(name = "description")
    private String bookdescription;

    @Column(name = "authorName")
    private String authorName;

    @Column(name ="price")
    private float price;


}
