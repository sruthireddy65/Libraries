package com.self.libraries.jpapractice.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@IdClass(ReviewID.class)
public class Review {

    @Id
    private int id;

    @Id
    private String actionType;

    private String rating;

    private String description;

    @ManyToOne
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private Course course;

    public Review(String rating, String description) {
        this.rating = rating;
        this.description = description;
    }
}
