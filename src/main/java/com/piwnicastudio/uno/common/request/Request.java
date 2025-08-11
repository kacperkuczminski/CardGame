package com.piwnicastudio.uno.common.request;

import jakarta.servlet.http.HttpServletRequest;

public interface Request <T> {
    T extract(HttpServletRequest request);
}
