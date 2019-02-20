package com.example.visen.studyapp.network;

import java.io.File;

public class NetworkFileData {

    /** 文件服务器Path*/
    private String filePath;

    /** 文件名称*/
    private String fileName;

    /** 文件类型*/
    private String mediaType;

    /** 文件内容*/
    private File file;


    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "NetworkFileData{" +
                "filePath='" + filePath + '\'' +
                ", fileName='" + fileName + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", file=" + file +
                '}';
    }
}
