package utilities.common;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Author: chaule
 * Created_at: 15Jun2023
 * Note:
 */
public class Reports {
    /**
     * add Log with extent report status
     */
    public static void reportWithStatus(ExtentTest extentTest, boolean isPass, String message) {
        if (isPass) {
            extentTest.log(LogStatus.PASS, message);
        } else {
            extentTest.log(LogStatus.FAIL, message);
        }
        Log.addLog(message);
    }

    /**
     * add Log compare 2 strings with extent report status
     */
    public static void reportWithCompareString(ExtentTest extentTest, String expect, String actual, String message) {
        if (expect.equals(actual)) {
            extentTest.log(LogStatus.PASS, message + " => correctly");
        } else {
            extentTest.log(LogStatus.FAIL, message + " => failure");
        }
        Log.addLog(message);
        Log.addLog("Expected result: " + expect);
        Log.addLog("Actual result: " + actual);
    }

    /**
     * add Log compare 2 strings with extent report status
     * Notes: include img
     */
    public static void reportWithCompareString(ExtentTest extentTest, String expect, String actual, String message, String imgName) {
        String url, logFileName;
        imgName = imgName + "-" + Generator.currentDate;
        logFileName = "FinanBook_" + imgName + ".png";
        url = System.getProperty("user.dir") + "/test-output/img/" + logFileName;

        if (Configs.isUploadToCloud) {
            // upload to S3 - img
            boolean isUploaded = false;
            int retry = 10;
            while (!isUploaded) {
                try {
                    Thread.sleep(Configs.ServerDeepSleep);
                } catch (Exception e){
                    Log.addLog("Error when system waiting file to upload");
                }

                isUploaded = FileUploadS3.uploadImgToS3(logFileName, url);

                if (retry <= 1) break;
                retry--;
            }

            if (isUploaded) {
                try {
                    url = FileUploadS3.getImgFromS3(logFileName);
                } catch (Exception e) {
                    Log.addLog("Can't get logUrl from S3");
                }
            }
        }

        String img = "";
        if (MobileWeb.isMobileWeb) {
            img = "<br> <img src=\"" + url + "\" align=\"left\" width=\"350\">";
        } else {
            img = "<br> <img src=\"" + url + "\" align=\"left\" width=\"650\">";
        }

        if (expect.equals(actual)) {
            extentTest.log(LogStatus.PASS, message + " => correctly" + img);
        } else {
            extentTest.log(LogStatus.FAIL, message + " => failure" + img);
        }

        Log.addLog(message);
        Log.addLog("Expected result: " + expect);
        Log.addLog("Actual result: " + actual);
    }

    /**
     * add Log compare int with extent report status
     */
    public static void reportWithCompareInt(ExtentTest extentTest, int expect, int actual, String message) {
        Log.addLog("Expected result: " + expect);
        Log.addLog("Actual result: " + actual);

        if (expect == actual) {
            extentTest.log(LogStatus.PASS, message + " => correctly");
        } else {
            extentTest.log(LogStatus.FAIL, message + " => failure");
        }
        Log.addLog(message);
    }

    /**
     * New Report method with Image
     * Author: Chau Le
     * Created at: 29Sep21
     */
    public static void reportWithCompareInt(ExtentTest extentTest, int expect, int actual, String message, String imgName) {
        String url, logFileName;
        imgName = imgName + "-" + Generator.currentDate;
        logFileName = "FinanBook_" + imgName + ".png";
        url = System.getProperty("user.dir") + "/test-output/img/" + logFileName;

        if (Configs.isUploadToCloud) {
            // upload to S3 - img
            boolean isUploaded = false;
            int retry = 10;
            while (!isUploaded) {
                try {
                    Thread.sleep(Configs.ServerDeepSleep);
                } catch (Exception e){
                    Log.addLog("Error when system waiting file to upload");
                }

                isUploaded = FileUploadS3.uploadImgToS3(logFileName, url);

                if (retry <= 1) break;
                retry--;
            }

            if (isUploaded) {
                try {
                    url = FileUploadS3.getImgFromS3(logFileName);
                } catch (Exception e) {
                    Log.addLog("Can't get logUrl from S3");
                }
            }
        }

        String img = "";
        if (MobileWeb.isMobileWeb) {
            img = "<br> <img src=\"" + url + "\" align=\"left\" width=\"350\">";
        } else {
            img = "<br> <img src=\"" + url + "\" align=\"left\" width=\"650\">";
        }

        if (expect == actual) {
            extentTest.log(LogStatus.PASS, message + " => correctly" + img);
        } else {
            extentTest.log(LogStatus.FAIL, message + " => failure" + img);
        }
        Log.addLog(message);
    }

    /**
     * add Log with check display and show on extent report
     */
    public static void reportWithIsDisplay(ExtentTest extentTest, boolean isOpen, String message) {
        if (isOpen) {
            extentTest.log(LogStatus.PASS, message);
        } else {
            extentTest.log(LogStatus.FAIL, message);
        }
        Log.addLog(message);
    }

    /**
     * New Report method with Image
     */
    public static void reportWithIsDisplay(ExtentTest extentTest, boolean isDisplay, String message, String imgName) {
        String url, logFileName;
        imgName = imgName + "-" + Generator.currentDate;
        logFileName = "FinanBook_" + imgName + ".png";
        url = System.getProperty("user.dir") + "/test-output/img/" + logFileName;

        if (Configs.isUploadToCloud) {
            // upload to S3 - img
            boolean isUploaded = false;
            int retry = 10;
            while (!isUploaded) {
                try {
                    Thread.sleep(Configs.ServerDeepSleep);
                } catch (Exception e){
                    Log.addLog("Error when system waiting file to upload");
                }

                isUploaded = FileUploadS3.uploadImgToS3(logFileName, url);

                if (retry <= 1) break;
                retry--;
            }

            if (isUploaded) {
                try {
                    url = FileUploadS3.getImgFromS3(logFileName);
                } catch (Exception e) {
                    Log.addLog("Can't get logUrl from S3");
                }
            }
        }

        String img = "";
        if (MobileWeb.isMobileWeb) {
            img = "<br> <img src=\"" + url + "\" align=\"left\" width=\"350\">";
        } else {
            img = "<br> <img src=\"" + url + "\" align=\"left\" width=\"650\">";
        }

        if (isDisplay) {
            extentTest.log(LogStatus.PASS, message + img);
        } else {
            extentTest.log(LogStatus.FAIL, message + img);
        }
        Log.addLog(message);
    }

//    /**
//     * New Report method with video
//     * Author: Chau Le
//     * Created at: 10Dec2021
//     * Note: hạn chế sử dụng vì việc quay video tốn nhiều dung lượng
//     */
//    public static void reportWithVideo(ExtentTest extentTest, boolean isCorrect, String message, String videoName){
//        String url = System.getProperty("user.dir") + "/test-output/videos/" + videoName + ".mov";
//        String video = "<br> <video width=\"350\" src=\"" + url + "\"></video>";
//
//        if(isCorrect) {
//            extentTest.log(LogStatus.PASS, message + video);
//        }
//        else {
//            extentTest.log(LogStatus.FAIL, message + video);
//        }
//        Log.addLog(message);
//    }
}
