package com.example.android.toyvpn;
import java.io.*;
import java.util.zip.*;
/**
 * Created by 상헌 on 2016-05-29.
 */
public class myzip {
    static boolean logflag = true;     //테스트시 true


    private static void logwrite(String logMsg) {
        if (logflag) {
            try {
                System.out.println(logMsg);
                //WriteLogManager.infoLog(Define.DEBUG_LOG,"[GZip]:"+logMsg);
            } catch (Exception e) {
            }
        }
    }

    /**
     * GZIP을 이용하여 압축한다
     * 압축할 데이터
     *
     * @return 압축된 바이트 배열
     */
    public static byte[] compress(byte[] data) throws Exception {
        logwrite("compress(byte[]) called");

        try {
            logwrite("Compress Original DataSize:" + data.length);
            ByteArrayOutputStream baos = null;
            GZIPOutputStream gos = null;

            if (data == null) {
                data = "".getBytes();
            }
            baos = new ByteArrayOutputStream();
            gos = new GZIPOutputStream(baos);
            gos.write(data, 0, data.length);

            gos.finish();
            gos.close();
            baos.close();

            logwrite("After Compress DataSize:" + (baos.toByteArray()).length);
            return baos.toByteArray();
        } catch (IOException ioe) {
            throw new Exception("GZip Compress IO Exception:" + ioe.toString());
        }
    }

    /**
     * GZIP을 이용하여 압축해제한다
     *//* @param 압축된 데이터byte[]
     * @return 압축해제된 바이트 배열
     */
    public static byte[] decompress(byte[] data, int length) throws Exception {
        logwrite("decompress(byte[],int) called");
        logwrite("Before decompress ByteSize:" + data.length);
        logwrite("Input Param Data:" + length + "");
        try {
            ByteArrayInputStream bais = null;
            GZIPInputStream gis = null;
            DataInputStream dis = null;
            byte[] outputByteArray = null;

            if (data == null) {
                data = "".getBytes();
            }

            bais = new ByteArrayInputStream(data);
            gis = new GZIPInputStream(bais);
            dis = new DataInputStream(gis);
            outputByteArray = new byte[length];
            dis.readFully(outputByteArray);

            dis.close();
            gis.close();
            bais.close();

            logwrite("decompress Data Size:" + outputByteArray.length);

            return outputByteArray;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw new Exception("Gzip decompress Exception:" + ioe.toString());
        }
    }
}
