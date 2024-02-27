package com.github.maxicorrea.applicationdesktopbackend.common;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Rest {

	@AliasFor(annotation = Component.class)
	String value() default "";

}
