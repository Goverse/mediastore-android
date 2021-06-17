# mediastore-android
封装android媒体文件访问接口MediaStore

使用方法如下：
```
// 1.构造对应的目录的Param
DownloadsParam downloadsParam = new DownloadsParam.DownloadsParamBuilder(EXTERNAL_CONTENT_URI)
               .withDateToken(System.currentTimeMillis())
               .withFileName(fileName)
               .withRelativePath(relativePath)
               .build();
   
// 2.构造MediaFile文件可以完成对媒体文件的增删改查操作。
MediaFile mediaFile = new MediaFile(context, MediaStore.Downloads.class, downloadsParam);
Uri uri = mediaFile.create();
int count = mediaFile.delete();
Cursor cursor = mediaFile.query();
```
