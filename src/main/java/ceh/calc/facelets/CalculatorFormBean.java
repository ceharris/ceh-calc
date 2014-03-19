package ceh.calc.facelets;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ceh.calc.service.CalculatorService;
import ceh.calc.service.Operator;

@Named
@RequestScoped
public class CalculatorFormBean implements Serializable {

  private static final long serialVersionUID = 8776615110210159639L;

  @Inject
  protected CalculatorService calculatorService;
  
  private Double leftOperand;
  private Double rightOperand;
  private Operator operator;
  private Double result;

  public Double getLeftOperand() {
    return leftOperand;
  }

  public void setLeftOperand(Double leftOperand) {
    this.leftOperand = leftOperand;
  }

  public Double getRightOperand() {
    return rightOperand;
  }

  public void setRightOperand(Double rightOperand) {
    this.rightOperand = rightOperand;
  }

  public Operator getOperator() {
    return operator;
  }

  public void setOperator(Operator operator) {
    this.operator = operator;
  }

  public Double getResult() {
    return result;
  }

  public void setResult(Double result) {
    this.result = result;
  }

  public String calculate() {
    result = calculatorService.calculate(operator, leftOperand, rightOperand);
    return null;
  }

}
