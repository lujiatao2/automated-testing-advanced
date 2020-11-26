package com.lujiatao.c08;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.Files.newBufferedWriter;

public class MyReporter implements IReporter {

    private PrintWriter writer;
    private int totalCount;
    private int passedCount;
    private int failedCount;
    private int skippedCount;

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        if (!new File(outputDirectory).mkdirs()) {
            throw new RuntimeException("创建测试报告目录失败！");
        }
        try {
            writer = new PrintWriter(newBufferedWriter(new File(outputDirectory, "my-report.html").toPath(), UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("创建测试报告文件失败！");
        }
        for (ISuite suite : suites) {
            for (ISuiteResult suiteResult : suite.getResults().values()) {
                ITestContext testContext = suiteResult.getTestContext();
                passedCount += testContext.getPassedTests().size();
                failedCount += testContext.getFailedTests().size();
                skippedCount += testContext.getSkippedTests().size();
            }
        }
        totalCount = passedCount + failedCount + skippedCount;
        writeBeforeBody();
        writeBody();
        writeAfterBody();
        writer.close();
        SendEmailClient sendEmailClient = new SendEmailClient.SendEmailClientBuilder().build();
        Date date = new Date();
        String str = "-yyyMMddHHmmss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        try {
            Thread.sleep(3000);
            sendEmailClient.sendHTMLEmail("yourqq@qq.com", "yourqq@qq.com", "TestNG测试报告" + simpleDateFormat.format(date), "test-output/my-report.html");
        } catch (InterruptedException | MessagingException e) {
            e.printStackTrace();
        }
    }

    private void writeBeforeBody() {
        writer.println("<!DOCTYPE html>");
        writer.println("<html lang=\"en\">");
        writer.println("<head>");
        writer.println("<style>");
        writer.println("h1 { text-align: center; }");
        writer.println("div { margin: 0 auto; width: 80%; }");
        writer.println("table { border: 2px solid; text-align: center; width: 100%; }");
        writer.println("th, td { border: 1px solid gray; }");
        writer.println("</style>");
        writer.println("<meta charset=\"UTF-8\">");
        writer.println("<title>TestNG测试报告</title>");
        writer.println("</head>");
    }

    private void writeBody() {
        writer.println("<body>");
        writer.println("<h1>TestNG测试报告</h1>");
        writer.println("<div>");
        writer.println("<table>");
        writer.println("<tr>");
        writer.println("<th>总数</th>");
        writer.println("<th>成功</th>");
        writer.println("<th>失败</th>");
        writer.println("<th>跳过</th>");
        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td>" + totalCount + "</td>");
        writer.println("<td>" + passedCount + "</td>");
        writer.println("<td>" + failedCount + "</td>");
        writer.println("<td>" + skippedCount + "</td>");
        writer.println("</tr>");
        writer.println("</table>");
        writer.println("</div>");
        writer.println("</body>");
    }

    private void writeAfterBody() {
        writer.println("</html>");
    }

}
