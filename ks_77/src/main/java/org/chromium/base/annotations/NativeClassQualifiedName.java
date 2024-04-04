package org.chromium.base.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:org/chromium/base/annotations/NativeClassQualifiedName.class */
public @interface NativeClassQualifiedName {
    String value();
}
