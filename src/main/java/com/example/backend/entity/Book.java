package com.example.backend.entity;

import javax.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	@Column(name = "name", nullable = false)
	private String name;
	private String author;
	private long year;
	private long pages;
	private String publishing;
	private String link;
}