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

import com.android.apksig.internal.apk.AndroidBinXmlParser
import java.io.InputStream
import java.nio.ByteBuffer
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

/**
 * Metadata parsed from an APK manifest file.
 */
data class ApkInfo(
    val compileSdkVersion: Int = 0,
    val compileSdkVersionCodename: String = "",
    val installLocation: String = "",
    val packageName: String = "",
    val platformBuildVersionCode: Int = 0,
    val platformBuildVersionName: String = "",
    val versionCode: Int = 0,
    val versionName: String = "",
) {

    companion object {

        @Suppress("MemberVisibilityCanBePrivate")
        val EMPTY = ApkInfo()

        private const val MANIFEST_FILE_NAME = "AndroidManifest.xml"

        @Suppress("unused")
        fun fromInputStream(stream: InputStream): ApkInfo {
            ZipInputStream(stream).use { zip ->
                var entry: ZipEntry?
                do {
                    entry = zip.nextEntry
                    if (entry?.name == MANIFEST_FILE_NAME) {
                        val data = ByteBuffer.wrap(zip.readBytes())
                        val parser = AndroidBinXmlParser(data)
                        return ManifestUtils.readApkInfo(parser)
                    }
                } while (entry != null)
            }
            return EMPTY
        }
    }
}
