/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zoro2723.zipextractor;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author zoro2723
 */
public class Zip_Class {

    private BookmarkHandeler bookmark;
    private String EXTRACTION_PATH = "/home/zoro2723/Pictures/tempImg";
    private ZipFile zipfile;
    private File selectedFile;
    private JList list;
    private JLabel imageLable;
    private FileInputStream fis;
    private DefaultListModel<String> list_model;

    Zip_Class(File selectedFile, JList list) {
        this.selectedFile = selectedFile;
        this.list = list;
        this.list.setModel(new DefaultListModel<String>());
        this.list_model = (DefaultListModel< String>) list.getModel();
        this.list.addMouseListener(this.mouseListener);
        new File(this.EXTRACTION_PATH).mkdirs();
        try {
            this.zipfile = new ZipFile(this.selectedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void extractZipEntry(String selectedFile) {

        ZipEntry ze = this.zipfile.getEntry(selectedFile);
        try (InputStream is = new BufferedInputStream(this.zipfile.getInputStream(ze))) {
            byte[] buffer = new byte[1024];
            File newFile = new File(EXTRACTION_PATH + File.separator + selectedFile);
            new File(newFile.getParent()).mkdirs();
            FileOutputStream fos = new FileOutputStream(newFile);
            int len;
            while ((len = is.read(buffer, 0, 1024)) != -1) {
                fos.write(buffer, 0, len);
            }
            fos.flush();
            fos.close();
            is.close();
            System.out.println("Extraction complete");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public MouseListener mouseListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 1) {
                String selectedItem = (String) getList().getSelectedValue();

//              if file is already extracted does not extract again.
                if (!fileExists(selectedItem)) {
                    extractZipEntry(selectedItem);
                }

                String imagePath = EXTRACTION_PATH + File.separator + selectedItem;
                setImage(imagePath);

            }
        }
    };

    public void refreshImage() {
        String selectedItem = (String) getList().getSelectedValue();
        if (!fileExists(selectedItem)) {
            extractZipEntry(selectedItem);
        }
        String imagePath = EXTRACTION_PATH + File.separator + selectedItem;
        //System.out.println(imagePath);
        setImage(imagePath);
    }

    public BufferedImage getImage(String imagePath) {
        try {
            BufferedImage bi = ImageIO.read(new File(imagePath));
            return bi;
        } catch (IOException ex) {
            System.out.println("BufferedImage getImage: Image not found");
        }
        return null;
    }

//  This function is for already extracted images.    
    public void setImage(String imagePath) {
//      Show filepath in console for testing.
        System.out.println(imagePath);

        BufferedImage buff_img = getImage(imagePath);
        if (buff_img == null) {
            System.out.println("no image set");
        } else {
            float adjustment;
            int imgWidth = buff_img.getWidth();
            int imgHeigth = buff_img.getHeight();
            JLabel imgLable = getImageLable();
            
            if (imgWidth > imgHeigth) {
                adjustment = 1 / (imgWidth / (float) (imgLable.getWidth()- 20));
            } else {
                adjustment = 1 / (imgHeigth / (float) (imgLable.getHeight() - 20));
            }

            imgLable.setIcon(new ImageIcon(buff_img.getScaledInstance((int) (imgWidth * adjustment), (int) (imgHeigth * adjustment), Image.SCALE_SMOOTH)));
            System.gc();
        }
    }

    private ZipInputStream getZipInputStream(File selectedFile) {
        try {
            this.fis = new FileInputStream(selectedFile);
            return (new ZipInputStream(fis));
        } catch (IOException ex) {
            System.out.println("ZipInputStream getZipInputStream: no zipinputstream");
        }
        return null;
    }

    private void closeFileInputStream() {
        try {
            this.fis.close();
            this.fis = null;
        } catch (IOException e) {

        }
    }

    public void readZip() {

        try (ZipInputStream zis = getZipInputStream(this.selectedFile)) {
            ZipEntry ze;
            while ((ze = zis.getNextEntry()) != null) {
                appendItemToList(ze.getName());
            }
        } catch (IOException ex) {
            System.out.print("Some Error!!");
        } finally {
            //Because at this point it only adds item name to the list not extracts it.
            closeFileInputStream();
        }

    }

    public void makeBookmarkedZip() {
        byte[] buffer = new byte[1024];
        ZipEntry read_ze, write_ze;
        File newFile = new File(EXTRACTION_PATH + File.separator + "bookmarked_" + this.selectedFile.getName());
        new File(newFile.getParent()).mkdirs();
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(newFile);
            ZipOutputStream zos = new ZipOutputStream(fos);
            ArrayList<String> list = bookmark.getBookmark();
            for (int i = 0; i < list.size(); i++) {
                read_ze = this.zipfile.getEntry(list.get(i));
                InputStream is = new BufferedInputStream(this.zipfile.getInputStream(read_ze));

                write_ze = new ZipEntry(list.get(i));
                zos.putNextEntry(write_ze);

                int len;
                while ((len = is.read(buffer, 0, 1024)) != -1) {
                    zos.write(buffer, 0, len);
                }
                //zos.flush();
                zos.closeEntry();
                is.close();

            }
            zos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Zip_Class.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Zip_Class.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void extract(String destination) {
        String zipFilePath = this.selectedFile.getAbsolutePath();
        try {
            byte[] buffer = new byte[1024];
            ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath));
            ZipEntry zipEntry = zis.getNextEntry();

            while (zipEntry != null) {
                File newFile = new File(destination + File.separator + zipEntry.getName());

//              For making the file directory if not avalable
                new File(newFile.getParent()).mkdirs();

                FileOutputStream fos = new FileOutputStream(newFile);

                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }

                fos.close();
                zipEntry = zis.getNextEntry();

            }

            zis.closeEntry();
            zis.close();

            System.out.println("Extraction completed successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BookmarkHandeler getBookmark() {
        return bookmark;
    }

    public void setBookmark(BookmarkHandeler bookmark) {
        this.bookmark = bookmark;
    }

    public String getEXTRACTION_PATH() {
        return EXTRACTION_PATH;
    }

    public void setEXTRACTION_PATH(String EXTRACTION_PATH) {
        this.EXTRACTION_PATH = EXTRACTION_PATH;
    }

    public DefaultListModel<String> getList_model() {
        return list_model;
    }

    public void setList_model(DefaultListModel<String> list_model) {
        this.list_model = list_model;
    }

    public JLabel getImageLable() {
        return imageLable;
    }

    public void setImageLable(JLabel imageLable) {
        this.imageLable = imageLable;
    }

    public File getSelectedFile() {
        return this.selectedFile;
    }

    public void setSelectedFile(File selectedFile) {
        this.selectedFile = selectedFile;
    }

    public JList getList() {
        return list;
    }

    public void setList(JList list) {
        this.list = list;
    }

    public boolean fileExists(String fileName) {
        return new File(EXTRACTION_PATH + File.separator + fileName).exists();
    }

    private void clearList() {
        this.list_model.clear();
    }

    private void appendItemToList(String item) {
        this.list_model.addElement(item);
    }

}
