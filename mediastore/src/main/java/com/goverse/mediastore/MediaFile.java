package com.goverse.mediastore;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.BaseColumns;
import android.provider.MediaStore;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class MediaFile {

    private static final String TAG = "MediaFile";
    private static ContentResolver mContentResolver;
    private MediaParam mediaParam;

    public <T extends MediaStore.MediaColumns> MediaFile(Context context, Class<T> mediaColumnsType, MediaParam mediaParam) {
        this.mediaParam = mediaParam;
        this.mContentResolver = context.getContentResolver();
    }

    /**
     * get the uri for the mediafile.
     * @return uri
     */
    public Uri getUri() {
        Cursor cursor = query();
        try {
            if (cursor != null && cursor.getCount() == 1) {
                cursor.moveToFirst();
                int id = cursor.getInt(cursor.getColumnIndex(BaseColumns._ID));
                return ContentUris.withAppendedId(mediaParam.getContentUri(), id);
            }
        } finally {
            if (cursor != null) cursor.close();
        }
        return null;
    }

    /**
     * check if the current mediafile exists.
     * @return isExist
     */
    public boolean isExist() {

        Uri uri = getUri();
        if (uri != null) {
            ParcelFileDescriptor parcelFileDescriptor = openFileDescriptor(uri);
            try {
                if (parcelFileDescriptor != null) {
                    parcelFileDescriptor.close();
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    /**
     * create the mediafile which related to mediaParam..
     * @return uri
     */
    public Uri create() {
        Log.d(TAG, "create");
        Uri uri = mContentResolver.insert(mediaParam.getContentUri(), mediaParam.getContentValues());
        return uri;
    }

    /**
     * Query the mediafile which related to mediaParam.
     * @return
     */
    public Cursor query() {

        StringBuilder selections = new StringBuilder();
        List<String> selectionList = new ArrayList<>();
        ContentValues contentValues = mediaParam.getContentValues();
        Set<String> keySet = contentValues.keySet();
        String[] keys = new String[keySet.size()];
        keySet.toArray(keys);
        for (int i = 0; i < keys.length; i ++) {
            if (i == keys.length - 1) {
                selections.append(keys[i] + " =?");
            } else {
                selections.append(keys[i] + " =? and ");
            }
            selectionList.add(contentValues.getAsString(keys[i]));
        }
        String[] selectionArgs = null;
        if (selectionList.size() > 0) {
            selectionArgs = new String[selectionList.size()];
            selectionList.toArray(selectionArgs);
        }
        return query(selections.toString(), selectionArgs);
    }

    /**
     * query files
     * @param selections selections
     * @param selectionArgs selectionArgs
     * @return files
     */
    public Cursor query(String selections, String[] selectionArgs) {
        Log.d(TAG, "query: " + selections);
        return mContentResolver.query(mediaParam.getContentUri(), null, selections, selectionArgs, null);
    }

    /**
     * Delete the mediafile which related to mediaParam.
     * @return count
     */
    public int delete() {
        StringBuilder where = new StringBuilder();
        ContentValues contentValues = mediaParam.getContentValues();
        Set<String> keySet = contentValues.keySet();
        List<String> selectionArgList = new ArrayList<>();
        String[] keyArray = new String[keySet.size()];
        keySet.toArray(keyArray);
        for (int i = 0; i < keyArray.length; i ++) {
            if (i == keyArray.length - 1) {
                where.append(keyArray[i] + "=?");
            } else {
                where.append(keyArray[i] + "=? and ");
            }
            selectionArgList.add(contentValues.getAsString(keyArray[i]));
        }
        String[] selectionArgArray = null;
        if (selectionArgList.size() > 0) {
            selectionArgArray = new String[selectionArgList.size()];
            selectionArgList.toArray(selectionArgArray);
        }
        return mContentResolver.delete(mediaParam.getContentUri(), where.toString(), selectionArgArray);
    }

    /**
     * open the mediafile's FileDescriptor
     * @param mode mode
     * @return ParcelFileDescriptor
     * @throws FileNotFoundException
     */
    public ParcelFileDescriptor openFileDescriptor(String mode) throws FileNotFoundException {
        Uri uri = getUri();
        if (uri != null) {
            return mContentResolver.openFileDescriptor(uri, mode);
        }
        return null;
    }

    /**
     * open FileDescriptor by uri
     * @param uri uri
     * @param mode mode
     * @return ParcelFileDescriptor
     */
    public static ParcelFileDescriptor openFileDescriptor(Uri uri, String mode) {
        ParcelFileDescriptor parcelFileDescriptor = null;
        try {
            parcelFileDescriptor = mContentResolver.openFileDescriptor(uri, mode);
        } catch (FileNotFoundException e) {
            Log.d(TAG, "openFileDescriptor: " + e.getMessage());
            e.printStackTrace();
            mContentResolver.delete(uri, null, null);
        }
        return parcelFileDescriptor;
    }

    /**
     * open FileDescriptor by uri, default: writeable, readable.
     * <p>
     * If opening with the exclusive "r" or "w" modes, the returned
     * ParcelFileDescriptor could be a pipe or socket pair to enable streaming
     * of data. Opening with the "rw" mode implies a file on disk that supports
     * seeking. If possible, always use an exclusive mode to give the underlying
     * {@link ContentProvider} the most flexibility.
     * <p>
     * @param uri uri
     * @return ParcelFileDescriptor
     */
    public static ParcelFileDescriptor openFileDescriptor(Uri uri) {
        return openFileDescriptor(uri, "rw");
    }
}
