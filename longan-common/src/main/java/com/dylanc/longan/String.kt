@file:Suppress("unused", "NOTHING_TO_INLINE")

package com.dylanc.longan

import android.text.format.Formatter
import android.util.Patterns
import java.util.*

/**
 * @author Dylan Cai
 */

inline val randomUUIDString: String get() = UUID.randomUUID().toString()

inline fun Long.toFileSizeString(): String = Formatter.formatFileSize(application, this)

inline fun Long.toShortFileSizeString(): String = Formatter.formatShortFileSize(application, this)

inline fun String.limitLength(length: Int) = if (this.length <= length) this else substring(0, length)

inline fun String.isPhone() = Patterns.PHONE.matcher(this).matches()

inline fun String.isEmail() = Patterns.EMAIL_ADDRESS.matcher(this).matches()