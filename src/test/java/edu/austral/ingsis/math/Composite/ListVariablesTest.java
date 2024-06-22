package edu.austral.ingsis.math.Composite;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import edu.austral.ingsis.math.Composite.Opperands.*;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    final List<String> result = new Add(new Number(1), new Number(6)).getVariables();

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    final List<String> result = new Div(new Number(12), new Variable("div")).getVariables();

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    final List<String> result =
        new Mult(new Div(new Number(9), new Variable("x")), new Variable("y")).getVariables();

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    final List<String> result =
        new Power(new Div(new Number(27), new Variable("a")), new Variable("b")).getVariables();

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    final List<String> result =
        new Power(new Variable("z"), new Div(new Number(1), new Number(2))).getVariables();

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    final List<String> result =
        new Sub(new Abs(new Variable("value")), new Number(8)).getVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    final List<String> result =
        new Sub(new Abs(new Variable("value")), new Number(8)).getVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    final List<String> result =
        new Mult(new Sub(new Number(5), new Variable("i")), new Number(8)).getVariables();

    assertThat(result, containsInAnyOrder("i"));
  }
}
