package com.redDabbler.review.common.img.qrcode;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.ImageReader;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.datamatrix.DataMatrixReader;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.redDabbler.template.tools.utils.FileHelper;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * 参考文档
 * https://zxing.github.io/zxing/apidocs/
 * https://github.com/zxing/zxing
 */
public class ZXingDemo {

    public static void write(String path)throws IOException, WriterException {
        String content = "123,hello,world";
        File file = new File(path);
        FileHelper.createFileIfNotExists(path);
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        //Binary
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix =  qrCodeWriter.encode(content,BarcodeFormat.QR_CODE,330,330);

        MatrixToImageWriter.writeToStream(bitMatrix,"png",fileOutputStream);
    }

    public static void read(String path)throws IOException,Exception{

        File file = new File(path);
        BufferedImage bufferedImage = ImageReader.readImage(file.toURI());
        LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
        Binarizer binarizer = new HybridBinarizer(luminanceSource);
        MultiFormatReader reader = new MultiFormatReader();
        Result result = reader.decode(new BinaryBitmap(binarizer));
        String text = result.getText();
        System.out.println(text);

    }

    public static void createLogoQrImg(String content,String logoPath,String path) throws Exception{

        //Binary
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix =  qrCodeWriter.encode(content,BarcodeFormat.QR_CODE,330,330);

        // 定义二维码图片，并将位图矩阵点渲染到二维码图片上
        BufferedImage image = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < 300; x++) {
            for (int y = 0; y < 300; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }

        File file = new File(logoPath);
        BufferedImage logo = ImageIO.read(file);
//        int logoWidth = logo.getWidth();
//        int heightWidth = logo.getHeight();
        Graphics2D graphics = image.createGraphics();

        int widthLogo = logo.getWidth(null) > image.getWidth() * 2 / 10 ?
                (image.getWidth() * 2 / 10) : logo.getWidth(null);
        int heightLogo = logo.getHeight(null) > image.getHeight() * 2 / 10 ?
                (image.getHeight() * 2 / 10) : logo.getHeight(null);

        int x = (image.getWidth() - widthLogo) / 2;
        int y = (image.getHeight() - heightLogo) / 2;

        //绘制圆角矩形
        graphics.drawRoundRect(x, y, widthLogo, heightLogo, 15, 15);

        //logo边框颜色
        graphics.setBackground(Color.WHITE);
        //边框宽度
        graphics.setStroke(new BasicStroke(2));

        //边框颜色
        graphics.drawRect(x, y, widthLogo, heightLogo);
        graphics.drawImage(logo,x,y,widthLogo, heightLogo, null);
        graphics.dispose();
        logo.flush();
        image.flush();
        ImageIO.write(image,"jpg",new File(path));

    }


    public static void main(String[]args)throws Exception{

        createLogoQrImg("java是世界上最好的语言","E://下载.jpg","E://demo/logo_qrcode.jpg");

        generateQRcodeLogoRemark("hello,world","D://20191022112146.jpg");
    }



    /**
     * 生成二维码
     * 二维码红带有logo图样
     * 二维码下方带有备注信息
     * 二维码的宽高受备注信息字体大小影响，这里没有抽取公共参数
     * @throws WriterException
     * @throws IOException
     */
    public static void generateQRcodeLogoRemark(String content,String logoImgPath) throws WriterException, IOException {

        // 设置二维码纠错信息
        HashMap<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

        // 因为有备注信息
        // 这里不要设置二维码边距，否则二维码和备注信息之间会有明显间隔
        hints.put(EncodeHintType.MARGIN, 0);

        // 定义二维码位图矩阵
        BitMatrix bt = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 300, 300, hints);

        // 定义二维码图片，并将位图矩阵点渲染到二维码图片上
        BufferedImage btImage = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < 300; x++) {
            for (int y = 0; y < 300; y++) {
                btImage.setRGB(x, y, bt.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }

        // 读取logo图片，并判断logo图片的宽高必须相等
        Image logoImg = ImageIO.read(new File(logoImgPath));
        int logoWidth = logoImg.getWidth(null);
        int logoHeight = logoImg.getHeight(null);
        if (logoWidth != logoHeight) {
            logoWidth = logoHeight;
        }

        // 对logo图片实施压缩
        // 若logo图片宽高大于二维码宽高，必须对logo图片进行压缩
        // 否则，过大的照片会撑爆二维码，生成的二维码只能看到部分的logo图片信息
//        if (logoWidth > 50 && logoHeight > 50) {
//            logoWidth = 50;
//            logoHeight = 50;
//        }

        // 创建缩微版本的logo图片
        Image image = logoImg.getScaledInstance(logoWidth, logoHeight,
                Image.SCALE_SMOOTH);
        BufferedImage tag = new BufferedImage(logoWidth, logoHeight,
                BufferedImage.TYPE_INT_RGB);

        // 绘制缩微版logo图片，并将新的logo图片赋给原logo图片变量
        Graphics logoGraphics = tag.getGraphics();
        logoGraphics.drawImage(image, 0, 0, null);
        logoGraphics.dispose();
        logoImg = image;

        // 在原二维码中计算位置，插入新的logo图片
        Graphics2D graph = btImage.createGraphics();
        int x = (330 - logoWidth) / 2;
        int y = (330 - logoHeight) / 2;
        graph.drawImage(logoImg, x, y, logoWidth, logoWidth, null);
        Shape shape = new RoundRectangle2D.Float(x, y, logoWidth, logoWidth, 6, 6);
        graph.setStroke(new BasicStroke(3f));
        graph.draw(shape);
        graph.dispose();

        // 建立画布并设置背景色，一般设置为白色
        // 将二维码信息和备注信息均渲染在该画布上，作为最终的输出
        BufferedImage logoReamarkImage = new BufferedImage(300, 325, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = logoReamarkImage.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 300, 325);
        graphics.dispose();

        // 将生成的二维码转化为像素数组，并将数组写到画布logoReamarkImage上
        int[] imageNewArray = new int[300 * 300];
        imageNewArray = btImage.getRGB(0, 0, 300, 300, imageNewArray, 0, 300);
        logoReamarkImage.setRGB(0, 0, 300, 300, imageNewArray, 0, 300);

        // 写备注信息
        Graphics gText = logoReamarkImage.createGraphics();
        gText.setColor(Color.black);
        gText.setFont(new Font(null, Font.PLAIN, 18));
        gText.drawString("快来学JAVA", 110, 320);
        gText.dispose();


        // 定义输出流，将二维缓存图片写到指定输出流
        // 将最终生成的二维码写到本地
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(logoReamarkImage, "jpg", out);

        String path = "D:\\DEV_ENV" + File.separator + "image" + File.separator + new SimpleDateFormat("yyyyMMdd").format(new Date());
        File pathDir = new File(path);
        if (!pathDir.exists()) {
            pathDir.mkdirs();
        }

        File pathFile = new File(path + File.separator + "qrcodeLogoRemark.jpg");
        byte[] fileIo = out.toByteArray();
        try {
            OutputStream os = new FileOutputStream(pathFile);
            os.write(fileIo);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
