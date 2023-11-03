package module_26_excel;

import java.io.IOException;
import java.util.ArrayList;

public class testExcel {
    public static void main(String[] args) throws IOException {
        ExcelData excelData = new ExcelData();

        ArrayList<String> data = excelData.getExcelData("Add profile");
        System.out.println(data.get(0));
        System.out.println(data.get(1));
        System.out.println(data.get(2));
        System.out.println(data.get(3));
    }
}
