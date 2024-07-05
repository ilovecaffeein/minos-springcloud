package com.caxs.minos.files;

import com.caxs.minos.exception.MinosException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @ClassName: BaseFileReader
 * @Description: 文件解析工具类
 * @Author: coffee
 * @Date: 2020/8/13 15:10
 * @Version: v1.0 文件初始创建
 */
public abstract class BaseFileReader<E> implements Iterator<E> {
    protected CoreFileReader coreFileReader;
    protected boolean isReadline = false;
    protected boolean hasNext = false;

    /**
     * 组装返回的bean
     * @param columnsData
     */
    protected abstract E fillBean(String[] columnsData);
    public  E next() {
        if (!hasNext) {
            throw new NoSuchElementException("have not content");
        }
        isReadline = false;
        return fillBean(coreFileReader.getColumnLineData());
    }

    /**
     * @param directory 目录名可以不用指出最后的/或者\
     * @param fileName 文件的名称不包含路径
     */
    public BaseFileReader(String directory, String fileName) {
        this(CoreFileReader.newFileReader(directory, fileName));
    }

    public BaseFileReader(String directory, String fileName,String columnSeparator) {
        this(CoreFileReader.newFileReader(directory, fileName));
        this.coreFileReader.columnSeparator=columnSeparator;
    }

    public BaseFileReader(BufferedReader reader) {
        super();
        coreFileReader = new CoreFileReader(reader);
    }

    /**
     * 修改了final
     * */
    public boolean hasNext() {
        // 注意每执行一次，文件指针会移动
        if (!isReadline)
            hasNext = coreFileReader.readLine();
        isReadline = true;
        return hasNext;
    }

    /**
     * 移除
     * */
    public void remove() {
        throw new RuntimeException("have not this method");
    }

    /**
     * 关闭流
     * */
    public final void close() {
        try {
            this.coreFileReader.getReader().close();
        } catch (IOException e) {
            throw new MinosException("file close fail", e);
        }
    }

}
