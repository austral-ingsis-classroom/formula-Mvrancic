package edu.austral.ingsis.math.Visitor;

public class Variable implements Function{
  private final String name;

  public Variable(String name){
    this.name = name;
  }

  @Override
  public <K> K accept(Visitor<K> visitor) {
    return visitor.visit(this);
  }

  public String getIdentifier(){
    return name;
  }
}
