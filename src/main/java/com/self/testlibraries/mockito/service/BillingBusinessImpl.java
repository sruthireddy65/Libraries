package com.self.testlibraries.mockito.service;

import java.util.List;
import java.util.stream.Collectors;

public class BillingBusinessImpl {

    private BillingService billingService;

    public BillingBusinessImpl(BillingService billingService){
        this.billingService = billingService;
    }

    public List<String> getItemOfFruits(String user){
        List<String> items = billingService.getItems(user);
        return items.stream().filter(s -> s.contains("fruit")).collect(Collectors.toList());
    }
}
