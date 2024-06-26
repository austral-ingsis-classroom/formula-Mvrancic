package edu.austral.ingsis.math.Composite;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.Composite.Opperands.*;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    final Double result = new Add(new Number(1), new Variable("x")).evaluate(Map.of("x", (3.0)));

    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    final Double result =
        new Div(new Number(12), new Variable("div")).evaluate(Map.of("div", (4.0)));

    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    final Double result =
        new Mult(new Div(new Number(9), new Variable("x")), new Variable("y"))
            .evaluate(Map.of("x", (3.0), "y", (4.0)));

    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    final Double result =
        new Power(new Div(new Number(27), new Variable("a")), new Variable("b"))
            .evaluate(Map.of("a", (9.0), "b", (3.0)));

    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    final Double result =
        new Power(new Variable("z"), new Div(new Number(1), new Number(2)))
            .evaluate(Map.of("z", (36.0)));

    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    final Double result =
        new Sub(new Abs(new Variable("value")), new Number(8)).evaluate(Map.of("value", (8.0)));

    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    final Double result =
        new Sub(new Abs(new Variable("value")), new Number(8)).evaluate(Map.of("value", (8.0)));

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    final Double result =
        new Mult(new Sub(new Number(5), new Variable("i")), new Number(8))
            .evaluate(Map.of("i", (2.0)));

    assertThat(result, equalTo(24d));
  }
}
