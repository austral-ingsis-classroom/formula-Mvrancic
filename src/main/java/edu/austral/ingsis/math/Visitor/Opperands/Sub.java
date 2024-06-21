package edu.austral.ingsis.math.Visitor.Opperands;

import edu.austral.ingsis.math.Visitor.Function;
import edu.austral.ingsis.math.Visitor.Visitor;


public class Sub implements Function {
  private final Function left;
  private final Function right;

  public Sub(Function left, Function right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public <K> K accept(Visitor<K> visitor) {
    return visitor.visit(this);
  }
  public Function getLeft() {
    return left;
  }
    public Function getRight() {
        return right;
    }
}
