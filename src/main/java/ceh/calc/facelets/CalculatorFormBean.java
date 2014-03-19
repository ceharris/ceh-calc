package ceh.calc.facelets;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CalculatorFormBean implements Serializable {

  public enum Operator {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE;
  }
  
  private static final long serialVersionUID = 8776615110210159639L;

  private Double leftOperand;
  private Double rightOperand;
  private Operator operator;
  private Double result;

  @PostConstruct
  public void init() {
    System.out.println("created " + this);
  }
  
  @PreDestroy
  public void destroy() {
    System.out.println("destroying " + this);    
  }
  
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
//    System.out.format("%s(%s, %s)\n", operator, leftOperand, rightOperand);
    result = doCalculate(operator, leftOperand, rightOperand);
    return null;
  }

  private Double doCalculate(Operator op, Double a, Double b) {
    switch (op) {
      case ADD:
        return a + b;
      case SUBTRACT:
        return a - b;
      case MULTIPLY:
        return a * b;
      case DIVIDE:
        return a / b;
      default:
        throw new IllegalArgumentException("unrecognized operator");
    }
  }
  
}
