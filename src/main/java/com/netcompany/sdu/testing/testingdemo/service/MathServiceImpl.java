package com.netcompany.sdu.testing.testingdemo.service;

import org.springframework.stereotype.Service;

/**
 * Created by mrr on 27/11/2018.
 */
@Service
public class MathServiceImpl implements MathService {
    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Not allowed to divide by zero");
        }
        return a / b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }
}
