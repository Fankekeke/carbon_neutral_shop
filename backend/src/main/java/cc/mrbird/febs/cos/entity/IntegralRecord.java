package cc.mrbird.febs.cos.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 积分记录
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class IntegralRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 类型（0.减 1.增）
     */
    private String type;

    /**
     * 积分变更信息
     */
    private String content;

    /**
     * 积分数量
     */
    private BigDecimal integral;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 所属用户
     */
    private Integer userId;

    @TableField(exist = false)
    private String userName;


}
