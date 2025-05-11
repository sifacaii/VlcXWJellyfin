package org.chromium.base.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/annotations/AccessedByNative.class */
public @interface AccessedByNative {
    String value() default "";
}
