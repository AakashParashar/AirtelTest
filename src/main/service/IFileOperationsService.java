package main.service;

import java.io.File;
import java.util.Set;

public interface IFileOperationsService {

  public File getFileFromPath(String path) ;

  public Set<String> getUniqueWordsFromFile(File file);

}
