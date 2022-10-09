package com.dingyi.myluaapp.ide.plugins.cl;


import androidx.annotation.Nullable;

import com.dingyi.myluaapp.openapi.extensions.PluginDescriptor;
import com.dingyi.myluaapp.openapi.extensions.PluginId;

import org.intellij.lang.annotations.MagicConstant;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.Collection;

public interface PluginAwareClassLoader {
    int ACTIVE = 1;
    int UNLOAD_IN_PROGRESS = 2;

    @NotNull
    PluginDescriptor getPluginDescriptor();

    @NotNull
    PluginId getPluginId();

    int getInstanceId();

    long getEdtTime();

    long getBackgroundTime();

    long getLoadedClassCount();

    Collection<Path> getFiles();

    @MagicConstant(intValues = {ACTIVE, UNLOAD_IN_PROGRESS})
    int getState();

    /**
     * Loads class by name from this classloader and delegates loading to parent classloaders if and only if not found.
     */
    @Nullable
    Class<?> tryLoadingClass(@NotNull String name, boolean forceLoadFromSubPluginClassloader)
            throws ClassNotFoundException;

    @Nullable String getPackagePrefix();
}