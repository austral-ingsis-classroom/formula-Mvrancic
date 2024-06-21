package edu.austral.ingsis.math.Composite;

import java.util.List;
import java.util.Map;

public class Number implements Function{
    private final double number;
    public Number(double number){
        this.number = number;
    }
  @Override
  public double evaluate(Map<String, Double> variables) {
    return number;
  }

  @Override
  public List<String> getVariables() {
    return List.of();
  }

  @Override
  public String print() {
    return (number % 1 != 0) ? Double.toString(number) : Integer.toString((int) number);
  }
}
