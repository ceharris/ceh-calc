package ceh.calc.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import ceh.calc.service.calc.Calculator;

@ApplicationScoped
public class CalculatorServiceBean implements CalculatorService {

  @Inject
  protected Calculator calculator;
  
  @Override
  public Double calculate(Operator operator, Double leftOperand,
      Double rightOperand) {
    calculator.push(leftOperand);
    calculator.push(rightOperand);
    switch (operator) {
      case ADD:
        return calculator.add();
      case SUBTRACT:
        return calculator.subtract();
      case MULTIPLY:
        return calculator.multiply();
      case DIVIDE:
        return calculator.divide();
      default:
        throw new IllegalArgumentException("unrecognized operator");
    }
  }
  

}
