package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.IntegralRecord;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
public interface IIntegralRecordService extends IService<IntegralRecord> {

    /**
     * 分页获取积分记录信息
     *
     * @param page           分页对象
     * @param integralRecord 积分记录信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> queryPage(Page<IntegralRecord> page, IntegralRecord integralRecord);
}
