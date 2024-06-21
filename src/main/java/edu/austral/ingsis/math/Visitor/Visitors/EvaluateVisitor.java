package edu.austral.ingsis.math.Visitor.Visitors;

import edu.austral.ingsis.math.Visitor.Number;
import edu.austral.ingsis.math.Visitor.Opperands.*;
import edu.austral.ingsis.math.Visitor.Variable;
import edu.austral.ingsis.math.Visitor.Visitor;

import java.util.Map;

public class EvaluateVisitor implements Visitor<Double> {

  private final Map<String,Double> variables;

  public EvaluateVisitor(Map<String,Double> variables) {
    this.variables = variables;
  }

  public EvaluateVisitor() {
    this(Map.of());
  }

  @Override
  public Double visit(Add add) {
    return add.getLeft().accept(this) + add.getRight().accept(this);
  }

  @Override
  public Double visit(Sub sub) {
    return sub.getLeft().accept(this) - sub.getRight().accept(this);
  }

  @Override
  public Double visit(Mult mult) {
    return mult.getLeft().accept(this) * mult.getRight().accept(this);
  }

  @Override
  public Double visit(Div div) {
    return div.getLeft().accept(this) / div.getRight().accept(this);
  }

  @Override
  public Double visit(Root root) {
    return Math.sqrt(root.getNumber().accept(this));
  }

  @Override
  public Double visit(Power power) {
    return Math.pow(power.getLeft().accept(this), power.getRight().accept(this));
  }

  @Override
  public Double visit(Abs abs) {
    return Math.abs(abs.getNumber().accept(this));
  }

  @Override
  public Double visit(Number number) {
    return number.getNumber();
  }

  @Override
  public Double visit(Variable variable) {
    return variables.get(variable.getName());
  }
}
