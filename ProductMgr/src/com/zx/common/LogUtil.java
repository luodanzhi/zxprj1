package com.zx.common;

import java.io.IOException;

import android.os.Environment;
import android.text.format.DateFormat;
import android.util.Log;

public class LogUtil {
    private static final String TAG = "ProductMgr";
    private static final boolean DEBUG = true;
    private static final boolean DETAIL_ENABLE = true;
 
    // The order in terms of verbosity, from least to most is ERROR, WARN, INFO, DEBUG, VERBOSE.
    // ERROR, WARN, INFO are always kepted, DEBUG, VERBOSE are controlled bug DEBUG.
   
    /**
     * Output log to file LOG_FILE_NAME
     */
    public final static void logcatToFile(String logFileName) {
        String result = "Fail";
        try {
            if (logFileName != null) {
                // check media state
                String curTime = DateFormat.format("yyyy-MM-dd-hh:mm", System.currentTimeMillis()).toString();
                logD("===============================START LOG FILE at " + curTime + "===============================");
                // String[] cmdAttribs = new String[] {"logcat", "-r 64", "-f",  LOG_FILE_NAME, "&"};
                String cmdAttribs = "logcat -d -f " +  logFileName + " -s ProductMgr:* *:E -r 64";
                Process p = Runtime.getRuntime().exec(cmdAttribs);
                result = "Pass";
            }
        } catch (IOException e) {
            result = "Fail: IOException with " + e.getMessage();
        } catch (SecurityException e) {
            result = "Fail: SecurityException with " + e.getMessage();
        } catch (Exception e) {
            result = "Fail: Exception with " + e.getMessage();
        }

        logE("Result:" + result);
    }
 
    public final static void logException(Exception e) {
        if(e.getMessage() != null) {
            logE(e.getMessage());
        }
        e.printStackTrace();
    }

    public final static void logException(String msg) {
        logD(msg);
    }

    public static void logV(String msg) {
        if (DEBUG && msg != null) {
            Log.v(TAG, buildMsg(msg));
        }
    }
    
    public static void logD(String msg) {
        if (DEBUG && msg != null) {
            Log.i(TAG, buildMsg(msg));
        }
    }
    
    public static void logI(String msg) {
        if (msg != null) {
            Log.i(TAG, buildMsg(msg));
        }
    }
    
    public static void logW(String msg) {
        if (msg != null) {
            Log.w(TAG, buildMsg(msg));
        }
    }
    
    public static void logE(String msg) {
        if (msg != null) {
            Log.e(TAG, buildMsg(msg));
        }
    }
    
    private static String buildMsg(String msg) {
        StringBuilder buffer = new StringBuilder();

        if (DETAIL_ENABLE) {
            final StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
            StackTraceElement stackTraceElement = null;
            for (int index = 4; index < stackTraceElements.length; index++) {
                stackTraceElement = stackTraceElements[index];
                if (!stackTraceElement.getMethodName().startsWith("log")) {
                    break;
                }
            }

            if (stackTraceElement!=null) {
                buffer.append("[ ");
                buffer.append(Thread.currentThread().getName());
                buffer.append(": ");
                buffer.append(stackTraceElement.getFileName());
                buffer.append(": ");
                buffer.append(stackTraceElement.getLineNumber());
                buffer.append(": ");
                buffer.append(stackTraceElement.getMethodName());

                buffer.append("() ] ");
            }
        }

        buffer.append(msg);

        return buffer.toString();
    }
}
