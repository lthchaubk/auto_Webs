package utilities.common;

/**
 * Author: chaule
 * Created_at: 15Jun2023
 * Note:
 */
public enum Environments {
    /**
     * Notes:
     */
    FINAN_DEV("Dev", "", "", "", "/test-output/reports/finan/dev/", "","","",""),
    ;

    private String name;
    private String domain;
    private String apiUrl;
    private String apiPath;
    private String reportPath;
    private String description;
    private String s3PathReport;
    private String s3PathLog;
    private String s3PathImg;

    /**
     * constructor
     */
    private Environments(String name, String domain, String apiUrl, String apiPath, String reportPath, String description, String s3PathReport, String s3PathLog, String s3PathImg) {
        this.name = name;
        this.domain = domain;
        this.apiUrl = apiUrl;
        this.apiPath = apiPath;
        this.reportPath = reportPath;
        this.description = description;
        this.s3PathReport = s3PathReport;
        this.s3PathLog = s3PathLog;
        this.s3PathImg = s3PathImg;
    }

    public String getName() {
        return this.name;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getApiUrl() {
        return this.apiUrl;
    }

    public String getApiPath() {
        return this.apiPath;
    }

    public String getReportPath() {
        return this.reportPath;
    }

    public String getDescription() {
        return this.description;
    }

    public String getS3PathReport() {
        return this.s3PathReport;
    }

    public String getS3PathLog() {
        return this.s3PathLog;
    }

    public String getS3PathImg(){
        return this.s3PathImg;
    }
}
