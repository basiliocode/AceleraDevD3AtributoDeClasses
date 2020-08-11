package com.challenge.interfaces;

import java.math.BigDecimal;

public interface Calculavel {

    BigDecimal somar(Object klass) throws IllegalAccessException;

    BigDecimal subtrair(Object klass) throws IllegalAccessException;

    BigDecimal totalizar(Object klass) throws IllegalAccessException;
}
