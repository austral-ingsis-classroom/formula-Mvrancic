package edu.austral.ingsis.math.Visitor;

public class Number implements Function {
  private final Double number;

  public Number(Double number) {
    this.number = number;
  }

  @Override
  public <K> K accept(Visitor<K> visitor) {
    return visitor.visit(this);
  }

  public Double getNumber() {
    return number;
  }
}
