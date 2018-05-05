import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Tue May 01 11:39:57 EEST 2018
 */



/**
 * @author Ivashenuik Yurii
 */
public class MainWindow extends JFrame {
    public MainWindow() {
        initComponents();
        initAction();
    }

    private void initAction() {
        this.exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.reflesh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.setProductList(new GetData().getProductList());
                Main.CreatElement();

            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ivashenuik Yurii
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        reflesh = new JMenuItem();
        exit = new JMenuItem();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel2 = new JPanel();
        nextBtn = new JButton();
        backBtn = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("\u0421\u0442\u0430\u0442\u0438\u043a\u0430 \u043f\u043e\u043f\u0438\u0442\u0443");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u0424\u0430\u0439\u043b");

                //---- reflesh ----
                reflesh.setText("\u041e\u0431\u043d\u043e\u0432\u0438\u0442\u0438 \u0441\u043f\u0438\u0441\u043e\u043a \u0442\u043e\u0432\u0430\u0440\u0456\u0432");
                menu1.add(reflesh);

                //---- exit ----
                exit.setText("\u0412\u0438\u0445\u0456\u0434");
                menu1.add(exit);
            }
            menuBar1.add(menu1);
        }
        setJMenuBar(menuBar1);

        //======== panel1 ========
        {

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel1.setLayout(new BorderLayout());

            //======== scrollPane1 ========
            {

                //---- table1 ----
                table1.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "ID \u0442\u043e\u0432\u0430\u0440\u0443", "\u041d\u0430\u0437\u0432\u0430 \u0442\u043e\u0432\u0430\u0440\u0443", "\u0426\u0456\u043d\u0430 \u0437\u0430\u043a\u0443\u043f\u0456\u0432\u043b\u0456", "\u0426\u0456\u043d\u0430 \u043f\u0440\u043e\u0434\u0430\u0436\u0443", "\u0412 \u043d\u0430\u044f\u0432\u043d\u043e\u0441\u0442\u0456 (\u043a\u0456\u043b\u044c\u043a\u0456\u0441\u0442\u044c)", "\u041f\u0440\u043e\u0434\u0430\u043d\u043e \u0437\u0430 \u043c\u0456\u0441\u044f\u0446\u044c", "\u0420\u0456\u0437\u043d\u0438\u0446\u044f \u043f\u0440\u043e\u0434\u0430\u0436 \u0437\u0430 \u0434\u0432\u0430 \u043c\u0456\u0441\u044f\u0446\u0456 (%)"
                    }
                ) {
                    Class<?>[] columnTypes = new Class<?>[] {
                        Integer.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class
                    };
                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        return columnTypes[columnIndex];
                    }
                });
                table1.setAutoCreateRowSorter(true);
                scrollPane1.setViewportView(table1);
            }
            panel1.add(scrollPane1, BorderLayout.CENTER);

            //======== panel2 ========
            {
                panel2.setPreferredSize(new Dimension(963, 50));

                //---- nextBtn ----
                nextBtn.setText("\u0414\u0430\u043b\u0456");

                //---- backBtn ----
                backBtn.setText("\u041d\u0430\u0437\u0430\u0434");

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap(661, Short.MAX_VALUE)
                            .addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(nextBtn, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(nextBtn, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addComponent(backBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap())
                );
            }
            panel1.add(panel2, BorderLayout.SOUTH);
        }
        contentPane.add(panel1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ivashenuik Yurii
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem reflesh;
    private JMenuItem exit;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel2;
    private JButton nextBtn;
    private JButton backBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public JTable getTable1() {
        return table1;
    }

    public JButton getNextBtn() {
        return nextBtn;
    }

    public JButton getBackBtn() {
        return backBtn;
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
