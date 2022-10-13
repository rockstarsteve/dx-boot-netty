package com.dx.chat.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author rockstarsteven
 * @since 2022-10-13
 */
@Getter
@Setter
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("id")
    private String id;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 用户头像
     */
    @TableField("face_image")
    private String faceImage;

    /**
     * 用户大图
     */
    @TableField("face_image_big")
    private String faceImageBig;

    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 二维码
     */
    @TableField("qr_code")
    private String qrCode;

    /**
     * 登录唯一id
     */
    @TableField("cid")
    private String cid;
}
