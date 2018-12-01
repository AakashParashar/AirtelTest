package main.service.impl;

import main.commons.FileProcessorExceptionCodes;
import main.exceptions.FileProcessorException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import main.service.IFileOperationsService;
import java.util.HashSet;
import java.util.Set;

public class FileOperationsServiceImpl implements IFileOperationsService {


  @Override
  public File getFileFromPath(String path) {
    File file = new File(path);
    return file;
  }

  @Override
  public Set<String> getUniqueWordsFromFile(File file) {

    Set<String> uniqueWords = new HashSet<String>();
    BufferedReader br = null;
    try {
      br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

      String line = null;
      while ((line = br.readLine()) != null) {
        // \\s+ means any number of whitespaces between words
        String[] words = line.split("\\s+");
        for(String word : words) {
          // This will replace all except alphanumeric
          word = word.replaceAll("[^A-Za-z0-9]","");
          uniqueWords.add(word.toLowerCase());
        }
      }
    } catch(FileNotFoundException e){
        throw new FileProcessorException(FileProcessorExceptionCodes.FILE_NOT_FOUND_EXCEPTION.errCode(), FileProcessorExceptionCodes.FILE_NOT_FOUND_EXCEPTION.errMsg());
    } catch (IOException e) {
      // TODO: Add custom exception, create an exception mapper.
      throw new FileProcessorException(FileProcessorExceptionCodes.FILE_READ_EXCEPTION.errCode(), FileProcessorExceptionCodes.FILE_READ_EXCEPTION.errMsg());
    }
    return uniqueWords;
  }
}
