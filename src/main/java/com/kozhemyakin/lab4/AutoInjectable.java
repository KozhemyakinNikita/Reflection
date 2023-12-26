package com.kozhemyakin.lab4;

import java.lang.annotation.*;

/**
 * @author n.s.kozhemyakin
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AutoInjectable {}