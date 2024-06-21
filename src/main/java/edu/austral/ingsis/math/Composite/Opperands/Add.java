package edu.austral.ingsis.math.Composite.Opperands;

import edu.austral.ingsis.math.Composite.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Add implements Function {
  private final Function left;
  private final Function right;

  public Add(Function left, Function right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public double evaluate(Map<String, Double> variables) {
    return left.evaluate(variables) + right.evaluate(variables);
  }

  @Override
  public List<String> getVariables() {
    List<String> leftVariables = left.getVariables();
    List<String> rightVariables = right.getVariables();
    return new ArrayList<>(leftVariables){{
      addAll(rightVariables);
    }};
  }

  @Override
  public String print() {
    return "(" + left.print() + " + " + right.print() + ")";
  }
}
