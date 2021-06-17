package com.goverse.mediastore.params;

import android.net.Uri;
import android.provider.MediaStore;

import com.goverse.mediastore.MediaParam;

public class VideoParam extends MediaParam {

    private String artist;
    private String album;
    private String resolution;
    private String description;
    private int isPrivate;
    private String tags;
    private String category;
    private String language;
    private int bookmark;

    private VideoParam(MediaParamBuilder mediaParamBuilder) {
        super(mediaParamBuilder);
    }

    public int getBookmark() {
        return bookmark;
    }

    public int getIsPrivate() {
        return isPrivate;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    public String getResolution() {
        return resolution;
    }

    public String getTags() {
        return tags;
    }

    public static class VideoParamBuilder extends MediaParamBuilder<VideoParamBuilder, VideoParam> {

        private String artist;
        private String album;
        private String resolution;
        private String description;
        private int isPrivate;
        private String tags;
        private String category;
        private String language;
        private int bookmark;

        public VideoParamBuilder(Uri contentUri) {
            super(contentUri);
        }

        public VideoParamBuilder withArtist(String artist) {
            contentValues.put(MediaStore.Video.VideoColumns.ARTIST, artist);
            this.artist = artist;
            return this;
        }

        public VideoParamBuilder withAlbum(String album) {
            contentValues.put(MediaStore.Video.VideoColumns.ALBUM, album);
            this.album = album;
            return this;
        }

        public VideoParamBuilder withResolution(String resolution) {
            contentValues.put(MediaStore.Video.VideoColumns.RESOLUTION, resolution);
            this.resolution = resolution;
            return this;
        }

        public VideoParamBuilder withDescription(String description) {
            contentValues.put(MediaStore.Video.VideoColumns.DESCRIPTION, description);
            this.description = description;
            return this;
        }


        public VideoParamBuilder withAlbum(int isPrivate) {
            contentValues.put(MediaStore.Video.VideoColumns.IS_PRIVATE, isPrivate);
            this.isPrivate = isPrivate;
            return this;
        }

        public VideoParamBuilder withTags(String tags) {
            contentValues.put(MediaStore.Video.VideoColumns.TAGS, tags);
            this.tags = tags;
            return this;
        }

        public VideoParamBuilder withCategory(String category) {
            contentValues.put(MediaStore.Video.VideoColumns.CATEGORY, category);
            this.category = category;
            return this;
        }

        public VideoParamBuilder withLanguage(String language) {
            contentValues.put(MediaStore.Video.VideoColumns.LANGUAGE, language);
            this.language = language;
            return this;
        }

        public VideoParamBuilder withBookmark(int bookmark) {
            contentValues.put(MediaStore.Video.VideoColumns.BOOKMARK, bookmark);
            this.bookmark = bookmark;
            return this;
        }

        @Override
        public VideoParam build() {
            return new VideoParam(this);
        }
    }
}
