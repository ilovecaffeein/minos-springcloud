package com.caxs.minos.files;

import com.caxs.minos.def.MinosConst;
import com.caxs.minos.exception.MinosException;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
/**
 * @ClassName: CoreFileReader
 * @Description: 核心文件读取器
 * @Author: coffee
 * @Date: 2020/8/13 15:10
 * @Version: v1.0 文件初始创建
 */
public class CoreFileReader {
    /**
     * 列分隔符
     */
    protected String columnSeparator = MinosConst.COLUMN_SEPERATOR;
    /**
     * 列数据，0，对于0列
     * */
    protected String[] columnsData = null;

    protected BufferedReader reader;

    public String getColumnSeparator() {
        return columnSeparator;
    }

    public void setColumnSeparator(String columnSeparator) {
        this.columnSeparator = columnSeparator;
    }

    public BufferedReader getReader() {
        return reader;
    }

    public String[] getColumnLineData() {
        return columnsData;
    }

    public CoreFileReader(BufferedReader reader) {
        super();
        // 设置默认分隔符
        this.columnSeparator = MinosConst.COLUMN_SEPERATOR;
        this.reader = reader;
    }

    public CoreFileReader(BufferedReader reader, String columnSeparator) {
        super();
        this.columnSeparator = columnSeparator;
        this.reader = reader;
    }

    /**
     * 获取文件的读取器
     *
     * @param path
     * @param fileName
     * @return
     */
    public static BufferedReader newFileReader(String path, String fileName) {
        File file = new File(path, fileName);
        try {
            return new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), MinosConst.FILE_CHARUTF_8));
        } catch (FileNotFoundException e) {
            throw new MinosException("file " + file.getPath() + "not found", e);
        } catch (UnsupportedEncodingException e) {
            throw new MinosException("unsupported charset", e);
        }

    }

    /**
     * 如果文件读出有内容，返回真 否则返回假
     * @return
     */
    public boolean readLine() {
        String lineData;
        String[] columnsDataTemp;
        try {
            lineData = this.reader.readLine();
            if (StringUtils.hasText(lineData)) {
                columnsData = split(lineData, this.columnSeparator);
                columnsDataTemp = new String[columnsData.length + 1];
                System.arraycopy(columnsData, 0, columnsDataTemp, 0, columnsData.length);
                columnsDataTemp[columnsDataTemp.length - 1] = "";
                columnsData = columnsDataTemp;
            }
        } catch (IOException e) {
            throw new MinosException("file read error");
        }
        return StringUtils.hasText(lineData);// 修订最后一行重复读的Bug，edited by
    }

    /**
     * 按照|分隔符裂开字符串。java的默认split不适合本项目。
     *
     * @param str
     * @param sep
     * @return
     */
    protected String[] split(String str, char sep) {
        if (str == null) {
            return new String[0];
        }
        Queue<String> q = new LinkedList<String>();
        StringBuilder strB = new StringBuilder(str.length());
        for (char c : str.toCharArray()) {
            if (c == sep) {
                q.add(strB.toString());
                strB.setLength(0);
            } else {
                strB.append(c);
            }
        }
        q.add(strB.toString());
        return q.toArray(new String[0]);
    }

    /**
     * 按照|分隔符裂开字符串。java的默认split不适合本项目。
     *
     * @param str
     * @param sep
     * @return
     */
    protected String[] split(String str, String sep) {
        if (str == null) {
            return new String[0];
        }
        int sepLength = sep.length();
        boolean sepGreatOne = sepLength > 1;
        Queue<String> q = new LinkedList<String>();
        StringBuilder strB = new StringBuilder(str.length());
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length;) {
            char c = charArray[i];
            boolean isSplitStr = false;
            if (c == sep.charAt(0)) {
                if (sepGreatOne) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = i, sepMax = j + sepLength; j < sepMax; j++) {
                        sb.append(charArray[j]);
                    }
                    if (sb.toString().equals(sep)) {
                        isSplitStr = true;
                    }
                } else {
                    isSplitStr = true;
                }
            }
            if (isSplitStr) {
                i += sepLength;
                q.add(strB.toString());
                strB.setLength(0);
                continue;
            }
            i++;
            strB.append(c);
        }
        q.add(strB.toString());
        return q.toArray(new String[0]);
    }
}
