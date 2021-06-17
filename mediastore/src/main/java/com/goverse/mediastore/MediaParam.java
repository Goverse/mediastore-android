package com.goverse.mediastore;

import android.content.ContentValues;
import android.net.Uri;
import android.provider.MediaStore;

public class MediaParam {

    /**
     * File storage type, may be one of follows:
     * {@link MediaStore.Downloads#INTERNAL_CONTENT_URI}
     * {@link MediaStore.Downloads#EXTERNAL_CONTENT_URI}
     * {@link MediaStore.Audio.Media#INTERNAL_CONTENT_URI}
     * {@link MediaStore.Audio.Media#EXTERNAL_CONTENT_URI}
     * {@link MediaStore.Video.Media#INTERNAL_CONTENT_URI}
     * {@link MediaStore.Video.Media#EXTERNAL_CONTENT_URI}
     * {@link MediaStore.Images.Media#INTERNAL_CONTENT_URI}
     * {@link MediaStore.Images.Media#EXTERNAL_CONTENT_URI}
     * {@link MediaStore.Files#getContentUri(String)} for all type of media files.
     * you can get ContentUri by {@link MediaStore.Downloads#getContentUri(String)}
     */
    protected Uri contentUri;
    protected ContentValues contentValues;
    protected int id;
    protected int size;
    protected String displayName;
    protected String title;
    protected int dateAdded;
    protected int dateModified;
    protected int dateToken;
    protected String mimeType;
    protected int isPending;
    protected String ownerPackageName;
    protected String volumeName;
    protected String relativePath;
    protected String documentId;
    protected String instanceId;
    protected int duration;

    protected MediaParam(MediaParamBuilder mediaParamBuilder) {
        displayName = mediaParamBuilder.displayName;
        relativePath = mediaParamBuilder.relativePath;
        mimeType = mediaParamBuilder.mimeType;
        dateToken = mediaParamBuilder.dateToken;
        duration = mediaParamBuilder.duration;
        contentUri = mediaParamBuilder.contentUri;
        instanceId = mediaParamBuilder.instanceId;
        documentId = mediaParamBuilder.documentId;
        volumeName = mediaParamBuilder.volumeName;
        ownerPackageName = mediaParamBuilder.ownerPackageName;
        isPending = mediaParamBuilder.isPending;
        dateModified = mediaParamBuilder.dateModified;
        dateAdded = mediaParamBuilder.dateAdded;
        title = mediaParamBuilder.title;
        size = mediaParamBuilder.size;
        id = mediaParamBuilder.id;
        contentValues = mediaParamBuilder.contentValues;
    }

    public ContentValues getContentValues() {
        return contentValues;
    }

    public Uri getContentUri() {
        return contentUri;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public String getMimeType() {
        return mimeType;
    }

    public int getDateAdded() {
        return dateAdded;
    }

    public int getDateModified() {
        return dateModified;
    }

    public int getDateToken() {
        return dateToken;
    }

    public int getId() {
        return id;
    }

    public int getIsPending() {
        return isPending;
    }

    public int getSize() {
        return size;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getOwnerPackageName() {
        return ownerPackageName;
    }

    public String getDocumentId() {
        return documentId;
    }

    public String getTitle() {
        return title;
    }

    public String getVolumeName() {
        return volumeName;
    }

    public int getDuration() {
        return duration;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public MediaParam getMediaParam() {
        return this;
    }
    
    public static abstract class MediaParamBuilder<T extends MediaParamBuilder<T, K>, K extends MediaParam> {
        
        private Uri contentUri;
        private int id;
        private int size;
        private String displayName;
        private String title;
        private int dateAdded;
        private int dateModified;
        private int dateToken;
        private String mimeType;
        private int isPending;
        private String ownerPackageName;
        private String volumeName;
        private String relativePath;
        private String documentId;
        private String instanceId;
        private int duration;
        protected ContentValues contentValues = new ContentValues();

        public MediaParamBuilder(Uri contentUri) {
            this.contentUri = contentUri;
        }

        public T withInstanceId(String instanceId) {
            contentValues.put(MediaStore.MediaColumns.INSTANCE_ID, instanceId);
            this.instanceId = instanceId;
            return (T)this;
        }

        public T withDocumentId(String documentId) {
            contentValues.put(MediaStore.MediaColumns.DOCUMENT_ID, documentId);
            this.documentId = documentId;
            return (T)this;
        }

        public T withVolumeName(String volumeName) {
            contentValues.put(MediaStore.MediaColumns.VOLUME_NAME, volumeName);
            this.volumeName = volumeName;
            return (T)this;
        }

        public T withOwnerPackageName(String ownerPackageName) {
            contentValues.put(MediaStore.MediaColumns.OWNER_PACKAGE_NAME, ownerPackageName);
            this.ownerPackageName = ownerPackageName;
            return (T)this;
        }

        public T withIsPending(int isPending) {
            contentValues.put(MediaStore.MediaColumns.IS_PENDING, isPending);
            this.isPending = isPending;
            return (T)this;
        }

        public T withDateModified(int dateModified) {
            contentValues.put(MediaStore.MediaColumns.DATE_MODIFIED, dateModified);
            this.dateModified = dateModified;
            return (T)this;
        }

        public T withDateAdded(int dateAdded) {
            contentValues.put(MediaStore.MediaColumns.DATE_ADDED, dateAdded);
            this.dateAdded = dateAdded;
            return (T)this;
        }

        public T withTitle(String title) {
            contentValues.put(MediaStore.MediaColumns.TITLE, title);
            this.title = title;
            return (T)this;
        }

        public T withSize(int size) {
            contentValues.put(MediaStore.MediaColumns.SIZE, size);
            this.size = size;
            return (T)this;
        }

        public T withId(int id) {
            contentValues.put(MediaStore.MediaColumns._ID, id);
            this.id = id;
            return (T)this;
        }

        public T withDisplayName(String displayName) {
            contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, displayName);
            this.displayName = displayName;
            return (T)this;
        }

        public T withRelativePath(String relativePath) {
            contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, relativePath);
            this.relativePath = relativePath;
            return (T)this;
        }

        public T withDateToken(int dateToken) {
            contentValues.put(MediaStore.MediaColumns.DATE_TAKEN, dateToken);
            this.dateToken = dateToken;
            return (T)this;
        }

        public T withDuration(int duration) {
            contentValues.put(MediaStore.MediaColumns.DURATION, duration);
            this.duration = duration;
            return (T)this;
        }

        public T withMimeType(String mimeType) {
            contentValues.put(MediaStore.MediaColumns.MIME_TYPE, mimeType);
            this.mimeType = mimeType;
            return (T)this;
        }

        public abstract K build();

    }
}
