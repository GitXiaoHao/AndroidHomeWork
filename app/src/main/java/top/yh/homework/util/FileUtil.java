package top.yh.homework.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * @user
 * @date
 */
public class FileUtil {
    public static String readToSd(String path, String name) {

        InputStream inputStream = null;
        Reader reader = null;
        BufferedReader bufferedReader = null;
        try {
            File storage = new File(path);
            if (!storage.exists()) {
                return "";
            }
            File file = new File(storage, name);
            if (!file.exists()) {
                return "";
            }
            inputStream = Files.newInputStream(file.toPath());
            reader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(reader);
            StringBuilder result = new StringBuilder();
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                result.append(temp);
            }
            String value = decodeToString(result.toString());
            Log.i("swyLog", "upload 密文：" + result);
            Log.i("swyLog", "upload 明文：" + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }

    /**
     * 写入文件方法
     *
     * @param content
     */
    public static void writeToSd(String path, String mode, String content) {
        if (StringUtil.isEmpty(content)) {
            return;
        }
        Log.i("swyLog", "saveLoginAccount called");
        String value = encodeToString(content);
        Log.i("swyLog", "save 明文：" + content);
        Log.i("swyLog", "save 密文：" + value);
        File storage = new File(path);
        if (!storage.exists()) {
            storage.mkdirs();
        }
        File tmepfile = new File(storage.getPath());
        if (!tmepfile.exists()) {
            tmepfile.mkdirs();
        }
        File file = new File(tmepfile, mode);
        if (file.exists()) {
            Log.i("swyLog", "删除原有文件");
            file.delete();
        }
        if (!file.exists()) {
            Log.i("swyLog", "文件删除成功");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(value.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 把字符串保存到指定路径的文本文件
     *
     * @param path
     */
    public static void saveText(String path, String txt) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(path));
            bw.write(txt);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 从指定路径读取文件
     *
     * @param path
     */
    public static String openText(String path) {
        BufferedReader br = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            br = new BufferedReader(new FileReader(path));
            String line = null;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 把位图数据保存到指定路径的图片文件中
     *
     * @param path
     * @param bitmap
     */
    public static void saveImage(String path, Bitmap bitmap) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
        } catch (Exception e) {
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

    /**
     * 从指定路径的图片文件中读取位图数据
     *
     * @param path
     * @return
     */
    public static Bitmap openImage(String path) {
        Bitmap bitmap = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            bitmap = BitmapFactory.decodeStream(fis);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bitmap;
    }

    /**
     * 字符Base64加密
     *
     * @param str
     * @return
     */
    public static String encodeToString(String str) {
        return Base64.encodeToString(str.getBytes(StandardCharsets.UTF_8), Base64.DEFAULT);
    }

    /**
     * 字符Base64解密
     *
     * @param str
     * @return
     */
    public static String decodeToString(String str) {
        return new String(Base64.decode(str.getBytes(StandardCharsets.UTF_8), Base64.DEFAULT));
    }
}
