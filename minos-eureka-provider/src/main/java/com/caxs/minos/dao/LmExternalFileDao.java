package com.caxs.minos.dao;

import com.caxs.minos.domain.LmExternalFile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LmExternalFileDao {
     /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTx]
     * @return List<LmFeeTx>
     */
     int deleteByPrimaryKey(@Param("outChn") String outChn, @Param("outDesc") String outDesc);
     /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTx]
     * @return List<LmFeeTx>
     */
     int insert(LmExternalFile record);
     /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTx]
     * @return List<LmFeeTx>
     */
     LmExternalFile selectByPrimaryKey(@Param("outChn") String outChn, @Param("outDesc") String outDesc);
    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTx]
     * @return List<LmFeeTx>
     */
    LmExternalFile selectByOutChn(@Param("outChn") String outChn);
     /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTx]
     * @return List<LmFeeTx>
     */
     List<LmExternalFile> selectAll();
     /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTx]
     * @return List<LmFeeTx>
     */
    int updateByPrimaryKey(LmExternalFile record);
     /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTx]
     * @return List<LmFeeTx>
     */
     LmExternalFile selectByPrimaryKey(@Param("outChn") String outChn);
     /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTx]
     * @return List<LmFeeTx>
     */
     List<LmExternalFile> findByRepayFileInd(@Param("lmpmshdFileInd") String lmpmshdFileInd);
     /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTx]
     * @return List<LmFeeTx>
     */
     List<LmExternalFile> selectListByObject(LmExternalFile lmExternalFile);
}