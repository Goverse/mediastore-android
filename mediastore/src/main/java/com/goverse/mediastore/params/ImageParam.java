package com.goverse.mediastore.params;

import android.net.Uri;
import android.provider.MediaStore;

import com.goverse.mediastore.MediaParam;

public class ImageParam extends MediaParam {

    private String description;
    private int isPrivate;

    private ImageParam(ImageParamBuilder imageParamBuilder) {
        super(imageParamBuilder);
        description = imageParamBuilder.description;
        isPrivate = imageParamBuilder.isPrivate;
    }

    public static class ImageParamBuilder extends MediaParamBuilder<ImageParamBuilder, ImageParam> {

        private String description;
        private int isPrivate;

        public ImageParamBuilder(Uri contentUri) {
            super(contentUri);
        }

        public ImageParamBuilder withDescription(String description) {
            contentValues.put(MediaStore.Images.ImageColumns.DESCRIPTION, description);
            this.description = description;
            return this;
        }

        public ImageParamBuilder withIsPrivate(int isPrivate) {
            contentValues.put(MediaStore.Images.ImageColumns.DESCRIPTION, isPrivate);
            this.isPrivate = isPrivate;
            return this;
        }

        @Override
        public ImageParam build() {
            return new ImageParam(this);
        }
    }
}
