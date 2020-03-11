package cn.lhy.springMVC.view;

import cn.lhy.springMVC.entity.User;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 如果要在Controller层使用返回字符串的形式，来进行下载，则要把ExcelView纳入容器的管理
 */
@Component("excelView")
public class ExcelView extends AbstractXlsxView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 设置用户下载的文件名
        String fileName = "UserList.xlsx";
        response.setCharacterEncoding("UTF-8");
        response.setContentType("aplication/ms-excel");
        response.setHeader("Content-Disposition", "inline;filename=" + new String(fileName.getBytes(), "UTF-8"));
        List<User> userList = (List<User>) model.get("userList");
        // 创建一个页面，构造器的参数，就是页面的名字
        Sheet sheet = workbook.createSheet("基本信息");
        Row headRow = sheet.createRow(0);
        headRow.createCell(0).setCellValue("id");
        headRow.createCell(1).setCellValue("用户名");
        headRow.createCell(2).setCellValue("年龄");

        // 把userList中的值输入到excel表格中
        for (int i=0; i<userList.size(); i++){
            Row row = sheet.createRow(i + 1);
            User user = userList.get(i);
            row.createCell(0).setCellValue(user.getId());
            row.createCell(1).setCellValue(user.getUsername());
            row.createCell(2).setCellValue(user.getAge());
        }

        // 用输出流将excel文档传输给用户
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
