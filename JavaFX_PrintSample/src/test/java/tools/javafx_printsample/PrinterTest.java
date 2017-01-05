package tools.javafx_printsample;

import javafx.concurrent.Task;
import javafx.print.*;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import org.junit.*;

public class PrinterTest {
    @BeforeClass
    public static void beforeClass() throws Exception {
    }

    @AfterClass
    public static void afterClass() throws Exception {
    }

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void getDefaultPrinterTest() {
        Printer defaultPrinter = Printer.getDefaultPrinter();
        outputPrinterInformation(defaultPrinter);
    }

    @Test
    public void getAllPrintersTest() {
        Printer.getAllPrinters().stream()
                .forEach(printer -> outputPrinterInformation(printer));
    }

    @Test
    public void printSampleTest() {
        Node node = new Circle(100, 200, 200);
        Printer printer = Printer.getDefaultPrinter();
        PageLayout pageLayout = printer.getDefaultPageLayout();
        PrinterJob job = PrinterJob.createPrinterJob(printer);
//        job.setPrinter(Printer.getDefaultPrinter());
        System.out.println("jobStatus result:"+job.getJobStatus().name());
        System.out.println("printPage result:"+job.printPage(pageLayout, node));
        System.out.println("endJob    result:"+job.endJob());
    }

    private void outputPrinterInformation(Printer printer) {
        System.out.println("*** Name:"+printer.getName());

        PageLayout pageLayout = printer.getDefaultPageLayout();
        PageOrientation pageOrientation = pageLayout.getPageOrientation();
        Paper paper = pageLayout.getPaper();

        System.out.println("    PageLayout:");
        System.out.println("        TopMargin:"+pageLayout.getTopMargin());
        System.out.println("        LeftMargin:"+pageLayout.getLeftMargin());
        System.out.println("        RightMargin:"+pageLayout.getRightMargin());
        System.out.println("        BottomMargin:"+pageLayout.getBottomMargin());
        System.out.println("        PrintableHeight:"+pageLayout.getPrintableHeight());
        System.out.println("        PrintableWidth:"+pageLayout.getPrintableWidth());
        System.out.println("        PageOrientation:"+pageOrientation.name());
        System.out.println("        Paper:");
        System.out.println("            Name:"+paper.getName());
        System.out.println("            Height:"+paper.getHeight());
        System.out.println("            Width:"+paper.getWidth());
    }
}
