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
Log.d("ZIP", "App name: ${info.packageName} (v. ${info.versionName})")
```

Copyright
---------
	   Copyright (C) 2022 fishbone
	 
	 Licensed under the Apache License, Version 2.0 (the "License");
	 you may not use this file except in compliance with the License.
	 You may obtain a copy of the License at
	 
			https://www.apache.org/licenses/LICENSE-2.0
	 
	 Unless required by applicable law or agreed to in writing, software
	 distributed under the License is distributed on an "AS IS" BASIS,
	 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	 See the License for the specific language governing permissions and
	 limitations under the License.
