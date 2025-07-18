/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.zoro2723.zipextractor;

import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author zoro2723
 */
public class MainFranme extends javax.swing.JFrame {
    
    private MyKeyAdapter keyAdapter;
    private BookmarkHandeler bookmark;
    private Zip_Class myZip;
    private File extractionLocation;

    /**
     * Creates new form MainFranme
     */
    public MainFranme() {
        bookmark = new BookmarkHandeler();
        initComponents();
        bookmarkList.setModel(new DefaultListModel<String>());
        this.bookmarkList.addMouseListener(bookmark.getBookmark_mouseListener());
        keyAdapter = new MyKeyAdapter(bookmark);
        this.bookmarkList.addKeyListener(keyAdapter);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        zipContentList = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        bookmarkList = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        imgLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        open = new javax.swing.JMenuItem();
        extract = new javax.swing.JMenuItem();
        location = new javax.swing.JMenuItem();
        extractBookmarked = new javax.swing.JMenuItem();
        viewMenu = new javax.swing.JMenu();
        bkmark = new javax.swing.JMenuItem();
        next = new javax.swing.JMenuItem();
        previous = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(200, 400));

        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        zipContentList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(zipContentList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Zip Content", jPanel2);

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        bookmarkList.setModel(new DefaultListModel<String>());
        bookmarkList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(bookmarkList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Bookmark", jPanel1);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.WEST);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Image View"));

        imgLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgLabel.setMaximumSize(new java.awt.Dimension(1200, 900));
        jScrollPane2.setViewportView(imgLabel);
        imgLabel.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        open.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        open.setText("Open");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        fileMenu.add(open);
        open.getAccessibleContext().setAccessibleDescription("Open a zip file containing images");

        extract.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        extract.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        extract.setText("Extract");
        extract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extractActionPerformed(evt);
            }
        });
        fileMenu.add(extract);
        extract.getAccessibleContext().setAccessibleDescription("Extract all the files");

        location.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        location.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        location.setLabel("Change Location");
        location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationActionPerformed(evt);
            }
        });
        fileMenu.add(location);
        location.getAccessibleContext().setAccessibleDescription("Use to change extract location");

        extractBookmarked.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        extractBookmarked.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        extractBookmarked.setText("Extract Bookmarked");
        extractBookmarked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extractBookmarkedActionPerformed(evt);
            }
        });
        fileMenu.add(extractBookmarked);
        extractBookmarked.getAccessibleContext().setAccessibleDescription("Extracts Bookmarked Item");

        jMenuBar1.add(fileMenu);

        viewMenu.setMnemonic('v');
        viewMenu.setText("View");

        bkmark.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, 0));
        bkmark.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        bkmark.setText("Bookmark");
        bkmark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkmarkActionPerformed(evt);
            }
        });
        bkmark.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bkmarkKeyPressed(evt);
            }
        });
        viewMenu.add(bkmark);
        bkmark.getAccessibleContext().setAccessibleDescription("Make Bookmark");

        next.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, 0));
        next.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });
        viewMenu.add(next);
        next.getAccessibleContext().setAccessibleName("next");
        next.getAccessibleContext().setAccessibleDescription("Show Next");

        previous.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, 0));
        previous.setFont(new java.awt.Font("Noto Sans", 0, 15)); // NOI18N
        previous.setText("Previous");
        previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousActionPerformed(evt);
            }
        });
        viewMenu.add(previous);
        previous.getAccessibleContext().setAccessibleDescription("Show Previous");

        jMenuBar1.add(viewMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");
        jMenuBar1.add(editMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            myZip = null;
            myZip = new Zip_Class(fc.getSelectedFile(), this.zipContentList);
            myZip.readZip();
            myZip.setImageLable(imgLabel);
            myZip.setBookmark(this.bookmark);
            this.bookmark.setMyZip(this.myZip);
            
            bookmark.setBookmarkListModel((DefaultListModel<String>) bookmarkList.getModel());
            this.bookmark.setBookmarkList(this.bookmarkList);
        }
    }//GEN-LAST:event_openActionPerformed

    private void extractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extractActionPerformed
        if (myZip == null) {
            JOptionPane.showMessageDialog(this, "Open a file first", "NO FILE ERROR!!", JOptionPane.ERROR_MESSAGE);
        } else {
            // myZip.extract(DEFAULT_EXTRACT_PATH);
            myZip.extract(myZip.getEXTRACTION_PATH());
        }
    }//GEN-LAST:event_extractActionPerformed

    private void locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationActionPerformed
        JFileChooser folderChoose = new JFileChooser();
        folderChoose.setDialogTitle("Extract File Location");
        folderChoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = folderChoose.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            extractionLocation = folderChoose.getSelectedFile();
            myZip.setEXTRACTION_PATH(extractionLocation.getAbsolutePath());
        }
    }//GEN-LAST:event_locationActionPerformed

    private void bkmarkKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bkmarkKeyPressed

    }//GEN-LAST:event_bkmarkKeyPressed

    private void bkmarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkmarkActionPerformed
        String value = zipContentList.getSelectedValue();
        if (!bookmark.isAdded(value)) {
            bookmark.addBookmark(value);
            ((DefaultListModel<String>) bookmarkList.getModel()).addElement(value);
        }
    }//GEN-LAST:event_bkmarkActionPerformed

    private void previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousActionPerformed
        int i = getZipContentList().getSelectedIndex();
        if (i != -1) {
            getZipContentList().setSelectedIndex(--i);
            myZip.refreshImage();
        }
    }//GEN-LAST:event_previousActionPerformed
    
    public JList<String> getZipContentList() {
        return zipContentList;
    }
    
    public void setZipContentList(JList<String> zipContentList) {
        this.zipContentList = zipContentList;
    }

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        int size = myZip.getList_model().getSize();
        int i = getZipContentList().getSelectedIndex();
        if (i < size) {
            System.out.println(size);
            getZipContentList().setSelectedIndex(++i);
            myZip.refreshImage();
        }
    }//GEN-LAST:event_nextActionPerformed

    private void extractBookmarkedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extractBookmarkedActionPerformed
        myZip.makeBookmarkedZip();
    }//GEN-LAST:event_extractBookmarkedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem bkmark;
    private javax.swing.JList<String> bookmarkList;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem extract;
    private javax.swing.JMenuItem extractBookmarked;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem location;
    private javax.swing.JMenuItem next;
    private javax.swing.JMenuItem open;
    private javax.swing.JMenuItem previous;
    private javax.swing.JMenu viewMenu;
    private javax.swing.JList<String> zipContentList;
    // End of variables declaration//GEN-END:variables
}
