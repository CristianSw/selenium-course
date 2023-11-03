package module_26_excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelData {

    public ExcelData() throws IOException {
    }

    private FileInputStream fis = new FileInputStream("//home//cristian//Documents//excel_data.xlsx");
    private XSSFWorkbook workbook = new XSSFWorkbook(fis);
    private XSSFSheet sheet;
    private Row firstRow;
    private Cell cellValue;

    private ArrayList<String> data = new ArrayList<>();


    public ArrayList<String> getExcelData(String testCaseName) {
        int sheetsCount = workbook.getNumberOfSheets();
        for (int i = 0; i < sheetsCount; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("TestData")) {
                sheet = workbook.getSheetAt(i);
                Iterator<Row> rows = sheet.iterator();
                firstRow = rows.next();
                Iterator<Cell> ce = firstRow.cellIterator();
                int j = 0;
                int columnCount = 0;
                while (ce.hasNext()) {
                    cellValue = ce.next();
                    if (cellValue.getStringCellValue().equalsIgnoreCase("testcases")) {
                        columnCount = j;
                        break;
                    }
                    j++;
                }
                System.out.println(columnCount);
                while (rows.hasNext()) {
                    firstRow = rows.next();
                    if (firstRow.getCell(columnCount).getStringCellValue().equalsIgnoreCase(testCaseName)) {
                        Iterator<Cell> cellIterator = firstRow.cellIterator();
                        while (cellIterator.hasNext()) {
                            Cell c = cellIterator.next();
                            if (c.getCellType() == CellType.STRING) {
                                data.add(c.getStringCellValue());
                            }else {
                                data.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }
                        }
                        break;
                    }
                }
            }
        }
        return data;
    }
}
