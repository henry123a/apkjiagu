package com.zhh.jiagu.shell.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessUtil {

    public static void main(String[] args) throws Exception {
        Process process = Runtime.getRuntime().exec("ls");
    }

    /**
     * 执行命令
     */
    public static boolean executeCommand(String cmd) throws Exception {
        System.out.println("开始执行命令===>" + cmd);
        Process process = Runtime.getRuntime().exec("" + cmd);
        ProcessUtil.consumeInputStream(process.getInputStream());
        ProcessUtil.consumeInputStream(process.getErrorStream());
        process.waitFor();
        if (process.exitValue() != 0) {
            String info = getInfo(process);
            System.err.println("错误：" + info);
            throw new RuntimeException("执行命令错误===>" + cmd);
        }

        return true;
    }

    private static String getInfo(Process process) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        bufferedReader.close();
        return sb.toString();
    }


    /**
     * 消费inputstream，并返回
     */
    public static void consumeInputStream(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String s;
//        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine()) != null) {
            System.out.println(s);
//            sb.append(s);
        }
    }
}
