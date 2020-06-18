# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)


# Adding librairy for native activity
# Copied from https://medium.com/androiddevelopers/getting-started-with-c-and-android-native-activities-2213b402ffff

add_library(native_app_glue STATIC
    ${ANDROID_NDK}/sources/android/native_app_glue/android_native_app_glue.c)
target_include_directories(native_app_glue PUBLIC
    ${ANDROID_NDK}/sources/android/native_app_glue)

set(CMAKE_SHARED_LINKER_FLAGS "${CMAKE_SHARED_LINKER_FLAGS} -u ANativeActivity_onCreate")




# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.
             native-lib

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             src/main/cpp/native-lib.cpp )




# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )
find_library( # Sets the name of the path variable.
              egl-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.

               EGL )
#link_directories(${ANDROID_NDK}/ndk-bundle/toolchains/llvm/prebuilt/linux-x86_64/sysroot/usr/lib/x86_64-linux-android/27)


## I had a problem with this library. I needed to not name the variable gl-lib but gl-library and to find int hte folder
## ${ANDROID_NDK}/ndk-bundle/toolchains/llvm/prebuilt/linux-x86_64/sysroot/usr/lib/x86_64-linux-android/21 where the "glShadeModel" symbol is located
## it was in libGLESv1_CM, that is why I fill it as the name of the lib. Note that in compilation I had an error with the simbol glShadeModel
find_library( # Sets the name of the path variable.
              gl-library
              # Specifies the name of the NDK library that
              # you want CMake to locate.
              GLESv1_CM)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
                       native-lib

                       # Specifies the Native Activity logic
                       native_app_glue

                       # Specifies android
                       android

                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib}
                       ${egl-lib}
                       ${gl-library}
                       )

