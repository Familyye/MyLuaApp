// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.dingyi.myluaapp.openapi.roots;

import com.dingyi.myluaapp.openapi.module.Module;
import com.dingyi.myluaapp.openapi.project.Project;
import com.dingyi.myluaapp.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Provides information about files contained in a project. Should be used from a read action.
 *
 * @see ProjectRootManager#getFileIndex()
 */

public interface ProjectFileIndex extends FileIndex {


  @NotNull
  static ProjectFileIndex getInstance(@NotNull Project project) {
    return project.get(ProjectFileIndex.class);
  }

  /**
   * Returns {@code true} if {@code file} is located under project content or library roots and not excluded or ignored
   */
  boolean isInProject(@NotNull VirtualFile file);

  /**
   * Returns {@code true} if {@code file} is located under project content or library roots, regardless of whether it's marked as excluded or not,
   * and returns {@code false} if {@code file} is located outside or it or one of its parent directories is ignored.
   */
  boolean isInProjectOrExcluded(@NotNull VirtualFile file);

  /**
   * Returns module to which content the specified file belongs or null if the file does not belong to content of any module.
   */
  @Nullable
  Module getModuleForFile(@NotNull VirtualFile file);

  /**
   * Returns module to which content the specified file belongs or null if the file does not belong to content of any module.
   *
   * @param honorExclusion if {@code false} the containing module will be returned even if the file is located under a folder marked as excluded
   */
  @Nullable
  Module getModuleForFile(@NotNull VirtualFile file, boolean honorExclusion);

  /**
   * Returns the order entries which contain the specified file (either in CLASSES or SOURCES).
   */
  @NotNull
  List<OrderEntry> getOrderEntriesForFile(@NotNull VirtualFile file);

  /**
   * Returns a classpath entry to which the specified file or directory belongs.
   *
   * @return the file for the classpath entry, or null if the file is not a compiled
   *         class file or directory belonging to a library.
   */
  @Nullable
  VirtualFile getClassRootForFile(@NotNull VirtualFile file);

  /**
   * Returns the module source root or library source root to which the specified file or directory belongs.
   *
   * @return the file for the source root, or null if the file is not located under any of the source roots for the module.
   */
  @Nullable
  VirtualFile getSourceRootForFile(@NotNull VirtualFile file);

  /**
   * Returns the module content root to which the specified file or directory belongs or null if the file does not belong to content of any module.
   */
  @Nullable
  VirtualFile getContentRootForFile(@NotNull VirtualFile file);

  /**
   * Returns the module content root to which the specified file or directory belongs or null if the file does not belong to content of any module.
   *
   * @param honorExclusion if {@code false} the containing content root will be returned even if the file is located under a folder marked as excluded
   */
  @Nullable
  VirtualFile getContentRootForFile(@NotNull VirtualFile file, final boolean honorExclusion);

  /**
   * @deprecated use {@link com.intellij.openapi.roots.PackageIndex#getPackageNameByDirectory(VirtualFile)} from Java plugin instead.
   */
  @Deprecated
  @Nullable
  String getPackageNameByDirectory(@NotNull VirtualFile dir);

  /**
   * Returns true if {@code file} is a file which belongs to the classes (not sources) of some library which is included into dependencies
   * of some module.
   * @deprecated name of this method may be misleading, actually it doesn't check that {@code file} has the 'class' extension. 
   * Use {@link #isInLibraryClasses} with additional {@code !file.isDirectory()} check instead.   
   */
  @Deprecated
  boolean isLibraryClassFile(@NotNull VirtualFile file);

  /**
   * Returns true if {@code fileOrDir} is a file or directory from production/test sources of some module or sources of some library which is included into dependencies
   * of some module.
   */
  boolean isInSource(@NotNull VirtualFile fileOrDir);

  /**
   * Returns true if {@code fileOrDir} belongs to classes of some library which is included into dependencies of some module.
   */
  boolean isInLibraryClasses(@NotNull VirtualFile fileOrDir);

  /**
   * @return true if the file belongs to the classes or sources of a library added to dependencies of the project,
   *         false otherwise
   */
  boolean isInLibrary(@NotNull VirtualFile fileOrDir);

  /**
   * Returns true if {@code fileOrDir} is a file or directory from sources of some library which is included into dependencies
   * of some module.
   */
  boolean isInLibrarySource(@NotNull VirtualFile fileOrDir);



  /**
   * Checks if the specified file or directory is located under project roots but the file itself or one of its parent directories is
   * either excluded from the project or ignored by {@link FileTypeRegistry#isFileIgnored(VirtualFile)}).
   *
   * @return true if {@code file} is excluded or ignored, false otherwise.
   */
  boolean isExcluded(@NotNull VirtualFile file);



  @Nullable
  default SourceFolder getSourceFolder(@NotNull VirtualFile fileOrDir) {
    return null;
  }
}
