package com.netcompany.sdu.testing.testingdemo.controller;

import com.netcompany.sdu.testing.testingdemo.TestingDemoApplication;
import com.netcompany.sdu.testing.testingdemo.service.MathService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by mrr on 27/11/2018.
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestingDemoApplication.class)
@SpringBootTest
public class MathServiceTest {

    @Autowired
    private MathService mathService;

    @Test
    public void testAddition() {
        assertEquals(-3.0, mathService.add(-1.0, -2.0), 0);
        assertEquals(1.0, mathService.add(-1.0, 2.0), 0);
        assertEquals(0.0, mathService.add(0.0, 0.0), 0);
        assertEquals(-1.0, mathService.add(1.0, -2.0), 0);
        assertEquals(3.0, mathService.add(1.0, 2.0), 0);
    }

    @Test
    public void testSubtraction(){
        assertEquals(1.0, mathService.subtract(-1.0, -2.0), 0);
        assertEquals(-3.0, mathService.subtract(-1.0, 2.0), 0);
        assertEquals(0.0, mathService.subtract(0.0, 0.0), 0);
        assertEquals(3.0, mathService.subtract(1.0, -2.0), 0);
        assertEquals(-1.0, mathService.subtract(1.0, 2.0), 0);
    }

    @Test
    public void testDivision() {
        assertEquals(-2.0, mathService.divide(2.0, -1.0), 0);
        assertEquals(-0.5, mathService.divide(-1.0, 2.0), 0);
        assertEquals(0.0, mathService.divide(0.0, -2.0), 0);
        assertEquals(2.0, mathService.divide(4.0, 2.0), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZeroException() {
        assertEquals(0.0, mathService.divide(1.0, 0.0), 0);
        assertEquals(0.0, mathService.divide(-1.0, 0.0), 0);
    }

    @Test
    public void testMultiplication() {
        assertEquals(-2.0, mathService.multiply(1.0, -2.0), 0);
        assertEquals(-0.5, mathService.multiply(-1.0, 0.5), 0);
        assertEquals(0.0, mathService.multiply(0.0, -2.0), 0);
        assertEquals(0.0, mathService.multiply(2.0, 0.0), 0);
        assertEquals(8.0, mathService.multiply(4.0, 2.0), 0);
    }
}