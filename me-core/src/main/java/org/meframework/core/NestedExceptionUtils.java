package org.meframework.core;

/**
 * Created by ht on 2016/5/11.
 */
public abstract class NestedExceptionUtils {

    /**
     * 组装给定信息和根错误信息。
     * @param message
     * @param cause
     * @return
     */
    public static String buildMessage(String message, Throwable cause) {
        if (cause != null) {
            StringBuilder sb = new StringBuilder();
            if (message != null) {
                sb.append(message).append("; ");
            }
            sb.append("nested exception is ").append(cause);
            return sb.toString();
        }
        else {
            return message;
        }
    }
}
