package org.meframework.core;

/**
 * Created by ht on 2016/5/11.
 */
public abstract class NestedRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 5439915454935047936L;

    static {
        NestedExceptionUtils.class.getName();
    }

    public NestedRuntimeException(String message) {
        super(message);
    }

    public NestedRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        return NestedExceptionUtils.buildMessage(super.getMessage(), getCause());
    }

    public Throwable getRootCause() {
        Throwable rootCause = null;
        Throwable cause = getCause();
        while (cause != null && cause != rootCause) {
            rootCause = cause;
            cause = cause.getCause();
        }
        return rootCause;
    }

    /**
     * 检查这个异常是否包含了给定的异常类型
     * @param exType 类类型
     * @return 是否是特定类型异常的嵌套异常
     */
    public boolean contains(Class<?> exType) {
        if (exType == null) {
            return false;
        }
        // 如果包含exType的实例返回true
        if (exType.isInstance(this)) {
            return true;
        }
        // 返回此异常的错误
        Throwable cause = getCause();
        if (cause == this) {
            return false;
        }
        if (cause instanceof NestedRuntimeException) {
            return ((NestedRuntimeException) cause).contains(exType);
        }
        else {
            while (cause != null) {
                if (exType.isInstance(cause)) {
                    return true;
                }
                if (cause.getCause() == cause) {
                    break;
                }
                cause = cause.getCause();
            }
            return false;
        }
    }
}
