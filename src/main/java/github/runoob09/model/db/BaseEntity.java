package github.runoob09.model.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author zhang-jiahao
 * @date 2025/1/7 10:38
 */

@Data
public class BaseEntity {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;
}
