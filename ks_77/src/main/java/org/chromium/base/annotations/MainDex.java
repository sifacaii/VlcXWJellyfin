package org.chromium.base.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/annotations/MainDex.class */
public @interface MainDex {
}
