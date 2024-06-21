package edu.austral.ingsis.math.Composite;

import java.util.List;
import java.util.Map;

public interface Function {
    double evaluate(Map<String, Double> variables);
    List<String> getVariables();
    String print();
}
