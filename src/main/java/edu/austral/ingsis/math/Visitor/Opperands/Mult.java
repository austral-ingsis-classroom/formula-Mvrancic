package edu.austral.ingsis.math.Visitor.Opperands;

import edu.austral.ingsis.math.Visitor.Function;
import edu.austral.ingsis.math.Visitor.Visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Mult implements edu.austral.ingsis.math.Visitor.Function {
  private final Function left;
  private final Function right;
  public Mult(Function left, Function right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public <K> K accept(Visitor<K> visitor) {
    return visitor.visit(this);
  }
  private Function getLeft() {
    return left;
  }
  private Function getRight() {
    return right;
  }
}
