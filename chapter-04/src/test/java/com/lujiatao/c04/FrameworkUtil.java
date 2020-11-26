package com.lujiatao.c04;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class FrameworkUtil {

    public static Object[][] readExcel(String file, String sheetName) {
        Object[][] result;
        if (file.endsWith(".xlsx")) {
            try (XSSFWorkbook workbook = new XSSFWorkbook(getStreamFromFile(file));) {
                XSSFSheet sheet = workbook.getSheet(sheetName);
                result = readExcel(sheet);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        } else if (file.endsWith(".xls")) {
            try (HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(getStreamFromFile(file)));) {
                HSSFSheet sheet = workbook.getSheet(sheetName);
                result = readExcel(sheet);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        } else {
            throw new IllegalArgumentException("文件类型错误！");
        }
        return result;
    }

    public static String keywordToMethod(String keyword) {
        String tmp = keyword.replaceAll(" ", "");
        return tmp.substring(0, 1).toLowerCase() + tmp.substring(1);
    }

    private static InputStream getStreamFromFile(String file) {
        return Objects.requireNonNull(FrameworkUtil.class.getClassLoader().getResourceAsStream(file));
    }

    private static Object[][] readExcel(Sheet sheet) {
        Object[][] result = new Object[sheet.getLastRowNum() + 1][];
        for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
            Row row = sheet.getRow(i);
            Object[] tmp = new Object[row.getLastCellNum()];
            for (int j = 0; j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                cell.setCellType(CellType.STRING);
                tmp[j] = cell.getStringCellValue();
            }
            result[i] = tmp;
        }
        return result;
    }

}
