package main.exceptions;

public class FileProcessorException extends RuntimeException {

  String errCode;
  String errMessage;

  public FileProcessorException(String s) {
    // Call constructor of parent Exception
    super(s);
  }

  public FileProcessorException(String errCode, String errMessage) {
    // Call constructor of parent Exception
    super(errMessage);
    this.errCode = errCode;
    this.errMessage = errMessage;
  }


  public String getErrCode() {
    return errCode;
  }

  public void setErrCode(String errCode) {
    this.errCode = errCode;
  }

  public String getErrMessage() {
    return errMessage;
  }

  public void setErrMessage(String errMessage) {
    this.errMessage = errMessage;
  }
}
