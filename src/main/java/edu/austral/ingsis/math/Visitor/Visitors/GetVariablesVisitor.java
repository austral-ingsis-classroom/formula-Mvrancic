package edu.austral.ingsis.math.Visitor.Visitors;

import edu.austral.ingsis.math.Visitor.Number;
import edu.austral.ingsis.math.Visitor.Opperands.*;
import edu.austral.ingsis.math.Visitor.Variable;
import edu.austral.ingsis.math.Visitor.Visitor;
import java.util.ArrayList;
import java.util.List;

public class GetVariablesVisitor implements Visitor<List<String>> {

  private List<String> join(List<String> a, List<String> b) {
    List<String> result = new ArrayList<>(a);
    result.addAll(b);
    return result;
  }

  @Override
  public List<String> visit(Add add) {
    return join(add.getLeft().accept(this), add.getRight().accept(this));
  }

  @Override
  public List<String> visit(Sub sub) {
    return join(sub.getLeft().accept(this), sub.getRight().accept(this));
  }

  @Override
  public List<String> visit(Mult mul) {
    return join(mul.getLeft().accept(this), mul.getRight().accept(this));
  }

  @Override
  public List<String> visit(Div div) {
    return join(div.getLeft().accept(this), div.getRight().accept(this));
  }

  @Override
  public List<String> visit(Root root) {
    return root.getNumber().accept(this);
  }

  @Override
  public List<String> visit(Power power) {
    return join(power.getLeft().accept(this), power.getRight().accept(this));
  }

  @Override
  public List<String> visit(Abs abs) {
    return abs.getNumber().accept(this);
  }

  @Override
  public List<String> visit(Number number) {
    return new ArrayList<>();
  }

  @Override
  public List<String> visit(Variable variable) {
    return List.of(variable.getName());
  }
}
