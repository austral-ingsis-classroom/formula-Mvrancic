package edu.austral.ingsis.math.Visitor;

public interface Function {
    <K> K accept(Visitor<K> visitor);
}
