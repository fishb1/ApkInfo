package com.github.fishb1.apkinfo

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ApkInfoBuilderTest {

    companion object {
        private const val COMPILE_VERSION = 34
        private const val COMPILE_VERSION_NAME = "14"
        private const val INSTALL_LOCATION = "0"
        private const val PACKAGE_NAME: String = "com.test.package"
        private const val PLATFORM_BUILD_VERSION: Int = 33
        private const val PLATFORM_BUILD_VERSION_NAME: String = "13"
        private const val VERSION_CODE: Int = 123456789
        private const val VERSION_NAME: String = "1.23.345.6789"
    }

    @Test
    fun testBuild() {
        val info = ApkInfoBuilder()
            .compileSdkVersion(COMPILE_VERSION)
            .compileSdkVersionCodename(COMPILE_VERSION_NAME)
            .installLocation(INSTALL_LOCATION)
            .packageName(PACKAGE_NAME)
            .platformBuildVersionCode(PLATFORM_BUILD_VERSION)
            .platformBuildVersionName(PLATFORM_BUILD_VERSION_NAME)
            .versionCode(VERSION_CODE)
            .versionName(VERSION_NAME)
            .build()

        assertEquals(COMPILE_VERSION, info.compileSdkVersion)
        assertEquals(COMPILE_VERSION_NAME, info.compileSdkVersionCodename)
        assertEquals(INSTALL_LOCATION, info.installLocation)
        assertEquals(PACKAGE_NAME, info.packageName)
        assertEquals(PLATFORM_BUILD_VERSION, info.platformBuildVersionCode)
        assertEquals(PLATFORM_BUILD_VERSION_NAME, info.platformBuildVersionName)
        assertEquals(VERSION_CODE, info.versionCode)
        assertEquals(VERSION_NAME, info.versionName)
    }
}
