@file:Suppress("unused", "NOTHING_TO_INLINE")

package com.dylanc.longan

import android.content.ContentResolver
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission


/**
 * @author Dylan Cai
 */

inline val contentResolver: ContentResolver get() = application.contentResolver

inline fun <R> ContentResolver.queryFirst(
  uri: Uri,
  projection: Array<String>? = null,
  selection: String? = null,
  selectionArgs: Array<String>? = null,
  sortOrder: String? = null,
  block: (Cursor) -> R
) =
  query(uri, projection, selection, selectionArgs, sortOrder) {
    if (it.moveToFirst()) block(it) else null
  }

inline fun <R> ContentResolver.queryLast(
  uri: Uri,
  projection: Array<String>? = null,
  selection: String? = null,
  selectionArgs: Array<String>? = null,
  sortOrder: String? = null,
  block: (Cursor) -> R
) =
  query(uri, projection, selection, selectionArgs, sortOrder) {
    if (it.moveToLast()) block(it) else null
  }

inline fun <R> ContentResolver.query(
  uri: Uri,
  projection: Array<String>? = null,
  selection: String? = null,
  selectionArgs: Array<String>? = null,
  sortOrder: String? = null,
  block: (Cursor) -> R
) =
  query(uri, projection, selection, selectionArgs, sortOrder)?.use(block)

inline fun ContentResolver.queryFirstMediaImage(
  projection: Array<String>? = null,
  selection: String? = null,
  selectionArgs: Array<String>? = null,
  sortOrder: String? = null,
  block: (Cursor) -> R
) =
  queryFirst(EXTERNAL_MEDIA_IMAGES_URI, projection, selection, selectionArgs, sortOrder, block)

inline fun ContentResolver.queryLastMediaImage(
  projection: Array<String>? = null,
  selection: String? = null,
  selectionArgs: Array<String>? = null,
  sortOrder: String? = null,
  block: (Cursor) -> R
) =
  queryLast(EXTERNAL_MEDIA_IMAGES_URI, projection, selection, selectionArgs, sortOrder, block)

inline fun ContentResolver.queryMediaImages(
  projection: Array<String>? = null,
  selection: String? = null,
  selectionArgs: Array<String>? = null,
  sortOrder: String? = null,
  block: (Cursor) -> R
) =
  query(EXTERNAL_MEDIA_IMAGES_URI, projection, selection, selectionArgs, sortOrder, block)

inline fun ContentResolver.queryFirstMediaVideo(
  projection: Array<String>? = null,
  selection: String? = null,
  selectionArgs: Array<String>? = null,
  sortOrder: String? = null,
  block: (Cursor) -> R
) =
  queryFirst(EXTERNAL_MEDIA_VIDEO_URI, projection, selection, selectionArgs, sortOrder, block)

inline fun ContentResolver.queryLastMediaVideo(
  projection: Array<String>? = null,
  selection: String? = null,
  selectionArgs: Array<String>? = null,
  sortOrder: String? = null,
  block: (Cursor) -> R
) =
  queryLast(EXTERNAL_MEDIA_VIDEO_URI, projection, selection, selectionArgs, sortOrder, block)

inline fun ContentResolver.queryMediaVideos(
  projection: Array<String>? = null,
  selection: String? = null,
  selectionArgs: Array<String>? = null,
  sortOrder: String? = null,
  block: (Cursor) -> R
) =
  query(EXTERNAL_MEDIA_VIDEO_URI, projection, selection, selectionArgs, sortOrder, block)

inline fun ContentResolver.queryFirstMediaAudio(
  projection: Array<String>? = null,
  selection: String? = null,
  selectionArgs: Array<String>? = null,
  sortOrder: String? = null,
  block: (Cursor) -> R
) =
  queryFirst(EXTERNAL_MEDIA_AUDIO_URI, projection, selection, selectionArgs, sortOrder, block)

inline fun ContentResolver.queryLastMediaAudio(
  projection: Array<String>? = null,
  selection: String? = null,
  selectionArgs: Array<String>? = null,
  sortOrder: String? = null,
  block: (Cursor) -> R
) =
  queryLast(EXTERNAL_MEDIA_AUDIO_URI, projection, selection, selectionArgs, sortOrder, block)

inline fun ContentResolver.queryMediaAudios(
  projection: Array<String>? = null,
  selection: String? = null,
  selectionArgs: Array<String>? = null,
  sortOrder: String? = null,
  block: (Cursor) -> R
) =
  query(EXTERNAL_MEDIA_AUDIO_URI, projection, selection, selectionArgs, sortOrder, block)

