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
public class Instructor extends Employee {

  private String inst;
}
