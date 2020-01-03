package com.kx.springboot.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author kx
 * @date 2019/12/27 10:33
 */
@Constraint(validatedBy = {AgeValidator.class})
@Documented
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Age {

	String message() default "年龄无效, 不能超过{max}, 不能小于{min}";
	int max() default 120;
	int min() default 0;
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};


}
