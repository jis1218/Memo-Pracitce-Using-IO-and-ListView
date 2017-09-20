package com.example.insupmemo.util;

import android.content.Context;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by 정인섭 on 2017-09-20.
 */

public class FileReadWrite {

    public static void write(Context context, String fileName, String content) throws IOException {
        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            fos.write(content.getBytes());
        } catch (Exception e) {
            throw e;
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e) {
                    throw e;
                }
            }
        }

    }

    public static String read(Context context, String fileName) throws IOException {

        FileInputStream fis = null;
        BufferedInputStream bis = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            fis = context.openFileInput(fileName);
            bis = new BufferedInputStream(fis);
            byte[] byteContainer = new byte[1000];
            int count = 0;
            while ((count = bis.read(byteContainer)) != -1) {
                String str = new String(byteContainer, 0, count);
                stringBuilder.append(str);
            }

        } catch (IOException e) {
            throw e;
        } finally {
            if (bis != null) {
                bis.close();
            }
            if (fis != null) {
                fis.close();
            }
        }

        return stringBuilder.toString();

    }

}
