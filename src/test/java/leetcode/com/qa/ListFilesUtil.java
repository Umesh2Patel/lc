package leetcode.com.qa;

import java.io.File;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListFilesUtil {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ListFilesUtil.class);

	/*public static void main(String[] args) {
		 ListFilesUtil listFilesUtil = new ListFilesUtil();
	        final String directoryLinuxMac ="/Users/loiane/test";
	        //Windows directory example
	        final String directoryWindows = "omnitureUtilities";
	        
//	        listFilesUtil.listFiles(directoryLinuxMac);
	        listFilesUtil.listFiles(directoryWindows);

	}*/
	
	 /**
     * List all the files and folders from a directory
     * @param directoryName to be listed
     */
    public void listFilesAndFolders(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
        	LOGGER.info(file.getName());
        }
    }
    /**
     * List all the files under a directory
     * @param directoryName to be listed
     */
    public void listFiles(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
                LOGGER.info(file.getName());
            }
        }
    }    
    /**
     * Returns all the files list  under a directory
     * @param directoryName to be listed
     * @return 
     */
    public static File[] getFilesList(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
            		LOGGER.info(file.getName());         
            }
        }
        return fList;
    }
    
    /**
     * Returns all the files list  under a directory
     * @param directoryName to be listed
     * @return 
     * @return 
     */
    public static void deletFiles(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
            		LOGGER.info(file.getName());
            		file.delete();
            }
        }
    }
    
    /**
     * List all the folder under a directory
     * @param directoryName to be listed
     */
    public void listFolders(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isDirectory()){
                LOGGER.info(file.getName());
            }
        }
    }
    /**
     * List all files from a directory and its subdirectories
     * @param directoryName to be listed
     */
    public void listFilesAndFilesSubDirectories(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
                LOGGER.info(file.getAbsolutePath());
            } else if (file.isDirectory()){
                listFilesAndFilesSubDirectories(file.getAbsolutePath());
            }
        }
    }

}
