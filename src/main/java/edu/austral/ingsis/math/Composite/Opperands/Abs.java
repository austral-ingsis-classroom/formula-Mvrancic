package edu.austral.ingsis.math.Composite.Opperands;

import edu.austral.ingsis.math.Composite.Function;
import java.util.List;
import java.util.Map;

public class Abs implements Function {
  private final Function number;

  public Abs(Function number) {
    this.number = number;
  }

  @Override
  public double evaluate(Map<String, Double> variables) {
    return Math.abs(number.evaluate(variables));
  }

  @Override
  public List<String> getVariables() {
    return number.getVariables();
  }

  @Override
  public String print() {
    return "|" + number.print() + "|";
  }
}
