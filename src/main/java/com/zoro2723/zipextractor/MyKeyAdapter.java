/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zoro2723.zipextractor;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JList;

/**
 *
 * @author zoro2723
 */
public class MyKeyAdapter implements KeyListener {

    final static public int UP = 38;
    final static public int DOWN = 40;
//    final static public int LEFT = 226;
//    final static public int RIGHT = 227;

    protected BookmarkHandeler myBookmarkHandler;

    public MyKeyAdapter(BookmarkHandeler bk) {
        this.myBookmarkHandler = bk;

    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int i = myBookmarkHandler.getBookmarkList().getSelectedIndex();
        JList list = myBookmarkHandler.getBookmarkList();
        if (ke.getKeyCode() == UP) {
            if (i != -1) {
                --i;
                list.setSelectedIndex(i);

            }
        } else if (ke.getKeyCode() == DOWN) {
            int j = myBookmarkHandler.getBookmarkList().getLastVisibleIndex();
            if (i < j) {
                ++i;
                list.setSelectedIndex(i);

            }
        }
        myBookmarkHandler.refreshImage();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
