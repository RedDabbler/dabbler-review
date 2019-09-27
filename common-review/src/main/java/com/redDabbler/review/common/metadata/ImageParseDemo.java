package com.redDabbler.review.common.metadata;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

/**
 * 参考文档
 * https://github.com/drewnoakes/metadata-extractor
 */
public class ImageParseDemo {

    public static void main(String[]args){
        parse("E:\\IMG_20180623_072110_HDR.jpg");
    }

    public static void parse(String imagePath){
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(new File(imagePath));
            Iterator<Directory> iterable = metadata.getDirectories().iterator();
            while(iterable.hasNext()){
                Directory directory = iterable.next();
                for (Tag tag : directory.getTags()) {
               //     Date date = directory.getDate(tag.getTagType());
                    System.out.println(tag);
                }
            }
        } catch (ImageProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
