package com.File;

/**
 * Project Name:Data-Structure
 * Package Name:com.File
 * File Name: FileInfo.java
 * Date:2019/11/10 下午12:53
 * Copyright © 2019 silence. All Rights Reserved.
 */

public class FileInfo {
    private int lines;
    private int files;
    private String content = "";

    public String[] words() {
        return content.split("[^a-zA-Z]+");
    }

    public int getFiles() {
        return files;
    }

    public void setFiles(int files) {
        this.files = files;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public FileInfo append(FileInfo info) {
        if (info != null && info.lines > 0) {
            this.files += info.files;
            this.lines += info.lines;
            this.content = new StringBuilder(this.content)
                    .append("\n")
                    .append(info.content)
                    .toString();
        }
        return this;
    }
}
