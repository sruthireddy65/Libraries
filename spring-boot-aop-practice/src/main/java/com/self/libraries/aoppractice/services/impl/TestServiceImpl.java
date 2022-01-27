package com.self.libraries.aoppractice.services.impl;

import com.self.libraries.aoppractice.services.TestService;
import org.springframework.stereotype.Component;

@Component
public class TestServiceImpl implements TestService {
    @Override
    public void test() {
        System.out.println("test method");
    }
}
