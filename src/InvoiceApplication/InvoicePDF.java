import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.*;

public class InvoicePDF {
    public static void main(String[] args) {
        try {
            // ഫോൾഡർ ഉണ്ടാക്കുന്നു
            File folder = new File("C:/Invoices");
            if (!folder.exists()) {
                folder.mkdirs();
            }

            // ഡോക്യുമെന്റ് സൃഷ്ടിക്കുന്നു
            Document document = new Document(PageSize.A4, 36, 36, 36, 36);
            PdfWriter.getInstance(document, new FileOutputStream("C:/Invoices/invoice.pdf"));
            document.open();

            // ഉള്ളടക്കം ചേർക്കുന്നു
            document.add(new Paragraph("Invoice Example", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18)));
            document.add(new Paragraph("ഇത് ഒരു ഉദാഹരണ ഇൻവോയ്സ് ആണ്."));

            document.close(); // അടയ്ക്കുക
            System.out.println("✅ PDF വിജയകരമായി സേവ് ചെയ്തു: C:/Invoices/invoice.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
