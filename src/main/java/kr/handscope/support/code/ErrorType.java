package kr.handscope.support.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.logging.LogLevel;

import static kr.handscope.support.code.ErrorCode.CLIENT_ERROR;

@Getter
@AllArgsConstructor
public enum ErrorType {

    //Business Error
    MISSING_USER(CLIENT_ERROR, "사용자를 찾을 수 없습니다.", LogLevel.INFO);

    private final ErrorCode code;
    private final String message;
    private final LogLevel logLevel;
}
