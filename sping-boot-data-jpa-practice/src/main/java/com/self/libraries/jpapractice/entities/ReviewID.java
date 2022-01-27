package com.self.libraries.jpapractice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewID implements Serializable {

    private int id;
    private String actionType;
}
