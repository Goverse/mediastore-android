package com.goverse.mediastore.params;

import android.net.Uri;
import android.provider.MediaStore;

import com.goverse.mediastore.MediaParam;

public class DownloadsParam extends MediaParam {

    private String downloadUri;
    private String refererUri;

    public String getDownloadUri() {
        return downloadUri;
    }

    public String getRefererUri() {
        return refererUri;
    }

    private DownloadsParam(DownloadsParamBuilder downloadsParamBuilder) {
        super(downloadsParamBuilder);
        downloadUri = downloadsParamBuilder.downloadUri;
        refererUri = downloadsParamBuilder.refererUri;
    }

    public static class DownloadsParamBuilder extends MediaParamBuilder<DownloadsParamBuilder, DownloadsParam> {
        private String downloadUri;
        private String refererUri;

        public DownloadsParamBuilder(Uri contentUri) {
            super(contentUri);
        }

        public DownloadsParamBuilder withDownloadUri(String downloadUri) {
            contentValues.put(MediaStore.Downloads.DOWNLOAD_URI, downloadUri);
            this.downloadUri = downloadUri;
            return this;
        }

        public DownloadsParamBuilder withRefererUri(String refererUri) {
            contentValues.put(MediaStore.Downloads.REFERER_URI, refererUri);
            this.downloadUri = refererUri;
            return this;
        }

        @Override
        public DownloadsParam build() {
            return new DownloadsParam(this);
        }

    }
}
