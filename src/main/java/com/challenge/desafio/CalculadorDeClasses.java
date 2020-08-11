package com.challenge.desafio;
import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.Annotation;

public class CalculadorDeClasses implements Calculavel {


    @Override
    public BigDecimal somar(Object klass) throws IllegalAccessException {
        return somaGenerica(klass, Somar.class);
    }


    @Override
    public BigDecimal subtrair(Object klass) throws IllegalAccessException {
        return somaGenerica(klass, Subtrair.class);
    }


    public BigDecimal totalizar(Object klass) throws IllegalAccessException {
        BigDecimal soma = somar(klass);
        BigDecimal subtracao = subtrair(klass);
        return soma.subtract(subtracao);
    }

    private BigDecimal somaGenerica(Object klass, Class annotation){
        BigDecimal soma = BigDecimal.ZERO;
        for ( Field field : klass.getClass().getDeclaredFields()) {

            if (field.isAnnotationPresent(annotation)
                    && field.getType().equals(BigDecimal.class)) {
                try {
                    field.setAccessible(true);
                    soma = soma.add((BigDecimal) field.get(klass));
                } catch (IllegalAccessException e){
                    e.printStackTrace();
                }
            }
        }
        return soma;
    }
}
