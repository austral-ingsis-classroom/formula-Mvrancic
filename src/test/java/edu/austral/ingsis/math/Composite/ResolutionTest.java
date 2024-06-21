package edu.austral.ingsis.math.Composite;

import edu.austral.ingsis.math.Composite.Opperands.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    final Double result = new Add(new Number(1), new Number(6)).evaluate(new HashMap<>());

    assertThat(result, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    final Double result = new Div(new Number(12), new Number(2)).evaluate(new HashMap<>());

    assertThat(result, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    final Double result = new Mult(new Div(new Number(9), new Number(2)), new Number(3)).evaluate(new HashMap<>());

    assertThat(result, equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    final Double result = new Power(new Div(new Number(27), new Number(6)), new Number(2)).evaluate(new HashMap<>());

    assertThat(result, equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    final Double result = new Power(new Number(36), new Div(new Number(1), new Number(2))).evaluate(new HashMap<>());

    assertThat(result, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    final Double result = new Abs(new Number(136)).evaluate(new HashMap<>());

    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    final Double result = new Abs(new Number(-136)).evaluate(new HashMap<>());

    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    final Double result = new Mult(new Sub(new Number(5), new Number(5)), new Number(8)).evaluate(new HashMap<>());

    assertThat(result, equalTo(0d));
  }
}
