package com.example.mongodbex1.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document("movies")
@Data
@NoArgsConstructor
public class Movie {

    @Id
    public String id;

    public String title;

    public String type;

    public String plot;

    @Override
    public String toString() {
        return "Movie title="+title+", type="+type+", plot="+plot;
    }

    
}
