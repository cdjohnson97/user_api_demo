package com.todo.user_api_demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Notes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notes {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String date;
    private String time;
    private boolean isCompleted;
    // Getters and Setters

}
