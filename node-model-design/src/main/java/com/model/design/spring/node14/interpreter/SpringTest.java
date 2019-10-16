package com.model.design.spring.node14.interpreter;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpringTest {
    public static void main(String[] args) {
        SpelExpressionParser parser = new SpelExpressionParser () ;
        Expression expression = parser.parseExpression("(1+3-2)*3") ;
        Integer result = (Integer)expression.getValue() ;
        System.out.println("result="+result);
    }
}
