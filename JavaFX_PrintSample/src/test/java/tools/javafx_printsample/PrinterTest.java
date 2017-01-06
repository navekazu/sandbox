package tools.javafx_printsample;

import javafx.concurrent.Task;
import javafx.print.*;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import org.junit.*;

import java.io.File;

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
                .forEach(PrinterTest::outputPrinterInformation);
    }

    @Test
    public void printSampleTest() {
/*
        VBox root = new VBox();
        Node node = new Circle(100, 200, 200);
        Label label       = new Label( "印刷テスト" );
        Image img         = new Image( new File("img/ean13.png").toURI().toString() );
        ImageView view        = new ImageView( img );
        Button button      = new Button( "印刷" );
        root.getChildren().addAll( label , view , button );

        Printer printer = Printer.getDefaultPrinter();
        PageLayout pageLayout = printer.getDefaultPageLayout();
        PrinterJob job = PrinterJob.createPrinterJob();
        job.setPrinter(Printer.getDefaultPrinter());
*/
//        JobSettings jobSettings = job.getJobSettings();
//        jobSettings.setCollation(Collation.UNCOLLATED);
//        job.showPrintDialog(null);
//        job.showPageSetupDialog(null);
//        System.out.println("jobStatus result:"+job.getJobStatus().name());
//        System.out.println("printPage result:"+job.printPage(root));
//        System.out.println("endJob    result:"+job.endJob());
    }

    private static final void outputPrinterInformation(Printer printer) {
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
