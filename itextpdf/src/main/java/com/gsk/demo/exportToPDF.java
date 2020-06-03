package com.gsk.demo;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by PengSongHe on 2016/10/20 0020.
 */
public class exportToPDF {
  public static void main(String[] args) {
    try {
      Document document = new Document(PageSize.A4,50,50,30,20);//默认A4
      File file = new File("f:\\HelloWorld.pdf");
      boolean newFile = file.createNewFile();
      PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
      writer.setPdfVersion(PdfWriter.PDF_VERSION_1_7);
      document.addCreationDate();
      document.addCreator("飞翔家族");
      document.addTitle("export pdf");
      document.addKeywords("export");
      document.addSubject("飞翔家族 export pdf");

      /*打开文档*/
      document.open();
//处理中文，需要itextasian.jar支持
      FontSelector selector = new FontSelector();
      selector.addFont(FontFactory.getFont(FontFactory.TIMES_ROMAN, 12));
      selector.addFont(FontFactory.getFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED));
      Phrase phrase = selector.process("HelloWord！你好。\u4fdd\u5b58");
      document.add(new Paragraph(phrase));
      //添加新页
      //document.newPage();
      //writer.setPageEmpty(false);
      //document.add(new Paragraph("New page"));


      /*关闭文档*/
      document.close();
    } catch (DocumentException | IOException e) {
      e.printStackTrace();
    }
  }
}