/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zoro2723.zipextractor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author zoro2723
 */
public class BookmarkHandeler {

    private Zip_Class myZip;
    private JList bookmarkList;
    private ArrayList<String> bookmark;
    private DefaultListModel<String> bookmarkListModel;

//  For when clicking on a bookmark
    private MouseListener bookmark_mouseListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 1) {
                String filename = (String) getBookmarkList().getSelectedValue();
                String imagePath = getMyZip().getEXTRACTION_PATH() + File.separator + filename;
                getMyZip().setImage(imagePath);
            }
        }
    };

//      If bookmarked, it mean the extracted copy of image is present in the extraction 
//      path so file is always available.
    public void refreshImage() {
        
        String filename = (String) getBookmarkList().getSelectedValue();
        String imagePath = getMyZip().getEXTRACTION_PATH() + File.separator + filename;
        getMyZip().setImage(imagePath);
        
    }

    public JList getBookmarkList() {
        return bookmarkList;
    }

    public void setBookmarkList(JList bookmarkList) {
        this.bookmarkList = bookmarkList;
    }

    public Zip_Class getMyZip() {
        return myZip;
    }

    public MouseListener getBookmark_mouseListener() {
        return bookmark_mouseListener;
    }

    public void setMyZip(Zip_Class myZip) {
        this.myZip = myZip;
    }

    public ArrayList<String> getBookmark() {
        return bookmark;
    }

    public void setBookmark(ArrayList<String> bookmark) {
        this.bookmark = bookmark;
    }

    public DefaultListModel<String> getBookmarkListModel() {
        return bookmarkListModel;
    }

    public void setBookmarkListModel(DefaultListModel<String> bookmarkListModel) {
        this.bookmarkListModel = bookmarkListModel;
    }

    public BookmarkHandeler() {
        bookmark = new ArrayList<>();
    }

    public boolean isAdded(String value) {
        return bookmark.contains(value);
    }

    public void addBookmark(String bmk) {
        bookmark.add(bmk);
    }

    public boolean removeBookmark(String bmk) {
        return bookmark.remove(bmk);
    }

    public void cleanBookmark() {
        bookmark.clear();
    }
}
