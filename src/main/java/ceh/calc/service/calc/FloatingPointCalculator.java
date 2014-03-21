package ceh.calc.service.calc;

import java.util.Deque;
import java.util.LinkedList;

public class FloatingPointCalculator implements Calculator {

  private Deque<Double> stack = new LinkedList<Double>();
  
  
  @Override
  public double accumulator() {
    if (stack.isEmpty()) return 0;
    return stack.peek();
  }

  @Override
  public void push(double operand) {
    stack.push(operand);
  }

  @Override
  public double add() {
    double x = pop();
    double y = pop();
    stack.push(y + x);
    return stack.peek();
  }

  @Override
  public double subtract() {
    double x = pop();
    double y = pop();
    stack.push(y - x);
    return stack.peek();
  }

  @Override
  public double multiply() {
    double x = pop();
    double y = pop();
    stack.push(y * x);
    return stack.peek();
  }

  @Override
  public double divide() {
    double x = pop();
    double y = pop();
    stack.push(y / x);
    return stack.peek();
  }

  private Double pop() {
    if (stack.isEmpty()) return 0.0;
    return stack.pop();
  }

}
