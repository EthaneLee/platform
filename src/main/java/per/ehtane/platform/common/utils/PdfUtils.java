package per.ehtane.platform.common.utils;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;

/**
 * PDF工具类
 * @author sen li
 * @date 2021/3/15
 * @version 1.0.0
 */
public class PdfUtils {

    /**
     * 将html文件转换成PDF
     * @author sen li
     * @date 2021/3/15 14:50
     * @param htmlPath html文件地址
     * @param pdfPath pdf保存地址
     * @param font 中文字体地址
    **/        
    private static void html2pdf(String htmlPath, String pdfPath, String font){
        String url;
        OutputStream os = null;
        try{
            url = new File(htmlPath).toURI().toURL().toString();
            os = new FileOutputStream(pdfPath);
            ITextRenderer render = new ITextRenderer();
            render.setDocument(url);
            ITextFontResolver fontResolver = render.getFontResolver();
            fontResolver.addFont(font, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

            render.layout();
            render.createPDF(os);

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally{
            if(os != null){
                try {
                    os.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        String file = "C:\\Users\\THTF\\Desktop\\test.html";
        String pdfPath = "C:\\Users\\THTF\\Desktop\\test.pdf";
        String font = "D:\\GitLabRepo\\platform\\src\\main\\resources\\utils\\simsun.ttc";
        html2pdf(file, pdfPath, font);
        System.out.println("done");
    }


}
