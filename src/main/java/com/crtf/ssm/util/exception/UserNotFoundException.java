package com.crtf.ssm.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author crtf
 * @version V1.0
 * @className UserNotFoundException
 * @description 用户没找到异常
 * @date 21.6.13 14:45
 */
@ResponseStatus(reason = "用户没找到异常",value = HttpStatus.NOT_ACCEPTABLE)
public class UserNotFoundException extends RuntimeException{

    static final long serialVersionUID = -3387516997887987987L;
}

