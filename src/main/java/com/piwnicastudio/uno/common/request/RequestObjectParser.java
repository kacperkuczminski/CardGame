package com.piwnicastudio.uno.common.request;

import jakarta.servlet.http.HttpServletRequest;

public class RequestObjectParser<T> implements Request<T> {
    private final String parameterName;
    private final Class<T> classType;

    public RequestObjectParser(String parameterName, Class<T> classType) {
        this.parameterName = parameterName;
        this.classType = classType;
    }

    @Override
    public T extract(HttpServletRequest request) {
        Object obj = request.getSession(false) != null ? request.getSession(false).getAttribute(parameterName) : null;
        if (classType.isInstance(obj)) {
            return classType.cast(obj);
        }
        return null;
    }
}
