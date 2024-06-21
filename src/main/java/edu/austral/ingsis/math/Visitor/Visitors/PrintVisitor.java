package edu.austral.ingsis.math.Visitor.Visitors;

import edu.austral.ingsis.math.Visitor.Number;
import edu.austral.ingsis.math.Visitor.Opperands.*;
import edu.austral.ingsis.math.Visitor.Variable;
import edu.austral.ingsis.math.Visitor.Visitor;

public class PrintVisitor implements Visitor<String> {

  @Override
  public String visit(Add add) {
  return "(" + add.getLeft().accept(this) + " + " + add.getRight().accept(this) + ")";
  }

  @Override
  public String visit(Sub sub) {
    return "(" + sub.getLeft().accept(this) + " - " + sub.getRight().accept(this) + ")";
  }

  @Override
  public String visit(Mult mult) {
    return "(" + mult.getLeft().accept(this) + " * " + mult.getRight().accept(this) + ")";
  }

  @Override
  public String visit(Div div) {
    return "(" + div.getLeft().accept(this) + " / " + div.getRight().accept(this) + ")";
  }

  @Override
  public String visit(Root root) {
    return "sqrt(" + root.getNumber().accept(this) + ")";
  }

  @Override
  public String visit(Power power) {
    return "(" + power.getLeft().accept(this) + " ^ " + power.getRight().accept(this) + ")";
  }

  @Override
  public String visit(Abs abs) {
    return "|" + abs.getNumber().accept(this) + "|";
  }

  @Override
  public String visit(Number number) {
    return number.getNumber().toString();
  }

  @Override
  public String visit(Variable variable) {
    return variable.getName();
  }
}
