package edu.austral.ingsis.math.Visitor;

import edu.austral.ingsis.math.Visitor.Opperands.*;
import edu.austral.ingsis.math.Visitor.Visitors.EvaluateVisitor;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResolutionTest {
  private final Visitor<Double> visitor = new EvaluateVisitor();

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    final Double result = visitor.visit(new Add(new Number(1.0), new Number(6.0)));

    assertThat(result, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    final Double result = visitor.visit(new Div(new Number(12.0), new Number(2.0)));

    assertThat(result, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    final Double result = visitor.visit(new Mult(new Div(new Number(9.0), new Number(2.0)), new Number(3.0)));

    assertThat(result, equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    final Double result = visitor.visit(new Power(new Div(new Number(27.0), new Number(6.0)), new Number(2.0)));

    assertThat(result, equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    final Double result = visitor.visit(new Power(new Number(36.0), new Div(new Number(1.0), new Number(2.0))));

    assertThat(result, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    final Double result = visitor.visit(new Abs(new Number(136.0)));

    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    final Double result = visitor.visit(new Abs(new Number(-136.0)));

    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    final Double result = visitor.visit(new Mult(new Sub(new Number(5.0), new Number(5.0)), new Number(8.0)));

    assertThat(result, equalTo(0d));
  }
}
