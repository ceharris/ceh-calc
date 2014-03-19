package ceh.calc.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CalculatorServiceBean implements CalculatorService {

  @Override
  public Double calculate(Operator operator, Double leftOperand,
      Double rightOperand) {
    switch (operator) {
      case ADD:
        return leftOperand + rightOperand;
      case SUBTRACT:
        return leftOperand - rightOperand;
      case MULTIPLY:
        return leftOperand * rightOperand;
      case DIVIDE:
        return leftOperand / rightOperand;
      default:
        throw new IllegalArgumentException("unrecognized operator");
    }
  }
  

}
