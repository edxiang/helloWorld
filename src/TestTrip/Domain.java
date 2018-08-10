package TestTrip;

/**
 * Created by Kevin.Z on 2017/8/10.
 */
public class Domain {
    private String filePath;
    private long fileSize;
    private String fileText;
    private String file;
    private String fileName;
    private String uploadPath;
    private String FTPUrl;
    private String tagContent;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileText() {
        return fileText;
    }

    public void setFileText(String fileText) {
        this.fileText = fileText;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getFTPUrl() {
        return FTPUrl;
    }

    public void setFTPUrl(String FTPUrl) {
        this.FTPUrl = FTPUrl;
    }

    public String getTagContent() {
        return tagContent;
    }

    public void setTagContent(String tagContent) {
        this.tagContent = tagContent;
    }
}
