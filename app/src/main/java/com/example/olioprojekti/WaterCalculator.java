package com.example.olioprojekti;

import android.view.View;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WaterCalculator {
    String wtrFilename;

    public void WaterCalculator() {

    }

    public void fileSave(View view) {
        String text = "Hello World";
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(wtrFilename, MODE_PRIVATE);
            fos.write(text.getBytes());
            etInputOutput.getText().clear();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
