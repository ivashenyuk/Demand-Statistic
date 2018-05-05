import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Main {

    private static JTable table1;
    private static JButton nextBtn;
    private static JButton backBtn;
    private static ArrayList<DataProduct> productList;
    private static int pageProducts = 0;
    private static JPanel panel1;
    private static int countElementsOnPage = 25;

    public static void main(String[] args) {
        productList = new GetData().getProductList();

        MainWindow mainWindow = new MainWindow();
        table1 = mainWindow.getTable1();
        nextBtn = mainWindow.getNextBtn();
        backBtn = mainWindow.getBackBtn();
        panel1 = mainWindow.getPanel1();
        CreatElement();
        mainWindow.show();
    }

    public static void CreatElement() {
        if (pageProducts + countElementsOnPage >= productList.size())
            nextBtn.setEnabled(false);
        else
            nextBtn.setEnabled(true);
        if (pageProducts - countElementsOnPage <= productList.size())
            backBtn.setEnabled(false);
        else
            backBtn.setEnabled(true);
        nextBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!nextBtn.isEnabled())
                    return;
                if (pageProducts + countElementsOnPage <= productList.size()) {
                    pageProducts += countElementsOnPage;
                    System.out.println("+");
                    AddRows();
                }
                backBtn.setEnabled(true);
                if (pageProducts + countElementsOnPage >= productList.size())
                    nextBtn.setEnabled(false);
                else
                    nextBtn.setEnabled(true);
            }
        });

        backBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!backBtn.isEnabled())
                    return;
                if (pageProducts - countElementsOnPage >= 0) {
                    pageProducts -= countElementsOnPage;
                    System.out.println("-");
                    AddRows();
                }
                nextBtn.setEnabled(true);
                if (pageProducts+25 - countElementsOnPage <= 0)
                    backBtn.setEnabled(false);
                else
                    backBtn.setEnabled(true);
            }
        });

        AddRows();
    }

    private static void AddRows() {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        int countRows = model.getRowCount();
        for (int i = 0; i < countRows; i++) {
            model.removeRow(0);
        }
        try {
            for (int i = pageProducts; i < pageProducts + countElementsOnPage; i++) {
                if (productList.get(i) == null)
                    break;
                DataProduct product = productList.get(i);
                model.addRow(new Object[]{product.get_id(), product.get_name(), product.get_purchasePrice(),
                        product.get_sellingPrice(), product.get_availability(), product.get_soldForAMonth(),
                        (product.get_difference() + "%")});
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void setProductList(ArrayList<DataProduct> productList) {
        Main.productList = productList;
    }
}
