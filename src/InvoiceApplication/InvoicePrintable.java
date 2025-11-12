package InvoiceApplication;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.print.*;
import javax.swing.table.DefaultTableModel;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InvoicePrintable implements Printable {

//    private int invoiceNo;
//    private String date;
//    private String customer;
//    private String address;
//    private String po;
//    private String email;
//    private String website;
//    private String logoPath;
//    private String companyName;
//    private String companyAddress;
//    private double grandTotal;
//    private DefaultTableModel model;
//    private String amountInWords; // ✅ New variable
//    private String invoice;
//    public InvoicePrintable(int invoiceNo, String date, String customer, String address,
//                            String po, DefaultTableModel model, double grandTotal,
//                            String companyName, String companyAddress, String email, String website, String logoPath,String amountInWords,String invoice ) {
//        this.invoiceNo = invoiceNo;
//        this.date = date;
//        this.customer = customer;
//        this.address = address;
//        this.po = po;
//        this.model = model;
//        this.grandTotal = grandTotal;
//        this.companyName = companyName;
//        this.companyAddress = companyAddress;
//        this.email = email;
//        this.website = website;
//        this.logoPath = logoPath;
//        this.amountInWords = amountInWords; // ✅ Save it
//        this.invoice = invoice; // ✅ Save it
//        
//        
//        // 🖼️ Load logo from resources
//
//
//
//    }
//
//    @Override
//    public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
//        if (pageIndex > 0) return NO_SUCH_PAGE;
//     
//        
//        Graphics2D g2 = (Graphics2D) g;

//Image logo = null;

//Image logo;
//        try {
//            logo = ImageIO.read(new File("G:\\InvoiceApplication\\images\\vph_logo.png"));
//        } catch (IOException ex) {
//            Logger.getLogger(InvoicePrintable.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//try {
//    if (logoPath != null && !logoPath.isEmpty()) {
//        logo = ImageIO.read(new File(logoPath));
//        g2.drawImage(logo, 50, 30, 80, 40, null); // Adjust x,y,width,height
//    }
//} catch (IOException e) {
//    System.out.println("⚠️ Could not load logo: " + logoPath);
//}


//InputStream is = getClass().getResourceAsStream("/vph_logo.png");
//if (is != null) {
//            try {
//                BufferedImage image = ImageIO.read(is);
//            } catch (IOException ex) {
//                Logger.getLogger(InvoicePrintable.class.getName()).log(Level.SEVERE, null, ex);
//            }
//} else {
//    System.err.println("Error: Image resource not found!");
//}


       // Graphics2D g2 = (Graphics2D) g;
//        g2.translate(pf.getImageableX(), pf.getImageableY());
//        g2.setFont(new Font("Arial", Font.PLAIN, 10));
//
//        int y = 40;

        // 🖼️ Logo
//        try {
//            if (logoPath != null && !logoPath.isEmpty()) {
//                Image logo = ImageIO.read(new File(logoPath));
//                g2.drawImage(logo, 50, y-10 , 80, 40, null);
//            }
//        } catch (IOException ex) {
//            System.out.println("Logo not found: " + ex.getMessage());
//        }

        // 🏪 Company Info
//        g2.setFont(new Font("Arial", Font.BOLD, 16));
//        g2.drawString(companyName, 150, y);
//        g2.setFont(new Font("Arial", Font.PLAIN, 10));
//        g2.drawString(companyAddress, 150, y + 15);
//        g2.drawString("Email: " + email , 150, y + 30);
//        g2.drawString("Website: " + website , 150, y + 45);
//        g2.setFont(new Font("Arial", Font.BOLD, 14));
//        g2.drawString( invoice , 150, y + 60);
//        
//
//        y += 70;
//        g2.drawLine(50, y, 550, y);
//        y += 20;
//
//        // 🧾 Invoice Info
//        g2.setFont(new Font("Arial", Font.PLAIN, 11));
//        g2.drawString("Invoice No: " + invoiceNo, 60, y);
//        g2.drawString("Date: " + date, 450, y);
//        y += 20;
//        g2.drawString("Customer: " + customer, 60, y);
//        y += 15;
//        g2.drawString("Address: " + address, 60, y);
//        y += 15;
//        g2.drawString("PO No: " + po, 60, y);
//
//        y += 20;
//        g2.drawLine(50, y, 550, y);
//        y += 20;
//
//        // 🧮 Table Header
//        g2.setFont(new Font("Arial", Font.BOLD, 11));
//        g2.drawString("S.No", 60, y);
//        g2.drawString("Product", 110, y);
//        g2.drawString("Qty", 300, y);
//        g2.drawString("Rate", 360, y);
//        g2.drawString("Total", 420, y);
//        y += 10;
//        g2.drawLine(50, y, 550, y);
//
//        // 📦 Table Data
//        g2.setFont(new Font("Arial", Font.PLAIN, 10));
//        y += 20;
//        for (int i = 0; i < model.getRowCount(); i++) {
//    int columnCount = model.getColumnCount();
//
//    String sno = (columnCount > 0) ? String.valueOf(model.getValueAt(i, 0)) : "";
//    String product = (columnCount > 1) ? String.valueOf(model.getValueAt(i, 1)) : "";
//    String qty = (columnCount > 2) ? String.valueOf(model.getValueAt(i, 2)) : "";
//    String rate = (columnCount > 3) ? String.valueOf(model.getValueAt(i, 3)) : "";
//    String total = (columnCount > 4) ? String.valueOf(model.getValueAt(i, 4)) : "";
//
//    g2.drawString(sno, 60, y);
//    g2.drawString(product, 110, y);
//    g2.drawString(qty, 300, y);
//    g2.drawString(rate, 360, y);
//    g2.drawString(total, 420, y);
//
//    y += 20;
//}
//
//
//        y += 10;
//        g2.drawLine(50, y, 550, y);
//        y += 25;
//
//        // 💰 Grand Total
//        g2.setFont(new Font("Arial", Font.BOLD, 12));
//        g2.drawString("Grand Total: Rs. " + grandTotal, 380, y);
//        y += 30;
//
//        // ✍️ Authorized Signature Box
//        g2.drawRect(400, y, 140, 60);
//        g2.setFont(new Font("Arial", Font.PLAIN, 10));
//        g2.drawString("Authorized Signature", 410, y + 75);
//        // 💬 Amount in Words
//
//y += 30;
//g2.setFont(new Font("Arial", Font.PLAIN, 10));
//g2.drawString("Amount in Words: " + amountInWords, 45, y+75);
//
//        // 📄 Border
//        g2.drawRect(45, 20, 510, y + 80);
//
//        return PAGE_EXISTS;
//    }
//
//    // 🖨️ Static print helper
//    public static void printInvoice(int invoiceNo, String date, String customer, String address,
//                                    String po, 
//                                    DefaultTableModel model, 
//                                    double total,
//                                    String companyName, 
//                                    String companyAddress, 
//                                    String email, 
//                                    String website, 
//                                    String logoPath,
//                                    String amountInWords,
//                                    String invoice) {
//        PrinterJob job = PrinterJob.getPrinterJob();
//        job.setPrintable(new InvoicePrintable(
//                invoiceNo, 
//                date, 
//                customer, 
//                address, 
//                po, 
//                model, 
//                total,
//                companyName, 
//                companyAddress, 
//                email, website, 
//                logoPath,
//                amountInWords,
//                invoice));
//        boolean doPrint = job.printDialog();
//        if (doPrint) {
//            try {
//                job.print();
//            } catch (PrinterException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    
    
    
    
    
    ////
    
    
//    private String invoiceNo, customerName, address, amountWords;
//    private double grandTotal;
//    private Image logo;
//
//    public InvoicePrintable(String invoiceNo, String customerName, String address, double grandTotal, String amountWords, Image logo) {
//        this.invoiceNo = invoiceNo;
//        this.customerName = customerName;
//        this.address = address;
//        this.grandTotal = grandTotal;
//        this.amountWords = amountWords;
//        this.logo = logo;
//    }
//
//    @Override
//    public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
//        if (pageIndex > 0) {
//            return NO_SUCH_PAGE;
//        }
//
//        Graphics2D g2 = (Graphics2D) g;
//        g2.translate(pf.getImageableX(), pf.getImageableY());
//        g2.setFont(new Font("Arial", Font.PLAIN, 10));
//
//        // Header
//        g2.setFont(new Font("Arial", Font.BOLD, 18));
//        g2.drawString("VISHNU PRINT HOUSE", 250, 40);
//
//        g2.setFont(new Font("Arial", Font.PLAIN, 11));
//        g2.drawString("Address: Main Road, Palakkad, Kerala - 678001", 230, 60);
//        g2.drawString("Phone: +91 98765 43210 | Email: info@vishnuprint.in", 230, 75);
//        g2.drawString("Website: www.vishnuprint.in", 230, 90);
//
//        // Logo left side
//        if (logo != null)
//            g2.drawImage(logo, 60, 30, 100, 80, null);
//
//        // Invoice details
//        g2.setFont(new Font("Arial", Font.PLAIN, 12));
//        g2.drawString("Invoice No: " + invoiceNo, 60, 120);
//        g2.drawString("Date: " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()), 400, 120);
//
//        g2.drawString("Customer Name: " + customerName, 60, 140);
//        g2.drawString("Address: " + address, 60, 155);
//
//        // Table Header
//        g2.drawRect(50, 180, 500, 20);
//        g2.drawString("Sl No", 60, 195);
//        g2.drawString("Particular", 120, 195);
//        g2.drawString("Qty", 320, 195);
//        g2.drawString("Rate", 380, 195);
//        g2.drawString("Total", 460, 195);
//
//        // Sample Data (replace with actual JTable data)
//        int y = 215;
//        for (int i = 1; i <= 5; i++) {
//            g2.drawRect(50, y - 15, 500, 20);
//            g2.drawString(String.valueOf(i), 65, y);
//            g2.drawString("Sample Item " + i, 120, y);
//            g2.drawString("2", 330, y);
//            g2.drawString("100.00", 380, y);
//            g2.drawString("200.00", 460, y);
//            y += 20;
//        }
//
//        // Grand total
//        g2.setFont(new Font("Arial", Font.BOLD, 12));
//        g2.drawString("Grand Total: ₹ " + grandTotal, 400, y + 20);
//
//        g2.setFont(new Font("Arial", Font.PLAIN, 11));
//        g2.drawString("Amount in Words: " + amountWords, 60, y + 40);
//
//        // Bank & Signature
//        g2.drawString("Bank Account: 1234567890 | IFSC: SBIN0001234", 60, y + 70);
//        g2.drawString("For Vishnu Print House", 400, y + 70);
//        g2.drawString("Authorised Signature", 410, y + 100);
//
//        return PAGE_EXISTS;
//    }
    
    
    
//      private String invoiceNo, customer, address, amountInWords;
//    private double grandTotal;
//    private Image logo;
//    private DefaultTableModel items;
//
//    public InvoicePrintable(String invoiceNo, String customer, String address, double grandTotal, String amountInWords, Image logo) {
//        this.invoiceNo = invoiceNo;
//        this.customer = customer;
//        this.address = address;
//        this.grandTotal = grandTotal;
//        this.amountInWords = amountInWords;
//        this.logo = logo;
//    }
//
//    @Override
//    public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
//        if (pageIndex > 0) return NO_SUCH_PAGE;
//
//        Graphics2D g2 = (Graphics2D) g;
//        g2.translate(pf.getImageableX(), pf.getImageableY());
//        g2.setFont(new Font("Arial", Font.PLAIN, 10));
//
//        int y = 40;
//
//        // --- HEADER ---
//        if (logo != null) {
//            g2.drawImage(logo, 40, y, 80, 80, null); // Left side logo
//        }
//
//        g2.setFont(new Font("Arial", Font.BOLD, 18));
//        g2.drawString("Vishnu Print House", 150, y + 20);
//
//        g2.setFont(new Font("Arial", Font.PLAIN, 12));
//        g2.drawString("Address: Main Road, Your City", 150, y + 40);
//        g2.drawString("Phone: +91-8547706377 | Email: vishnuprinthouse101@gmail.com", 150, y + 55);
//        g2.drawString("Website: www.vishnuprint.com", 150, y + 70);
//
//        // --- DATE & INVOICE NO ---
//        g2.setFont(new Font("Arial", Font.BOLD, 12));
//        g2.drawString("Invoice No: " + invoiceNo, 500, y + 20);
//        g2.drawString("Date: " + java.time.LocalDate.now().toString(), 500, y + 40);
//
//        y += 110;
//
//        // --- CUSTOMER DETAILS ---
//        g2.setFont(new Font("Arial", Font.BOLD, 12));
//        g2.drawString("Customer Name: ", 50, y);
//        g2.setFont(new Font("Arial", Font.PLAIN, 12));
//        g2.drawString(customer, 170, y);
//        y += 20;
//
//        g2.setFont(new Font("Arial", Font.BOLD, 12));
//        g2.drawString("Address: ", 50, y);
//        g2.setFont(new Font("Arial", Font.PLAIN, 12));
//        g2.drawString(address, 170, y);
//
//        y += 40;
//
//        // --- TABLE HEADER ---
//        g2.setFont(new Font("Arial", Font.BOLD, 12));
//        g2.drawRect(40, y, 520, 20);
//        g2.drawString("Sl.No", 50, y + 15);
//        g2.drawString("Particulars", 100, y + 15);
//        g2.drawString("Qty", 330, y + 15);
//        g2.drawString("Rate", 400, y + 15);
//        g2.drawString("Total", 470, y + 15);
//
//        // --- DRAW VERTICAL LINES ---
//        g2.drawLine(90, y, 90, y + 200);
//        g2.drawLine(320, y, 320, y + 200);
//        g2.drawLine(390, y, 390, y + 200);
//        g2.drawLine(460, y, 460, y + 200);
//        g2.drawRect(40, y, 520, 200);
//
//        y += 25;
//
//        // --- TABLE CONTENT ---
//        g2.setFont(new Font("Arial", Font.PLAIN, 12));
//
//        // Example static rows (you can replace with JTable data)
//        for (int i = 1; i <= 5; i++) {
//            g2.drawString(String.valueOf(i), 55, y + (i * 30));
//            //g2.drawString("Sample Product " + i, 100, y + (i * 30));
//            g2.drawString("Sample Product " + i, 100, y + (i * 30));
//            g2.drawString("2", 340, y + (i * 30));
//            g2.drawString("100.00", 405, y + (i * 30));
//            g2.drawString("200.00", 475, y + (i * 30));
//        }
//
//        y += 190;
//
//        // --- GRAND TOTAL ---
//        g2.setFont(new Font("Arial", Font.BOLD, 12));
//        g2.drawString("Grand Total: ₹" + grandTotal, 400, y + 30);
//
//        // --- AMOUNT IN WORDS ---
//        g2.setFont(new Font("Arial", Font.ITALIC, 12));
//        g2.drawString("Amount in Words: " + amountInWords, 50, y + 60);
//
//        // --- BANK DETAILS ---
//        g2.setFont(new Font("Arial", Font.PLAIN, 12));
//        g2.drawString("Bank: SBI, A/c No: 1234567890, IFSC: SBIN0001234", 50, y + 90);
//
//        // --- SIGNATURE AREA ---
//        g2.drawString("For Vishnu Print House", 400, y + 110);
//        g2.drawLine(400, y + 140, 550, y + 140);
//        g2.drawString("Authorised Signature", 420, y + 155);
//
//        return PAGE_EXISTS;
//    }
    
    
    
    //new
    
 private String invoiceNo, date, customerName, customerAddress, poNo, amountWords;
    private double grandTotal;
    private DefaultTableModel model;
    private Image logo;

    public InvoicePrintable(String invoiceNo, String date, String customerName, String customerAddress, 
                            String poNo, DefaultTableModel model, double grandTotal, String amountWords, Image logo) {
        this.invoiceNo = invoiceNo;
        this.date = date;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.poNo = poNo;
        this.model = model;
        this.grandTotal = grandTotal;
        this.amountWords = amountWords;
        this.logo = logo;
    }

    @Override
    public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
        if (pageIndex > 0) return NO_SUCH_PAGE;
//Graphics2D g2 = (Graphics2D) g;

Graphics2D g2 = (Graphics2D) g;

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        g2d.setColor(Color.BLACK);

        int startX = 40;      // left margin
        int startY = 60;      // top margin
        int pageWidth = (int) pf.getImageableWidth() - 60; // right margin space

        // Draw outer border
        g2d.drawRect(startX - 20, startY - 40, pageWidth + 40, (int) pf.getImageableHeight() - 100);

        // Draw logo (scaled and visible)
//        if (logo != null) {
//            g2d.drawImage(logo, startX - 10, startY - 20, 90, 90, null);
//        }
// Draw Logo
BufferedImage logo = null;
try {
    File file = new File("images", "vph_logo.png");
    logo = ImageIO.read(file);
    System.out.println("✅ Logo file found: " + file.getAbsolutePath());
} catch (Exception e) {
    System.out.println("⚠️ Logo not found: " + e.getMessage());
}
if (logo != null) {
    g2.drawImage(logo, startX + 20, startY + 20, 120, 60, null);
} else {
    g2.setFont(new Font("Arial", Font.PLAIN, 10));
    g2.drawString("[Logo Missing]", startX + 20, startY + 50);
}
//if (logo != null) {
//    int logoX = 50;       // distance from left margin
//    int logoY = 60;       // distance from top margin
//    int logoWidth = 120;  // width (adjust as needed)
//    int logoHeight = 120; // height (adjust as needed)
//
//    g2.drawImage(logo, logoX, logoY, logoWidth, logoHeight, null);
//} else {
//    g2.drawString("LOGO NOT FOUND", 50, 80);
//}


        // Firm Name and Address
        g2d.setFont(new Font("Arial", Font.BOLD, 18));
        g2d.drawString("VISHNU PRINT HOUSE", startX + 160, startY + 10);

        g2d.setFont(new Font("Arial", Font.PLAIN, 11));
        g2d.drawString("Opp: Petrol Pump, Koyyamarakkad", startX + 160, startY + 30);
        g2d.drawString("Kanjikode, Palakkad - 678621", startX + 160, startY + 45);
        g2d.drawString("Phone: +91 8547706377, 9809414537", startX + 160, startY + 60);
        g2d.drawString("Email: vishnuprinthouse101@gmail.com", startX + 160, startY + 75);
        g2d.drawString("Website: vishnuprinthouse.unaux.com", startX + 160, startY + 90);

       // g2d.drawLine(startX - 10, tableY + 5, startX + pageWidth + 10, tableY + 5);
        // INVOICE title
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString("INVOICE", pageWidth / 2, startY + 120);

        // Invoice details (Left & Right)
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));
        g2d.drawString("Invoice No: " + invoiceNo, startX, startY + 150);
        g2d.drawString("Date: " + date, startX + 350, startY + 150);
        g2d.drawString("Customer Name: " + customerName, startX, startY + 170);
        g2d.drawString("Address: " + customerAddress, startX, startY + 190);
        g2d.drawString("PO No: " + poNo, startX, startY + 210);

        // Table Headers
        int tableY = startY + 240;
        g2d.drawLine(startX - 10, tableY - 15, startX + pageWidth + 10, tableY - 15);

        g2d.setFont(new Font("Arial", Font.BOLD, 12));
        g2d.drawString("Sl No", startX, tableY);
        g2d.drawString("Particular", startX + 50, tableY);
        g2d.drawString("Qty", startX + 250, tableY);
        g2d.drawString("Rate", startX + 320, tableY);
        g2d.drawString("Total", startX + 400, tableY);

        g2d.drawLine(startX - 10, tableY + 5, startX + pageWidth + 10, tableY + 5);

        // Draw table content
        g2d.setFont(new Font("Arial", Font.PLAIN, 11));
        int dataY = tableY + 25;
        for (int i = 0; i < model.getRowCount(); i++) {
            g2d.drawString(String.valueOf(model.getValueAt(i, 0)), startX, dataY);
            g2d.drawString(String.valueOf(model.getValueAt(i, 1)), startX + 50, dataY);
            g2d.drawString(String.valueOf(model.getValueAt(i, 2)), startX + 250, dataY);
            g2d.drawString(String.valueOf(model.getValueAt(i, 3)), startX + 320, dataY);
            g2d.drawString(String.valueOf(model.getValueAt(i, 4)), startX + 400, dataY);
            dataY += 20;
        }

        // Horizontal line before total
        g2d.drawLine(startX - 10, dataY, startX + pageWidth + 10, dataY + 2);

        // Grand Total
        dataY += 25;
        g2d.setFont(new Font("Arial", Font.BOLD, 12));
        g2d.drawString("Grand Total: ₹ " + grandTotal, startX + 300, dataY);

        // Amount in Words
        dataY += 25;
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));
        g2d.drawString("Amount in Words: " + amountWords, startX, dataY);

        // Bank Details
        //dataY += 50;
        dataY += 100;
        g2d.setFont(new Font("Arial", Font.PLAIN, 11));
        g2d.drawString("Bank Details:", startX, dataY);
        dataY += 15;
        g2d.drawString("Bank Name: Indian Overseas Bank", startX, dataY);
        dataY += 15;
        g2d.drawString("Branch: Kanjikode", startX, dataY);
        dataY += 15;
        g2d.drawString("A/c No: 035702000000155", startX, dataY);
        dataY += 15;
        g2d.drawString("IFSC: IOBA0000357", startX, dataY);

        // Authorised Signature (with more gap)
        dataY += 25;
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));
        g2d.drawString("For Vishnu Print House", startX + 350, dataY);
        dataY += 45;
        g2d.drawString("Authorised Signature", startX + 370, dataY);

        return PAGE_EXISTS;
    }
