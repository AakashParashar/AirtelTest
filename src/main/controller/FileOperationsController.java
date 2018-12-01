package main.controller;

import main.factory.FileOperationsServiceFactory;
import java.io.File;
import main.service.IFileOperationsService;
import java.util.HashSet;
import java.util.Set;

public class FileOperationsController {

  FileOperationsServiceFactory factory = new FileOperationsServiceFactory();

  IFileOperationsService fileOperationsService = factory.getFileOperationsService();

  public Set<String> getAllCommonWordsFromFile(Set<String> filePaths) {

    Set<String> allCommonWords = null;

    for(String filePath : filePaths) {

      File file = fileOperationsService.getFileFromPath(filePath);
      Set<String> uniqueWordsFromFile = fileOperationsService.getUniqueWordsFromFile(file);

      if(null == allCommonWords) {                  // To identify/insert in the common set, when first file is processed
        allCommonWords = new HashSet<String>();     // Cannot check empty case as list might be empty if 2 lists have nothing common.
        allCommonWords.addAll(uniqueWordsFromFile);
      } else {
        allCommonWords.retainAll(uniqueWordsFromFile);

        if(allCommonWords.isEmpty()) {
          return allCommonWords;
        }
      }

    }
    return allCommonWords;
  }

}


