package com.self.testlibraries.mockito.service;

import java.util.Arrays;
import java.util.List;

public class BillingServiceStub implements BillingService{

    @Override
    public List<String> getItems(String user) {
        return Arrays.asList("fruit1","veg1","fruit2");
    }
}
