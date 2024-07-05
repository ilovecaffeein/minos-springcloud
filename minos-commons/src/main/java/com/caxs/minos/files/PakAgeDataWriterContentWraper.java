package com.caxs.minos.files;

/**
 * @ClassName: PakAgeDataWriterContentWraper
 * @Description: 构造文件报文内容
 * @Author: coffee
 * @Date: 2020/8/13 15:10
 * @Version: v1.0 文件初始创建
 */
public interface PakAgeDataWriterContentWraper {
    /**
     * 把内容对象构造成数组
     *
     * @param contentObj
     * @return
     */
     String[] buildContentArray(Object contentObj);

    /**
     * 构造返回对象
     *
     * @param returnArr
     * @return
     */
     Object buildRespContentObject(String[] returnArr);
}
