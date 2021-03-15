package per.ehtane.platform.common.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 文件工具类
 *
 * @author sen li
 * @date 2021/3/15 14:54
 **/
public class FileUtils {

    /**
     * 将指定数据写入文本
     * @author sen li
     * @date 2021/3/15 15:05 
     * @param data: 需要写入的数据
     * @param filePath: 写入的文件地址
    **/
    public static void writeDataToFile(String data, String filePath){
        FileOutputStream fos;
        try{
            File file = new File(filePath);
            if(!file.getParentFile().exists()){
                File parentFilePath = new File(file.getParentFile().getAbsolutePath());
                parentFilePath.mkdir();
            }
            if(!file.exists()){
                file.createNewFile();
            }
            fos = new FileOutputStream(filePath, true);
            fos.write(data.getBytes(StandardCharsets.UTF_8));
            fos.close();
        } catch (FileNotFoundException e){
            throw new RuntimeException("指定文件不存在！" + e);
        } catch (IOException e){
            throw new RuntimeException("写入文件失败" + e);
        }
    }
}
