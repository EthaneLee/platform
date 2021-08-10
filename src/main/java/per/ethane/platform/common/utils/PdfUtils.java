package per.ethane.platform.common.utils;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.apache.commons.codec.binary.Base64;

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
//        String file = "C:\\Users\\THTF\\Desktop\\test.html";
//        String pdfPath = "C:\\Users\\THTF\\Desktop\\test.pdf";
        String font = "D:\\GitLabRepo\\platform\\src\\main\\resources\\utils\\simsun.ttc";
//        html2pdf(file, pdfPath, font);
//        System.out.println("done");
        System.out.println(System.getProperty("user.home"));
        String pdfTempFile = System.getProperty("user.home") + "\\Desktop\\temp";
        String content = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "    <title>局部打印案例</title>\n" +
                "\n" +
                "    <style type=\"text/css\">\n" +
                "        /*解决html转pdf文件中文不显示的问题*/\n" +
                "        body {\n" +
                "            font-family: SimSun;\n" +
                "        }\n" +
                "\n" +
                "        /*设定纸张大小*/\n" +
                "        /* A4纸 */\n" +
                "        /* @page{size:210mm*297mm} */\n" +
                "        @page{size:a4}\n" +
                "\n" +
                "    </style>\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "    <p>1不需要打印的地方</p>\n" +
                "    <!--startprint-->\n" +
                "    <!--注意要加上html里star和end的这两个标记-->\n" +
                "    <h1>打印标题</h1>\n" +
                "    <p>打印内容~~</p>\n" +
                "    <!--endprint-->\n" +
                "    <p>2不需要打印的地方</p>\n" +
                "</body>\n" +
                "\n" +
                "</html>";
        try {
            File temp = File.createTempFile("lgTemplate", ".html");
            String abs = temp.getAbsolutePath();
            FileUtils.writeDataToFile(content, abs);
            String name = pdfTempFile+ "\\" + temp.getName().replace(".html", ".pdf");
            PdfUtils.html2pdf(abs, name, font);
            File pdfFile = new File(name);

            try (FileInputStream fin = new FileInputStream(pdfFile);
                BufferedInputStream bin = new BufferedInputStream(fin);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                BufferedOutputStream bout = new BufferedOutputStream(baos)){
                byte[] buffer = new byte[1024];
                int len = bin.read(buffer);
                while(len != -1){
                    bout.write(buffer, 0, len);
                    len = bin.read(buffer);
                }
                bout.flush();
                byte[] bytes = baos.toByteArray();
                System.out.println(Base64.encodeBase64String(bytes));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
