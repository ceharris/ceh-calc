package ceh.calc.service.calc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class FloatingPointCalculatorTest {
  
  private static final double ANOTHER_OPERAND = -2.0;
  private static final double OPERAND = -1.0;
  private FloatingPointCalculator calc = new FloatingPointCalculator();
  
  @Test
  public void testPushAndExamineAccumulator() throws Exception {
    calc.push(OPERAND);
    assertThat(calc.accumulator(), is(equalTo(OPERAND)));
  }

  @Test
  public void testPushTwiceAndExamineAccumlator() throws Exception {
    calc.push(OPERAND);
    calc.push(ANOTHER_OPERAND);
    assertThat(calc.accumulator(), is(equalTo(ANOTHER_OPERAND)));
  }
  
  @Test
  public void testAccumulatorWhenEmptyStack() throws Exception {
    assertThat(calc.accumulator(), is(equalTo(0.0)));
  }
  
  @Test
  public void testAdd() throws Exception {
    calc.push(OPERAND);
    calc.push(ANOTHER_OPERAND);
    assertThat(calc.add(), is(equalTo(OPERAND + ANOTHER_OPERAND)));
    assertThat(calc.accumulator(), is(equalTo(OPERAND + ANOTHER_OPERAND)));
  }
  
  @Test
  public void testAddWhenEmptyStack() throws Exception {
    assertThat(calc.add(), is(equalTo(0.0)));
  } 

  @Test
  public void testSubtract() throws Exception {
    calc.push(OPERAND);
    calc.push(ANOTHER_OPERAND);
    assertThat(calc.subtract(), is(equalTo(OPERAND - ANOTHER_OPERAND)));
    assertThat(calc.accumulator(), is(equalTo(OPERAND - ANOTHER_OPERAND)));
  }

  @Test
  public void testSubtractWhenEmptyStack() throws Exception {
    assertThat(calc.subtract(), is(equalTo(0.0)));
  } 

  @Test
  public void testMultiply() throws Exception {
    calc.push(OPERAND);
    calc.push(ANOTHER_OPERAND);
    assertThat(calc.multiply(), is(equalTo(OPERAND * ANOTHER_OPERAND)));
    assertThat(calc.accumulator(), is(equalTo(OPERAND * ANOTHER_OPERAND)));
  }

  @Test
  public void testMultiplyWhenEmptyStack() throws Exception {
    assertThat(calc.multiply(), is(equalTo(0.0)));
  } 

  @Test
  public void testDivide() throws Exception {
    calc.push(OPERAND);
    calc.push(ANOTHER_OPERAND);
    assertThat(calc.divide(), is(equalTo(OPERAND / ANOTHER_OPERAND)));
    assertThat(calc.accumulator(), is(equalTo(OPERAND / ANOTHER_OPERAND)));
  }

  @Test
  public void testDivideWhenEmptyStack() throws Exception {
    assertThat(Double.valueOf(calc.divide()).isNaN(), is(true));
  } 

  @Test
  public void testDivideByZero() throws Exception {
    calc.push(OPERAND);
    calc.push(0);
    assertThat(Double.valueOf(calc.divide()).isInfinite(), is(true));
  }

  @Test
  public void testDivideZeroByZero() throws Exception {
    calc.push(0);
    calc.push(0);
    assertThat(Double.valueOf(calc.divide()).isNaN(), is(true));
  }


}
