package com.kx.springboot.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author kx
 * @date 2019/12/27 10:33
 */
public class AgeValidator implements ConstraintValidator<Age, Integer> {

	private Age age;
	private Integer max;
	private Integer min;

	@Override
	public void initialize(Age age) {
		this.age = age;
		this.max = age.max();
		this.min = age.min();
	}

	@Override
	public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
		return (integer <= max) && (integer >= min);
	}
}
