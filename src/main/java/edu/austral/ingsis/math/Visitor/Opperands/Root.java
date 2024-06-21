package edu.austral.ingsis.math.Visitor.Opperands;

import edu.austral.ingsis.math.Visitor.Function;
import edu.austral.ingsis.math.Visitor.Visitor;

public class Root implements Function {
  private final Function number;

  public Root(Function number) {
    this.number = number;
  }

  @Override
  public <K> K accept(Visitor<K> visitor) {
    return visitor.visit(this);
  }
  public Function getNumber() {
    return number;
  }
}
