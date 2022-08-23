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
import com.android.apksig.internal.apk.AndroidBinXmlParser.XmlParserException
import java.io.IOException

internal object ManifestUtils {

    private const val TAG_MANIFEST = "manifest"

    private const val ATTR_COMPILE_SDK_VERSION = "compileSdkVersion"
    private const val ATTR_COMPILE_SDK_VERSION_CODENAME = "compileSdkVersionCodename"
    private const val ATTR_INSTALL_LOCATION = "installLocation"
    private const val ATTR_PACKAGE = "package"
    private const val ATTR_PLATFORM_BUILD_VERSION_CODE = "platformBuildVersionCode"
    private const val ATTR_PLATFORM_BUILD_VERSION_NAME = "platformBuildVersionName"
    private const val ATTR_VERSION_CODE = "versionCode"
    private const val ATTR_VERSION_NAME = "versionName"

    fun readApkInfo(parser: AndroidBinXmlParser): ApkInfo {
        val builder = ApkInfoBuilder()
        try {
            var eventType = parser.eventType
            while (eventType != AndroidBinXmlParser.EVENT_END_DOCUMENT) {
                if (eventType == AndroidBinXmlParser.EVENT_START_ELEMENT && parser.name == TAG_MANIFEST) {

                    for (i in 0 until parser.attributeCount) {
                        when (parser.getAttributeName(i)) {
                            ATTR_COMPILE_SDK_VERSION ->
                                builder.compileSdkVersion(parser.getAttributeIntValue(i))
                            ATTR_COMPILE_SDK_VERSION_CODENAME ->
                                builder.compileSdkVersionCodename(parser.getAttributeStringValue(i))
                            ATTR_INSTALL_LOCATION ->
                                builder.installLocation(parser.getAttributeStringValue(i))
                            ATTR_PACKAGE ->
                                builder.packageName(parser.getAttributeStringValue(i))
                            ATTR_PLATFORM_BUILD_VERSION_CODE ->
                                builder.platformBuildVersionCode(parser.getAttributeIntValue(i))
                            ATTR_PLATFORM_BUILD_VERSION_NAME ->
                                builder.platformBuildVersionName(parser.getAttributeStringValue(i))
                            ATTR_VERSION_CODE ->
                                builder.versionCode(parser.getAttributeIntValue(i))
                            ATTR_VERSION_NAME ->
                                builder.versionName(parser.getAttributeStringValue(i))
                        }
                    }
                }
                eventType = parser.next()
            }
        } catch (e: XmlParserException) {
            // ignore
        } catch (e: IOException) {
            // ignore
        }
        return builder.build()
    }
}
