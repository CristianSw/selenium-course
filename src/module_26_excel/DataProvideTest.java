package module_26_excel;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class DataProvideTest {
    DataFormatter formatter = new DataFormatter();

    @Test(dataProvider = "excelData")
    public void testCaseData(String greeting, String info, String id) {
        System.out.println(greeting + " " + info + " " + id);
    }

    @DataProvider(name = "excelData")
    public Object[][] getData() throws IOException {
        FileInputStream fis = new FileInputStream("//home//cristian//Documents//excel_data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(1);
        System.out.println(sheet.getSheetName());
        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
        XSSFRow row = sheet.getRow(0);
        short columnCount = row.getLastCellNum();

        Object[][] data = new Object[physicalNumberOfRows - 1][columnCount];
        for (int i = 0; i < physicalNumberOfRows - 1; i++) {
            row = sheet.getRow(i + 1);
            for (int j = 0; j < columnCount; j++) {
                XSSFCell cell = row.getCell(j);
                data[i][j] = formatter.formatCellValue(cell);
            }
        }
        return data;
    }
}
