package ui;

import com.impinj.octane.ImpinjReader;
import com.impinj.octane.OctaneSdkException;
import com.impinj.octane.Tag;
import interact.TagActionHelper;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TestFrame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public TagActionHelper actionHelper;
    private JPanel contentPane;
    private JTable table;
    boolean isStop = false;
    ImpinjReader reader;
    ArrayList<Tag> arr;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TestFrame frame = new TestFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public TestFrame() {
        arr = new ArrayList<>();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 632, 499);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JButton btnNewButton = new JButton("Start");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton.gridx = 0;
        gbc_btnNewButton.gridy = 0;
        contentPane.add(btnNewButton, gbc_btnNewButton);

        JButton btnNewButton_1 = new JButton("Stop");
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton_1.gridx = 15;
        gbc_btnNewButton_1.gridy = 0;
        contentPane.add(btnNewButton_1, gbc_btnNewButton_1);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.gridwidth = 16;
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 1;
        contentPane.add(panel, gbc_panel);

        table = new JTable(0, 3);
        table.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Field 1");
        table.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Field 2");
        table.getTableHeader().getColumnModel().getColumn(2).setHeaderValue("Field 3");
        table.setBounds(0, 0, 1, 1);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 606, 420);
        panel.add(scrollPane);

        btnNewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                actionHelper = new TagActionHelper();
                reader = actionHelper.startScan();
                new Thread(new Runnable() {
                    int i = 0;

                    @Override
                    public void run() {
                        String[] arrStr = new String[3];
                        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                        isStop = false;
                        while (!isStop) {

                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    int size = actionHelper.getReportListenerForList().getListEPC().size();
                                    if (size != i) {
                                        arr = new ArrayList<>(actionHelper.getReportListenerForList().getTagMap().values());
                                        for (; i < size; i++) {
                                            arrStr[0] = String.valueOf(arr.get(i).getEpc().toString());
                                            arrStr[1] = String.valueOf(arr.get(i).getLastSeenTime());
                                            arrStr[2] = String.valueOf(arr.get(i).getFirstSeenTime());
                                            tableModel.addRow(arrStr);
                                        }
                                        table.revalidate();
                                        table.repaint();
                                    }
                                }
                            });
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }

                        }

                    }
                }).start();
            }
        });

        btnNewButton_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    isStop = true;
                    reader.stop();
                } catch (OctaneSdkException ex) {
                    Logger.getLogger(TestFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
