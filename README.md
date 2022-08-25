Apk Info
========

A tiny tool for reading some basic metadata like package name or version from an APK file.

Installation
------------

To use ApkInfo in your Java/Kotlin project add a dependency to the `build.gradle` file. 

```groovy
dependencies {
  implementation 'com.github.fishb1:apk-info:1.0.0'
}
```

Usage
-----

Reading info from a file:
```kotlin
val info = ApkInfo.fromInputStream(
    FileInputStream(File("apk_file_name.apk"))
)
println("App name: ${info.packageName} (v. ${info.versionName})")
```

Reading info from Android assets:
```kotlin
val info = ApkInfo.fromInputStream(
    context.assets.open("apk_file_name.apk")
)
Log.d("ApkInfo", "App name: ${info.packageName} (v. ${info.versionName})")
```

Copyright
---------
    MIT License
    
    Copyright (c) 2022 fishbone
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