@RequiresApi(Build.VERSION_CODES.Q)
inline fun ContentResolver.queryFirstMediaDownload(
  projection: Array<String>? = null,
  selection: String? = null,
  selectionArgs: Array<String>? = null,
  sortOrder: String? = null,
  block: (Cursor) -> R
) =
  queryFirst(EXTERNAL_MEDIA_DOWNLOADS_URI, projection, selection, selectionArgs, sortOrder, block)

@RequiresApi(Build.VERSION_CODES.Q)
inline fun ContentResolver.queryLastMediaDownload(
  projection: Array<String>? = null,
  selection: String? = null,
  selectionArgs: Array<String>? = null,
  sortOrder: String? = null,
  block: (Cursor) -> R
) =
  queryLast(EXTERNAL_MEDIA_DOWNLOADS_URI, projection, selection, selectionArgs, sortOrder, block)

@RequiresApi(Build.VERSION_CODES.Q)
inline fun ContentResolver.queryMediaDownloads(
  projection: Array<String>? = null,
  selection: String? = null,
  selectionArgs: Array<String>? = null,
  sortOrder: String? = null,
  block: (Cursor) -> R
) =
  query(EXTERNAL_MEDIA_DOWNLOADS_URI, projection, selection, selectionArgs, sortOrder, block)

inline fun ContentResolver.insert(uri: Uri, crossinline block: ContentValues.() -> Unit = {}) =
  contentResolver.insert(uri, contentValues(block))

inline fun ContentResolver.insertMediaImage(crossinline block: ContentValues.() -> Unit = {}) =
  contentResolver.insert(EXTERNAL_MEDIA_IMAGES_URI, block)

inline fun ContentResolver.insertMediaVideo(crossinline block: ContentValues.() -> Unit = {}) =
  contentResolver.insert(EXTERNAL_MEDIA_VIDEO_URI, block)

inline fun ContentResolver.insertMediaAudio(crossinline block: ContentValues.() -> Unit = {}) =
  contentResolver.insert(EXTERNAL_MEDIA_AUDIO_URI, block)

@RequiresApi(Build.VERSION_CODES.Q)
inline fun ContentResolver.insertMediaDownload(crossinline block: ContentValues.() -> Unit = {}) =
  contentResolver.insert(EXTERNAL_MEDIA_DOWNLOADS_URI, block)

inline fun ContentResolver.update(
  @RequiresPermission.Write uri: Uri,
  where: String? = null,
  selectionArgs: Array<String>? = null,
  crossinline block: ContentValues.() -> Unit
) =
  update(uri, contentValues(block), where, selectionArgs)

@Suppress("EXTENSION_SHADOWED_BY_MEMBER")
inline fun ContentResolver.delete(
  @RequiresPermission.Write uri: Uri,
  where: String? = null,
  selectionArgs: Array<String>? = null
) =
  delete(uri, where, selectionArgs)

inline fun contentValues(block: ContentValues.() -> Unit) = ContentValues().apply(block)

inline var ContentValues.displayName: String?
  get() = get(MediaStore.MediaColumns.DISPLAY_NAME) as String?
  set(value) = put(MediaStore.MediaColumns.DISPLAY_NAME, value)

inline var ContentValues.relativePath: String?
  get() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
    get(MediaStore.MediaColumns.RELATIVE_PATH) as String?
  } else null
  set(value) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
      put(MediaStore.MediaColumns.RELATIVE_PATH, value)
    }
  }

inline var ContentValues.mimeType: String?
  get() = get(MediaStore.MediaColumns.MIME_TYPE) as String?
  set(value) = put(MediaStore.MediaColumns.MIME_TYPE, value)

inline var ContentValues.imageDescription: String?
  get() = get(MediaStore.Images.Media.DESCRIPTION) as String?
  set(value) = put(MediaStore.Images.Media.DESCRIPTION, value)

inline var ContentValues.videoDescription: String?
  get() = get(MediaStore.Images.Media.DESCRIPTION) as String?
  set(value) = put(MediaStore.Video.Media.DESCRIPTION, value)

inline var ContentValues.dateAdded: Long?
  get() = get(MediaStore.MediaColumns.DATE_ADDED) as Long?
  set(value) = put(MediaStore.MediaColumns.DATE_ADDED, value)

inline var ContentValues.dateModified: Long?
  get() = get(MediaStore.MediaColumns.DATE_MODIFIED) as Long?
  set(value) = put(MediaStore.MediaColumns.DATE_MODIFIED, value)
