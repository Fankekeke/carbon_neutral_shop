package cc.mrbird.febs.cos.controller;


import cc.mrbird.febs.common.utils.R;
import cc.mrbird.febs.cos.entity.IntegralRecord;
import cc.mrbird.febs.cos.service.IIntegralRecordService;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author FanK
 */
@RestController
@RequestMapping("/cos/integral-record")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class IntegralRecordController {

    private final IIntegralRecordService integralRecordService;

    /**
     * 分页获取积分记录信息
     *
     * @param page           分页对象
     * @param integralRecord 积分记录信息
     * @return 结果
     */
    @GetMapping("/page")
    public R page(Page<IntegralRecord> page, IntegralRecord integralRecord) {
        return R.ok(integralRecordService.queryPage(page, integralRecord));
    }

    /**
     * 获取ID获取积分记录详情
     *
     * @param id 主键
     * @return 结果
     */
    @GetMapping("/{id}")
    public R detail(@PathVariable("id") Integer id) {
        return R.ok(integralRecordService.getById(id));
    }

    /**
     * 获取积分记录信息列表
     *
     * @return 结果
     */
    @GetMapping("/list")
    public R list() {
        return R.ok(integralRecordService.list());
    }

    /**
     * 新增积分记录信息
     *
     * @param integralRecord 积分记录信息
     * @return 结果
     */
    @PostMapping
    public R save(IntegralRecord integralRecord) {
        integralRecord.setCreateDate(DateUtil.formatDateTime(new Date()));
        return R.ok(integralRecordService.save(integralRecord));
    }

    /**
     * 修改积分记录信息
     *
     * @param integralRecord 积分记录信息
     * @return 结果
     */
    @PutMapping
    public R edit(IntegralRecord integralRecord) {
        return R.ok(integralRecordService.updateById(integralRecord));
    }

    /**
     * 删除积分记录信息
     *
     * @param ids ids
     * @return 积分记录信息
     */
    @DeleteMapping("/{ids}")
    public R deleteByIds(@PathVariable("ids") List<Integer> ids) {
        return R.ok(integralRecordService.removeByIds(ids));
    }
}
