/** */
package com.assignments.udemy.org;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Somendu
 * @since 05-Sep-2020
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Employee extends Person implements Payable {

  private int salary;

  @Override
  public double raiseSalary(double percentage) {
    // TODO Auto-generated method stub
    return 0;
  }
}