//  @Override
//    public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
//        if (pageIndex > 0) return NO_SUCH_PAGE;
//
//        Graphics2D g2 = (Graphics2D) g;
//        g2.translate(pf.getImageableX(), pf.getImageableY());
//        g2.setFont(new Font("Times New Roman", Font.PLAIN, 10));
//
//        int y = 40; // starting Y
//        int x = 40;
//        int pageWidth = (int) pf.getImageableWidth();
//
//        // 🖼️ Logo load ചെയ്യുക
//        try {
//            String logoPath = "images/vph_logo.png";
//            Image logo = Toolkit.getDefaultToolkit().getImage(logoPath);
//            if (logo != null) {
//                g2.drawImage(logo, x, y - 20, 80, 80, null);
//            }
//        } catch (Exception ex) {
//            System.out.println("⚠️ Logo not loaded: " + ex.getMessage());
//        }
//
//        // 🏢 Firm name & Address
//        g2.setFont(new Font("Times New Roman", Font.BOLD, 16));
//        g2.drawString("VISHNU PRINT HOUSE", x + 200, y);
//        g2.setFont(new Font("Times New Roman", Font.PLAIN, 10));
//        g2.drawString("Opp: PetrolPump, Koyyamarakkad,", x + 200, y + 15);
//        g2.drawString("Kanjikode, Palakkad - 678621", x + 200, y + 30);
//        g2.drawString("Phone: +91 8547706377, 9809414537", x + 200, y + 45);
//        g2.drawString("Email: vishnuprinthouse101@gmail.com", x + 200, y + 60);
//        g2.drawString("Website: vishnuprinthouse.unaux.com", x + 200, y + 75);
//
//        y += 100;
//        g2.setFont(new Font("Times New Roman", Font.BOLD, 14));
//        g2.drawString("INVOICE", pageWidth / 2 - 30, y);
//        y += 15;
//
//        g2.drawLine(x, y, pageWidth - 40, y);
//        y += 20;
//
//        // Invoice details
//        g2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
//        g2.drawString("Invoice No: " + lblInvoiceNo.getText(), x, y);
//        g2.drawString("Date: " + txtdate.getText(), pageWidth - 200, y);
//        y += 20;
//        g2.drawString("Customer Name: " + cusumername.getText(), x, y);
//        y += 20;
//        g2.drawString("Address: " + customeraddress.getText(), x, y);
//        y += 20;
//        g2.drawString("PO No: " + txtpo.getText(), x, y);
//        y += 15;
//        g2.drawLine(x, y, pageWidth - 40, y);
//        y += 25;
//
//        // Table Header
//        g2.setFont(new Font("Times New Roman", Font.BOLD, 12));
//        g2.drawString("Sl No", x, y);
//        g2.drawString("Particular", x + 60, y);
//        g2.drawString("Qty", x + 300, y);
//        g2.drawString("Rate", x + 370, y);
//        g2.drawString("Total", x + 450, y);
//        y += 10;
//        g2.drawLine(x, y, pageWidth - 40, y);
//        y += 20;
//
//        // Table Data
//        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
//        g2.setFont(new Font("Times New Roman", Font.PLAIN, 11));
//
//        double grandTotal = 0.0;
//        for (int i = 0; i < model.getRowCount(); i++) {
//            g2.drawString(String.valueOf(model.getValueAt(i, 0)), x, y);
//            g2.drawString(String.valueOf(model.getValueAt(i, 1)), x + 60, y);
//            g2.drawString(String.valueOf(model.getValueAt(i, 2)), x + 300, y);
//            g2.drawString(String.valueOf(model.getValueAt(i, 3)), x + 370, y);
//            g2.drawString(String.valueOf(model.getValueAt(i, 4)), x + 450, y);
//            y += 20;
//
//            try {
//                grandTotal += Double.parseDouble(model.getValueAt(i, 4).toString());
//            } catch (Exception e) {
//                // ignore parse errors
//            }
//        }
//
//        y += 10;
//        g2.drawLine(x, y, pageWidth - 40, y);
//        y += 20;
//
//        g2.setFont(new Font("Times New Roman", Font.BOLD, 12));
//        g2.drawString("Grand Total: Rs. " + String.format("%.2f", grandTotal), x + 370, y);
//        y += 25;
//
//        // Amount in words
//        g2.setFont(new Font("Times New Roman", Font.PLAIN, 11));
//        g2.drawString("Amount in Words: Rupees " + convertToWords((int) grandTotal) + " Only", x, y);
//        y += 40;
//
//        // Bank details & signature
//        g2.setFont(new Font("Times New Roman", Font.PLAIN, 10));
//        g2.drawString("Bank Details:", x, y);
//        g2.drawString("Bank: Indian Overseas Bank", x, y + 15);
//        g2.drawString("Branch: Kanjikode", x, y + 30);
//        g2.drawString("A/c No: 035702000000155", x, y + 45);
//        g2.drawString("IFSC: IOBA0000357", x, y + 60);
//
//        g2.setFont(new Font("Times New Roman", Font.BOLD, 12));
//        g2.drawString("For Vishnu Print House", pageWidth - 200, y + 60);
//        g2.drawString("Authorised Signature", pageWidth - 180, y + 100);
//
//        g2.drawRect(x, 20, (int) (pageWidth - 80), (int) (y + 100)); // border
//
//        return PAGE_EXISTS;
//    }
}   
   


//

