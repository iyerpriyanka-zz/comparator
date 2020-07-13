package test;

import lib.FileComparator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestComparator {

    @Test
    public void testComparatorDifferentFileValues() throws IOException {
        FileComparator fc = new FileComparator();
        String user_dir = System.getProperty("user.dir");
        String file1 = user_dir + "/src/test/java/test/files/file1.txt";
        String file2 = user_dir + "/src/test/java/test/files/file2.txt";
        Boolean compareResult = fc.ApiFileComparator(file1,file2);
        Assert.assertEquals(compareResult,Boolean.FALSE,"Files not similar");
    }

    @Test
    public void testComparatorSimilarFileValues() throws IOException{
        FileComparator fc = new FileComparator();
        String user_dir = System.getProperty("user.dir");
        String file1 = user_dir + "/src/test/java/test/files/similarFile1.txt";
        String file2 = user_dir + "/src/test/java/test/files/similarFile2.txt";
        Boolean compareResult = fc.ApiFileComparator(file1,file2);
        Assert.assertEquals(compareResult,Boolean.TRUE,"Files are similar");
    }

    @Test
    public void testCompareEmptyFiles() throws IOException {
        FileComparator fc = new FileComparator();
        String user_dir = System.getProperty("user.dir");
        String file1 = user_dir + "/src/test/java/test/files/emptyFile2.txt";
        String file2 = user_dir + "/src/test/java/test/files/emptyFile2.txt";
        Boolean compareResult = fc.ApiFileComparator(file1,file2);
        Assert.assertEquals(compareResult,Boolean.TRUE,"Files are similar");
    }

    @Test
    public void testCompareSpecialCharacterFiles() throws IOException{
        FileComparator fc = new FileComparator();
        String user_dir = System.getProperty("user.dir");
        String file1 = user_dir + "/src/test/java/test/files/specialCharacterFile1.txt";
        String file2 = user_dir + "/src/test/java/test/files/specialCharacterFile2.txt";
        Boolean compareResult = fc.ApiFileComparator(file1,file2);
        Assert.assertEquals(compareResult,Boolean.FALSE,"Files are not similar");
    }
}
