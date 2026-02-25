package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.cos.entity.IntegralRecord;
import cc.mrbird.febs.cos.dao.IntegralRecordMapper;
import cc.mrbird.febs.cos.service.IIntegralRecordService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * @author FanK
 */
@Service
public class IntegralRecordServiceImpl extends ServiceImpl<IntegralRecordMapper, IntegralRecord> implements IIntegralRecordService {

    /**
     * 分页获取积分记录信息
     *
     * @param page           分页对象
     * @param integralRecord 积分记录信息
     * @return 结果
     */
    @Override
    public IPage<LinkedHashMap<String, Object>> queryPage(Page<IntegralRecord> page, IntegralRecord integralRecord) {
        return baseMapper.queryPage(page, integralRecord);
    }
}
