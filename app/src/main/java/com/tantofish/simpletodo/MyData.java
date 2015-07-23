package com.tantofish.simpletodo;

import android.content.Context;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by yutu on 7/23/15.
 */
public class MyData {
    File filesDir;
    File todoFile;

    public MyData(Context context){
        this.filesDir = context.getFilesDir();
        this.todoFile = new File(filesDir, "todo.txt");
    }

    public ArrayList<String> readItems() {
        ArrayList<String> items;
        try {
            items = new ArrayList<String>(FileUtils.readLines(todoFile));
        } catch (IOException e) {
            items = new ArrayList<String>();
        }
        return items;
    }

    public void writeItems(ArrayList<String> items) {
        try {
            FileUtils.writeLines(todoFile, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
