package com.goverse.mediastore.params;

import android.net.Uri;
import android.provider.MediaStore;

import com.goverse.mediastore.MediaParam;

import static android.provider.MediaStore.VOLUME_EXTERNAL;

public class FileParam extends MediaParam {

    private int parent;
    private int mediaType;
    private String title;

    private FileParam(FileParamBuilder fileParamBuilder) {
        super(fileParamBuilder);
        parent = fileParamBuilder.parent;
        mediaType = fileParamBuilder.parent;
        title = fileParamBuilder.title;
    }

    public static class FileParamBuilder extends MediaParamBuilder<FileParamBuilder, FileParam> {

        private int parent;
        private int mediaType;
        private String title;

        public FileParamBuilder() {
            super(MediaStore.Files.getContentUri(VOLUME_EXTERNAL));
        }

        private FileParamBuilder(Uri contentUri) {
            super(contentUri);
        }

        public FileParamBuilder withParent(int parent) {
            contentValues.put(MediaStore.Files.FileColumns.PARENT, parent);
            this.parent = parent;
            return this;
        }

        public FileParamBuilder withMediaType(int mediaType) {
            contentValues.put(MediaStore.Files.FileColumns.MEDIA_TYPE, mediaType);
            this.mediaType = mediaType;
            return this;
        }

        public FileParamBuilder withTitle(String title) {
            contentValues.put(MediaStore.Files.FileColumns.TITLE, title);
            this.title = title;
            return this;
        }

        @Override
        public FileParam build() {
            return new FileParam(this);
        }
    }
}
