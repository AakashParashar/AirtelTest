package main;

import main.controller.FileOperationsController;
import main.factory.FileOperationsServiceFactory;
import java.util.HashSet;
import java.util.Set;

public class AirtelTestApplication {

  static FileOperationsServiceFactory factory = new FileOperationsServiceFactory();

  public static void main(String[] args) {

    Set<String> filePaths = new HashSet<String>();
    filePaths.add("//home//aakashparashar//aakash//airtel//file1");
    filePaths.add("//home//aakashparashar//aakash//airtel//file2");
    filePaths.add("//home//aakashparashar//aakash//airtel//file3");

    FileOperationsController fileOperationsController = factory.getFileOperationsController();

    Set<String> allCommonWords = fileOperationsController
        .getAllCommonWordsFromFile(filePaths);

    for (String word : allCommonWords) {
      System.out.println(word);
    }

  }
}
