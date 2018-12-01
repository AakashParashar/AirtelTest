package main.factory;

import main.controller.FileOperationsController;
import main.service.IFileOperationsService;
import main.service.impl.FileOperationsServiceImpl;

public class FileOperationsServiceFactory {

  public IFileOperationsService getFileOperationsService() {
    IFileOperationsService fileOperationsService = new FileOperationsServiceImpl();
    return fileOperationsService;
  }

  public FileOperationsController getFileOperationsController() {
    FileOperationsController fileOperationsController = new FileOperationsController();
    return fileOperationsController;
  }
}

