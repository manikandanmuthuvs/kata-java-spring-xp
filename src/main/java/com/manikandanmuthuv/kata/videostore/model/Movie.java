package com.manikandanmuthuv.kata.videostore.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private String id;
    private String title;
    private String genre;    
}