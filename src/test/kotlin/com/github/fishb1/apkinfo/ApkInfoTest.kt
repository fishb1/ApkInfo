package com.github.fishb1.apkinfo

import com.github.fishb1.apkinfo.utils.TestZip
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import kotlin.test.assertEquals

internal class ApkInfoTest {

    @Test
    fun testFromInputStream_ManifestIsOk_ApkInfoFound() {
        val byteStream = ByteArrayInputStream(TestZip.zipWithManifestBytes)
        val info = ApkInfo.fromInputStream(byteStream)
        assertEquals("com.example.background", info.packageName)
    }

    @Test
    fun testFromInputStream_DataIsEmpty_EmptyApkInfo() {
        val byteStream = ByteArrayInputStream(byteArrayOf())
        val info = ApkInfo.fromInputStream(byteStream)
        assertEquals(ApkInfo.EMPTY, info)
    }

    @Test
    fun testFromInputStream_RandomData_EmptyApkInfo() {
        val byteStream = ByteArrayInputStream(byteArrayOf(1, 2, 3, 4))
        val info = ApkInfo.fromInputStream(byteStream)
        assertEquals(ApkInfo.EMPTY, info)
    }

    @Test
    fun testFromInputStream_NoManifest_EmptyApkInfo() {
        val byteStream = ByteArrayInputStream(TestZip.zipNoManifestBytes)
        val info = ApkInfo.fromInputStream(byteStream)
        assertEquals(ApkInfo.EMPTY, info)
    }

    @Test
    fun testFromInputStream_EmptyManifest_EmptyApkInfo() {
        val byteStream = ByteArrayInputStream(TestZip.zipWithEmptyManifestBytes)
        val info = ApkInfo.fromInputStream(byteStream)
        assertEquals(ApkInfo.EMPTY, info)
    }
}
