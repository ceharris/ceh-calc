package ceh.calc.service;


public interface CalculatorService {

  Double calculate(Operator operator, Double leftOperand, Double rightOperand);
  
}
