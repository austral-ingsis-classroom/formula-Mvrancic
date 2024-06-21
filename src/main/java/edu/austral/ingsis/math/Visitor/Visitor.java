package edu.austral.ingsis.math.Visitor;

import edu.austral.ingsis.math.Visitor.Opperands.*;

public interface Visitor<K> {
    K visit(Add add);
    K visit(Sub sub);
    K visit(Mult mul);
    K visit(Div div);
    K visit(Root root);
    K visit (Power power);
    K visit(Abs abs);
    K visit(Number number);
    K visit(Variable variable);
}
