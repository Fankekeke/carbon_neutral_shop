package cc.mrbird.febs.cos.dao;

import cc.mrbird.febs.cos.entity.IntegralRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface IntegralRecordMapper extends BaseMapper<IntegralRecord> {

    /**
     * 分页获取积分记录信息
     *
     * @param page           分页对象
     * @param integralRecord 积分记录信息
     * @return 结果
     */
    @GetMapping("/page")
    IPage<LinkedHashMap<String, Object>> queryPage(Page<IntegralRecord> page, @Param("integralRecord") IntegralRecord integralRecord);
}
