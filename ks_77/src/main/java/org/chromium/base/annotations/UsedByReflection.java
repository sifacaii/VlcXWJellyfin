package org.chromium.base.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.CONSTRUCTOR})
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/annotations/UsedByReflection.class */
public @interface UsedByReflection {
    String value();
}
