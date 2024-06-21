package edu.austral.ingsis.math.Visitor;

import edu.austral.ingsis.math.Visitor.Opperands.*;
import edu.austral.ingsis.math.Visitor.Visitors.EvaluateVisitor;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResolutionWithVariablesTest {
    private final EvaluateVisitor visitor = new EvaluateVisitor();

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    EvaluateVisitor newEvaluator = visitor.setVariables(Map.of("x", 3d));
    final Double result = newEvaluator.visit(new Add(new Number(1.0), new Variable("x")));

    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    EvaluateVisitor newEvaluator = visitor.setVariables(Map.of("div", 4d));
    final Double result = newEvaluator.visit(new Div(new Number(12.0), new Variable("div")));

    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    EvaluateVisitor newEvaluator = visitor.setVariables(Map.of("x", 3d, "y", 4d));
    final Double result = newEvaluator.visit(new Mult(new Div(new Number(9.0), new Variable("x")), new Variable("y")));

    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    EvaluateVisitor newEvaluator = visitor.setVariables(Map.of("a", 9d, "b", 3d));
    final Double result = newEvaluator.visit(new Power(new Div(new Number(27.0), new Variable("a")), new Variable("b")));

    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    EvaluateVisitor newEvaluator = visitor.setVariables(Map.of("z", 36d));
    final Double result = newEvaluator.visit(new Power(new Variable("z"), new Div(new Number(1.0), new Number(2.0))));

    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    EvaluateVisitor newEvaluator = visitor.setVariables(Map.of("value", 8d));
    final Double result = newEvaluator.visit(new Sub(new Abs(new Variable("value")), new Number(8.0)));

    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    EvaluateVisitor newEvaluator = visitor.setVariables(Map.of("value", 8d));
    final Double result = newEvaluator.visit(new Sub(new Abs(new Variable("value")), new Number(8.0)));

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    EvaluateVisitor newEvaluator = visitor.setVariables(Map.of("i", 2d));
    final Double result = newEvaluator.visit(new Mult(new Sub(new Number(5.0), new Variable("i")), new Number(8.0)));

    assertThat(result, equalTo(24d));
  }
}
