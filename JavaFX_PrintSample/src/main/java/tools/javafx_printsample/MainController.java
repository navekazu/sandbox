package tools.javafx_printsample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.print.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.Collection;

public class MainController {
    @FXML Button defaultPrinterButton;
    @FXML Button allPrintersButton;
    @FXML Button printButton;
    @FXML TextField copiesField;
    @FXML AnchorPane printCanvas;
    @FXML TextArea logArea;

    @FXML
    public void handleDefaultPrinterButtonAction(ActionEvent event) {
        Printer defaultPrinter = Printer.getDefaultPrinter();
        outputPrinterInformation(defaultPrinter);
    }

    @FXML
    public void handleAllPrintersButtonAction(ActionEvent event) {
        Collection<Printer> collection = Printer.getAllPrinters();
        collection.stream().forEach(this::outputPrinterInformation);
    }

    @FXML
    public void handlePrintButtonAction(ActionEvent event) {
        PrinterJob job = PrinterJob.createPrinterJob();
//        PrinterJob job2 = PrinterJob.createPrinterJob(Printer.getDefaultPrinter());

        JobSettings jobSettings = job.getJobSettings();
        jobSettings.setCopies(Integer.parseInt(copiesField.getText()));

        job.showPageSetupDialog(null);
        job.showPrintDialog(null);

        job.printPage(printCanvas);
        job.endJob();
    }

    private void outputPrinterInformation(Printer printer) {
        addLog("*** Name:"+printer.getName());

        // ページ・レイアウトの情報を取得して出力
        PageLayout pageLayout = printer.getDefaultPageLayout();
        PageOrientation pageOrientation = pageLayout.getPageOrientation();
        addLog("    PageLayout:");
        addLog("        TopMargin:"+pageLayout.getTopMargin());
        addLog("        LeftMargin:"+pageLayout.getLeftMargin());
        addLog("        RightMargin:"+pageLayout.getRightMargin());
        addLog("        BottomMargin:"+pageLayout.getBottomMargin());
        addLog("        PrintableHeight:"+pageLayout.getPrintableHeight());
        addLog("        PrintableWidth:"+pageLayout.getPrintableWidth());
        addLog("        PageOrientation:"+pageOrientation.name());

        // 用紙の情報を取得して出力
        Paper paper = pageLayout.getPaper();
        addLog("        Paper:");
        addLog("            Name:"+paper.getName());
        addLog("            Height:"+paper.getHeight());
        addLog("            Width:"+paper.getWidth());
    }

    private void addLog(String text) {
        logArea.appendText(text+"\n");
    }
}
