package main.commons;

public enum FileProcessorExceptionCodes {

  NO_COMMON_WORDS_EXCEPTION("ER-0001", "No common words exception"),
  FILE_READ_EXCEPTION("ER-002", "Application Error Occurred"),   // Change message to application error, enum will be explainatory
  FILE_NOT_FOUND_EXCEPTION("ER-003", "Application Error Occurred"); // Change message to application error

  private String errCode;
  private String errMsg;

  private FileProcessorExceptionCodes(String errCode, String errMsg) {
    this.errCode = errCode;
    this.errMsg = errMsg;
  }

  public String errCode() {
    return this.errCode;
  }

  public String errMsg() {
    return this.errMsg;
  }


  public static FileProcessorExceptionCodes forName(String errorCode) {
    FileProcessorExceptionCodes errCode = null;
    for (FileProcessorExceptionCodes code : values()) {
      if (code.name().equals(errorCode)) {
        return code;
      }
    }
    return errCode;
  }
}
