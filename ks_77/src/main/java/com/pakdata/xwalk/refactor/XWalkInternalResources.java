// Copyright (c) 2014 Intel Corporation. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package com.pakdata.xwalk.refactor;

import android.content.Context;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

class XWalkInternalResources {
    private static final String TAG = "XWalkInternalResources";

    private static boolean loaded;
    private final static String[] INTERNAL_RESOURCE_CLASSES = {
            "org.chromium.components.embedder_support.delegate.R",
            "org.chromium.components.autofill.R",
            "org.chromium.media.R",
            "org.chromium.content.R",
            "org.chromium.ui.R",
            "com.pakdata.xwalk.refactor.R",
            "org.xwalk.core.R"
    };
    private final static String GENERATED_RESOURCE_CLASS = "org.xwalk.core.R";

    // Doing org.chromium.content.R.<class>.<name> = org.xwalk.core.R.<class>.<name>
    // Use reflection to iterate over the target class is to avoid hardcode.
    private static void doResetIds(Context context) {
        // internal classes are loaded with the same classLoader of XWalkInternalResources
        final ClassLoader classLoader = XWalkInternalResources.class.getClassLoader();
        final ClassLoader appClassLoader = context.getApplicationContext().getClassLoader();
        final Map<String, Class<?>> generatedInnerClazzs = new HashMap<>();
        for (final String resourceClass : INTERNAL_RESOURCE_CLASSES) {
            try {
                final Class<?> internalResource = classLoader.loadClass(resourceClass);
                final Class<?>[] innerClazzs = internalResource.getClasses();
                for (Class<?> innerClazz : innerClazzs) {
                    final Field[] fields = innerClazz.getFields();
                    if (fields.length == 0) {
                        continue;
                    }

                    final Class<?> generatedInnerClazz;
                    final String generatedInnerClassName = innerClazz.getName().replace(
                            resourceClass, GENERATED_RESOURCE_CLASS);
                    if (generatedInnerClazzs.containsKey(generatedInnerClassName)) {
                        generatedInnerClazz = generatedInnerClazzs.get(generatedInnerClassName);
                    } else {
                        try {
                            generatedInnerClazz = appClassLoader.loadClass(generatedInnerClassName);
                        } catch (ClassNotFoundException e) {
                            Log.w(TAG, String.format("%s not found, needed by %s",
                                    generatedInnerClassName, resourceClass));
                            continue;
                        }
                        generatedInnerClazzs.put(generatedInnerClassName, generatedInnerClazz);
                    }

                    for (final Field field : fields) {
                        // It's final means we are probably not used as library project.
                        if (Modifier.isFinal(field.getModifiers())) field.setAccessible(true);
                        try {
                            final Field generatedField = generatedInnerClazz.getField(field.getName());
                            if (isIntArray(generatedField.getType())) {
                                // for example: styleable
                                final Object value = generatedField.get(null);
                                field.set(null, value);
                            } else {
                                final int value = generatedField.getInt(null);
                                field.setInt(null, value);
                            }
                        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e) {
                            Log.w(TAG, String.format("%s.%s reset failed: %s - %s, needed by %s",
                                    generatedInnerClazz.getName(), field.getName(),
                                    e.getClass().getSimpleName(), e.getMessage(), resourceClass));
                        }
                        if (Modifier.isFinal(field.getModifiers())) field.setAccessible(false);
                    }
                }
            } catch (ClassNotFoundException e) {
                Log.w(TAG, String.format("%s (resourceClass) is not found", resourceClass));
            }
        }
    }

    static void resetIds(Context context) {
        if (!loaded) {
            doResetIds(context);
            loaded = true;
        }
    }

    private static boolean isIntArray(final Class<?> type) {
        if (!type.isArray()) return false;
        final Class<?> componentType = type.getComponentType();
        return componentType.isPrimitive() && int.class.isAssignableFrom(componentType);
    }
}