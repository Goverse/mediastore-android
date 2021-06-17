package com.goverse.mediastore.params;

import android.content.ContentValues;
import android.net.Uri;
import android.provider.MediaStore;

import com.goverse.mediastore.MediaParam;

public class AudioParam extends MediaParam {

    public AudioParam(AudioParamBuilder AudioParamBuilder) {
        super(AudioParamBuilder);
        contentValues = AudioParamBuilder.contentValues;
    }

    @Override
    public ContentValues getContentValues() {
        return contentValues;
    }

    @Override
    public Uri getContentUri() {
        return contentUri;
    }

    public static class AudioParamBuilder extends MediaParamBuilder<AudioParamBuilder, AudioParam>{

        private String titleKey;
        private String artist;
        private int bookmark;
        private int artistId;
        private String artistKey;
        private String composer;
        private String album;
        private int albumId;
        private String albumKey;
        private int track;
        private int year;
        private int isMusic;
        private int isPodcast;
        private int isRingtone;
        private int isAlarm;
        private int isNotification;
        private int isAudiobook;
        private ContentValues contentValues = new ContentValues();

        public AudioParamBuilder(Uri contentUri) {
            super(contentUri);
        }

        public AudioParamBuilder withTitleKey(String titleKey) {
            contentValues.put(MediaStore.Audio.AudioColumns.TITLE_KEY, titleKey);
            this.titleKey = titleKey;
            return this;
        }

        public AudioParamBuilder withBookmark(int bookmark) {
            contentValues.put(MediaStore.Audio.AudioColumns.BOOKMARK, bookmark);
            this.bookmark = bookmark;
            return this;
        }

        public AudioParamBuilder withArtistId(int artistId) {
            contentValues.put(MediaStore.Audio.AudioColumns.ARTIST_ID, artistId);
            this.artistId = artistId;
            return this;
        }

        public AudioParamBuilder withArtistKey(String artistKey) {
            contentValues.put(MediaStore.Audio.AudioColumns.ARTIST_KEY, artistKey);
            this.artistKey = artistKey;
            return this;
        }

        public AudioParamBuilder withArtist(String artist) {
            contentValues.put(MediaStore.Audio.AudioColumns.ARTIST, artist);
            this.artist = artist;
            return this;
        }

        public AudioParamBuilder withComposer(String composer) {
            contentValues.put(MediaStore.Audio.AudioColumns.COMPOSER, composer);
            this.composer = composer;
            return this;
        }
        public AudioParamBuilder withAlbumId(int albumId) {
            contentValues.put(MediaStore.Audio.AudioColumns.ALBUM_ID, albumId);
            this.albumId = albumId;
            return this;
        }

        public AudioParamBuilder withAlbum(String album) {
            contentValues.put(MediaStore.Audio.AudioColumns.ALBUM, album);
            this.album = album;
            return this;
        }

        public AudioParamBuilder withAlbumKey(String albumKey) {
            contentValues.put(MediaStore.Audio.AudioColumns.ALBUM_KEY, albumKey);
            this.albumKey = albumKey;
            return this;
        }

        public AudioParamBuilder withTrack(int track) {
            contentValues.put(MediaStore.Audio.AudioColumns.TRACK, track);
            this.track = track;
            return this;
        }

        public AudioParamBuilder withYear(int year) {
            contentValues.put(MediaStore.Audio.AudioColumns.YEAR, year);
            this.year = year;
            return this;
        }

        public AudioParamBuilder withIsMusic(int isMusic) {
            contentValues.put(MediaStore.Audio.AudioColumns.IS_MUSIC, isMusic);
            this.isMusic = isMusic;
            return this;
        }

        public AudioParamBuilder withIsPodcast(int isPodcast) {
            contentValues.put(MediaStore.Audio.AudioColumns.IS_PODCAST, isPodcast);
            this.isPodcast = isPodcast;
            return this;
        }

        public AudioParamBuilder withIsRingtone(int isRingtone) {
            contentValues.put(MediaStore.Audio.AudioColumns.IS_RINGTONE, isRingtone);
            this.isRingtone = isRingtone;
            return this;
        }

        public AudioParamBuilder withIsAlarm(int isAlarm) {
            contentValues.put(MediaStore.Audio.AudioColumns.IS_ALARM, isAlarm);
            this.isAlarm = isAlarm;
            return this;
        }

        public AudioParamBuilder withIsNotification(int isNotification) {
            contentValues.put(MediaStore.Audio.AudioColumns.IS_NOTIFICATION, isNotification);
            this.isNotification = isNotification;
            return this;
        }

        public AudioParamBuilder withIsAudiobook(int isAudiobook) {
            contentValues.put(MediaStore.Audio.AudioColumns.IS_AUDIOBOOK, isAudiobook);
            this.isAudiobook = isAudiobook;
            return this;
        }

        public AudioParam build() {
            return new AudioParam(this);
        }

    }
}
