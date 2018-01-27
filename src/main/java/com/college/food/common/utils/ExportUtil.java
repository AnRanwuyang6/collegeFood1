package com.college.food.common.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author pengweidong
 * @description
 * @date 2017/12/14
 **/
public class ExportUtil {
    public static void exportExcel(HttpServletResponse response, String fileName, List<String[]> list, List<Integer[]>  mergeList) throws IOException {
        OutputStream output = export(response, fileName, "excel");
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet();
        sheet.setDefaultColumnWidth(15);
        HSSFRow row;
        HSSFCell cell;

        HSSFCellStyle style = wb.createCellStyle();
        HSSFCellStyle headStyle = wb.createCellStyle();
        HSSFFont headFont = wb.createFont();
        HSSFFont contentFont = wb.createFont();
        headFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headFont.setFontName("宋体");
        headFont.setFontHeightInPoints((short) 14);
        headStyle.setFont(headFont);

        contentFont.setFontName("宋体");
        contentFont.setFontHeightInPoints((short) 10);
        style.setFont(contentFont);

        headStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        headStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        headStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        headStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow(i);
            String[] column = list.get(i);
            for (int j = 0; j < column.length; j++) {
                cell = row.createCell(j);
                if (i == 0) {
                    cell.setCellStyle(headStyle);
                } else {
                    cell.setCellStyle(style);
                }
                cell.setCellValue(new HSSFRichTextString(column[j]));
            }
        }

        if (mergeList != null && mergeList.size() > 0) {
            for (int i = 0; i < mergeList.size(); i++) {
                CellRangeAddress cra = new CellRangeAddress(mergeList.get(i)[0], mergeList.get(i)[1], mergeList.get(i)[2], mergeList.get(i)[3]);
                sheet.addMergedRegion(cra);
            }
        }

        wb.write(output);
        output.flush();
        output.close();
    }

    //导出pdf格式，Maven 未引入 itextpdf 包
//    public static void exportPdf(HttpServletResponse response, String fileName, List<String[]> list) throws IOException, DocumentException {
//        if (null == list && list.size() == 0) {
//            return;
//        }
//
//        int colNumber = list.get(0).length;
//
//        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//        Font font = new Font(bfChinese, 10, Font.NORMAL);
//
//        OutputStream output = export(response, fileName, "pdf");
//        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
//        PdfWriter.getInstance(document, output);
//        document.open();
//
//        PdfPTable table = new PdfPTable(colNumber);
//        String[] columns;
//        for (int i = 0; i < list.size(); i++) {
//            columns = list.get(i);
//            for (int j = 0; j < columns.length; j++) {
//                table.addCell(new Paragraph(columns[j], font));
//            }
//        }
//
//        document.add(table);
//
//        document.close();
//
//        output.flush();
//        output.close();
//    }

    public static OutputStream export(HttpServletResponse response, String fileName, String contentType) throws IOException {
        response.reset();
        if ("pdf".equals(contentType)) {
            response.setContentType("application/pdf;charset=UTF-8");
        } else {
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        }
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "iso8859-1"));
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        OutputStream output = response.getOutputStream();
        return output;
    }
}
