package ceh.calc.service.calc;

public interface Calculator {

  /**
   * 
   * @return top of stack or zero if stack is empty
   */
  double accumulator();
  
  void push(double operand);
  
  double add();
  
  double subtract();
  
  double multiply();
  
  double divide();
  
}
