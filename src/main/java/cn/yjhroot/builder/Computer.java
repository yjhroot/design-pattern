package cn.yjhroot.builder;

import lombok.Data;

/**
 * 电脑类（产品）
 *
 * @author YuJianHui
 * @date 2022/02/20
 */
@Data
public class Computer {
    /**
     * cpu
     */
    private String cpu;

    /**
     * 主板
     */
    private String mainBoard;

    /**
     * 键盘
     */
    private String keyboard;

    /**
     * 内存
     */
    private String memory;

    /**
     * 显示器
     */
    private String screen;

    /**
     * 鼠标
     */
    private String mouse;
}
