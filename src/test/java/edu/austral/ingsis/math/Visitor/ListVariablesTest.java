package edu.austral.ingsis.math.Visitor;

import edu.austral.ingsis.math.Visitor.Opperands.*;
import edu.austral.ingsis.math.Visitor.Visitors.GetVariablesVisitor;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import java.util.Collections;
import java.util.List;

public class ListVariablesTest {
  private final Visitor<List<String>> visitor = new GetVariablesVisitor();

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    final List<String> result = visitor.visit(new Add(new Number(1.0), new Number(6.0)));

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    final List<String> result = visitor.visit(new Div(new Number(12.0), new Variable("div")));

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    final List<String> result = visitor.visit(new Mult(new Div(new Number(9.0), new Variable("x")), new Variable("y")));

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    final List<String> result = visitor.visit(new Power(new Div(new Number(27.0), new Variable("a")), new Variable("b")));

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    final List<String> result = visitor.visit(new Power(new Variable("z"), new Div(new Number(1.0), new Number(2.0))));

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    final List<String> result = visitor.visit(new Sub(new Abs(new Variable("value")), new Number(8.0)));

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    final List<String> result = visitor.visit(new Sub(new Abs(new Variable("value")), new Number(8.0)));

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    final List<String> result = visitor.visit(new Mult(new Sub(new Number(5.0), new Variable("i")), new Number(8.0)));

    assertThat(result, containsInAnyOrder("i"));
  }
}
