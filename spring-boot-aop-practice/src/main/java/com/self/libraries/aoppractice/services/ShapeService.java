package com.self.libraries.aoppractice.services;

import com.self.libraries.aoppractice.entities.Circle;
import com.self.libraries.aoppractice.entities.Triangle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class ShapeService {

    @Autowired
    private Circle circle;

    @Autowired
    private Triangle triangle;
}
