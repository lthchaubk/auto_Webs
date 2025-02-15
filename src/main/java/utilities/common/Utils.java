package utilities.common;

/**
 * Author: chaule
 * Created_at: 15Jun2023
 * Note:
 */
import java.io.File;

public class Utils {
    private static String reportDir;
    private static String logDir;

    /**
     * Create a directory at path name
     * @return : return path of directory
     */
    public static String getReportDir() {

        if (reportDir == null) {
            String pathName = "test-output/webChrome";

            File theDir = new File(pathName);

            if (!theDir.exists()) {
                System.out.println("CREATING A DIRECTORY");

                try {
                    theDir.mkdirs();
                    System.out.println("a directory is created: " + theDir.getPath());
                } catch (SecurityException se) {
                    System.out.println("CREATE A DIR IS FAILED!" + se.getMessage());
                    return null;
                }
            }
            reportDir = theDir.getPath();
        }
        return reportDir;
    }

    public static String getLogDir() {
        if (logDir == null) {
            String pathName = "test-output/log";

            File theDir = new File(pathName);

            if (!theDir.exists()) {
                System.out.println("CREATING A DIRECTORY");

                try {
                    theDir.mkdirs();
                    System.out.println("a directory is created: " + theDir.getPath());
                } catch (SecurityException se) {
                    System.out.println("CREATE A DIR IS FAILED!" + se.getMessage());
                    return null;
                }
            }
            logDir = theDir.getPath();
        }
        return logDir;
    }

    /**
     * create Dir
     */
    public static String createDir(String dirName) {

        File theDir = new File(dirName);

        if (!theDir.exists()) {
            System.out.println("CREATING A DIRECTORY");

            try {
                theDir.mkdirs();
                System.out.println("a directory is created: " + theDir.getPath());
            } catch (SecurityException se) {
                System.out.println("CREATE A DIR IS FAILED!" + se.getMessage());
                return null;
            }
        }
        return theDir.getPath();
    }

    public static String genCode() {
        long currentT = System.currentTimeMillis();
        return String.valueOf(currentT);
    }
}

