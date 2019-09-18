package com.redDabbler.review.common.jdk.io;


import com.redDabbler.template.tools.utils.FileHelper;

import java.io.*;

public class ParseFileImportHandler {


    /**
     * 读取java类里的所有import包文件
     * @param file
     * @throws FileNotFoundException
     */
    public void parse(File file)throws FileNotFoundException {
        InputStream inputStream = FileHelper.getInputStream(file.getAbsolutePath());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line = null;
        try {
            // readline 是阻塞方法
            while((line=bufferedReader.readLine())!=null){
                if(line.trim().startsWith("package")){
                    continue;
                }
                if (line.trim().startsWith("public class")){
                    break;
                }
                System.out.println(line);
            }
        }catch (IOException e){


        }finally {
            if (bufferedReader!=null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    bufferedReader = null;
                }
            }
        }

    }

}
