package edu.austral.ingsis.math.Visitor;

public class Number implements Function {
  private final String number;

  public Number(String number){
    this.number = number;
  }

  @Override
  public <K> K accept(Visitor<K> visitor) {
    return visitor.visit(this);
  }

  public String getIdentifier() {
    return number;
  }
}
