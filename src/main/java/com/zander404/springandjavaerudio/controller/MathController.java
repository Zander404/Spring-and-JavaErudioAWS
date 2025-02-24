package com.zander404.springandjavaerudio.controller;

import com.zander404.springandjavaerudio.exceptions.UnsupportedMathOperationException;
import com.zander404.springandjavaerudio.utils.Calculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

import static com.zander404.springandjavaerudio.utils.NumberConverter.isNumeric;
import static com.zander404.springandjavaerudio.utils.NumberConverter.toDouble;

@RestController
@RequestMapping("/math")
public class MathController {
    private AtomicLong counter = new AtomicLong();

    @GetMapping("/sum/{num_one}/{num_two}")
    public Double sum(@PathVariable(value = "num_one") String numOne, @PathVariable(value = "num_two") String numTwo) throws Exception {
        if (!isNumeric(numOne) || !isNumeric(numTwo)) {
            throw new UnsupportedMathOperationException("Operacao invalida.");
        }
        return Calculator.sum(toDouble(numOne), toDouble(numTwo));
    }

    @GetMapping("sub/{num_one}/{num_two}")
    public Double sub(@PathVariable(value = "num_one") String numOne, @PathVariable(value = "num_two") String numTwo) throws Exception {
        if (!isNumeric(numOne) || !isNumeric(numTwo)) {
            throw new UnsupportedMathOperationException("Operacao invalida.");
        }

        return Calculator.sub(toDouble(numOne), toDouble(numTwo));
    }

    @GetMapping("mult/{num_one}/{num_two}")
    public Double mult(@PathVariable(value = "num_one") String numOne, @PathVariable(value = "num_two") String numTwo) throws Exception {
        if (!isNumeric(numOne) || !isNumeric(numTwo)) {
            throw new UnsupportedMathOperationException("Operacao invalida.");
        }

        return Calculator.mul(toDouble(numOne), toDouble(numTwo));
    }

    @GetMapping("div/{num_one}/{num_two}")
    public Double div(@PathVariable(value = "num_one") String numOne, @PathVariable(value = "num_two") String numTwo) throws Exception {
        if (!isNumeric(numOne) || !isNumeric(numTwo)) {
            throw new UnsupportedMathOperationException("Operacao invalida.");
        }

        return Calculator.div(toDouble(numOne), toDouble(numTwo));
    }

    @GetMapping("mean/{num_one}/{num_two}")
    public Double mean(@PathVariable(value = "num_one") String numOne, @PathVariable(value = "num_two") String numTwo) throws Exception {
        if (!isNumeric(numOne) || !isNumeric(numTwo)) {
            throw new UnsupportedMathOperationException("Operacao invalida.");
        }

        return Calculator.mean(toDouble(numOne), toDouble(numTwo));
    }

    @GetMapping("sqrt/{num_one}")
    public Double sqrt(@PathVariable(value = "num_one") String numOne) throws Exception {
        if (!isNumeric(numOne)) {
            throw new UnsupportedMathOperationException("Operacao invalida.");
        }

        return Calculator.sqrt(toDouble(numOne));
    }


    @GetMapping("pow/{num_one}/{num_two}")
    public Double pow(@PathVariable(value = "num_one") String numOne, @PathVariable(value = "num_two") String numTwo) throws Exception {
        if (!isNumeric(numOne) || !isNumeric(numTwo)) {
            throw new UnsupportedMathOperationException("Operacao invalida.");
        }

        return Calculator.pow(toDouble(numOne), toDouble(numTwo));
    }



}
