/*
 *  Copyright (C) 2022 fishbone
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.github.fishb1.apkinfo

/**
 * Builds an ApkInfo instance.
 */
internal class ApkInfoBuilder {

    private var compileSdkVersion: Int = 0
    private var compileSdkVersionCodename: String = ""
    private var installLocation: String = ""
    private var packageName: String = ""
    private var platformBuildVersionCode: Int = 0
    private var platformBuildVersionName: String = ""
    private var versionCode: Int = 0
    private var versionName: String = ""

    fun compileSdkVersion(value: Int) = apply {
        compileSdkVersion = value
    }

    fun compileSdkVersionCodename(value: String) = apply {
        compileSdkVersionCodename = value
    }

    fun installLocation(value: String) = apply {
        installLocation = value
    }

    fun packageName(value: String) = apply {
        packageName = value
    }

    fun platformBuildVersionCode(value: Int) = apply {
        platformBuildVersionCode = value
    }

    fun platformBuildVersionName(value: String) = apply {
        platformBuildVersionName = value
    }

    fun versionCode(value: Int) = apply {
        versionCode = value
    }

    fun versionName(value: String) = apply {
        versionName = value
    }

    fun build(): ApkInfo {
        return ApkInfo(
            compileSdkVersion = compileSdkVersion,
            compileSdkVersionCodename =compileSdkVersionCodename,
            installLocation = installLocation,
            packageName = packageName,
            platformBuildVersionCode = platformBuildVersionCode,
            platformBuildVersionName = platformBuildVersionName,
            versionCode = versionCode,
            versionName = versionName,
        )
    }
}
