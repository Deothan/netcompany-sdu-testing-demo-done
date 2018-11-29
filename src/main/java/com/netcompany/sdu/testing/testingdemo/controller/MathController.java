package com.netcompany.sdu.testing.testingdemo.controller;

import com.netcompany.sdu.testing.testingdemo.form.MathForm;
import com.netcompany.sdu.testing.testingdemo.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mrr on 27/11/2018.
 */

@Controller
public class MathController {

    @Autowired
    private MathService mathService;

    @RequestMapping(method=GET, value={"/", "/home", "/index"})
    public String getFrontPage(Model model) {
        model.addAttribute("mathForm", new MathForm());
        return "home";
    }

    @RequestMapping(method=POST, value={"/calculate"})
    public String calculateWithForm(MathForm mathForm, Model model) {
        String message = "";
        double result;

        switch (mathForm.getSign()) {
            case ADD:
                result = mathService.add(mathForm.getA(), mathForm.getB());
                break;
            case SUBTRACT:
                result = mathService.subtract(mathForm.getA(), mathForm.getB());
                break;
            case DIVIDE:
                try {
                    result = mathService.divide(mathForm.getA(), mathForm.getB());
                } catch (IllegalArgumentException e) {
                    result = 0;
                    message = "Division by zero is not allowed";
                }
                break;
            case MULTIPLY:
                result = mathService.multiply(mathForm.getA(), mathForm.getB());
                break;
            default:
                throw new IllegalArgumentException("Unrecognized sign");
        }
        model.addAttribute("mathForm", mathForm);
        model.addAttribute("result", result);
        model.addAttribute("error", message);

        return "home";
    }

    @RequestMapping(method=GET, value={"/calculate/add"})
    public @ResponseBody String calculateAdd(@RequestParam(value = "a") double a, @RequestParam(value = "b") double b) {
        return String.valueOf(mathService.add(a, b));
    }
}
