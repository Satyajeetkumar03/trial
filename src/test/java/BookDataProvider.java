import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;

public class BookDataProvider {

    @DataProvider()
    public static String[][] getexcel() throws Exception
    {
        File excelfile=new File("src/test/Resources/DataProvider_excel.xlsx");
        FileInputStream fis=new FileInputStream(excelfile);
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheet("Sheet1");
        String[][] data=new String[17][2];
        System.out.println(sheet.getRow(5).getCell(4));
        for(int i=5; i<22;i++)
        {
            for(int j=4;j<6;j++)
            {
                DataFormatter df=new DataFormatter();
                data[i-5][j-4]=df.formatCellValue(sheet.getRow(i).getCell(j));
                System.out.println(data[i-5][j-4]);
            }

        }
        workbook.close();
        fis.close();
        return data;
    }
}
