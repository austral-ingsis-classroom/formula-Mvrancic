package edu.austral.ingsis.math.Visitor.Opperands;

import edu.austral.ingsis.math.Visitor.Function;
import edu.austral.ingsis.math.Visitor.Visitor;

public class Abs implements Function {
    private final Function number;
    public Abs(Function number) {
        this.number = number;
    }
  @Override
  public <K> K accept(Visitor<K> visitor) {
    return visitor.visit(this);
  }

  private Function getNumber() {
    return number;
  }
}
