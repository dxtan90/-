package com.text.springboot.money.mapper;

import com.text.springboot.bean.Outlayin;
import com.text.springboot.bean.SelectVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutLayIn {

    /**
     * 添加一项入账信息
     * @param layIn 入帐信息
     * @return 是否成功
     */
    boolean addLayIn(Outlayin layIn);

    /**
     * 根据id查询入账信息
     * @param id 入账经费id
     * @return 入账信息
     */
    Outlayin findLayInById(Integer id);


    /**
     * 查询所有入账信息
     * @return 所有入账信息
     */
    List<Outlayin> findAllLayIn();

    /**
     * 根据经办人名称获取入账信息
     * @param ryName 经办人名称
     * @return 对应经办人的入账信息
     */
    List<Outlayin> findLayInByRyName(String ryName);


    /**
     * 修改入账信息
     * @param layIn 新信息
     * @return 是否成功
     */
    boolean updateLayIn(Outlayin layIn);

    /**
     * 查询所有经办人姓名
     * @return 经办人列表
     */
    List<String> findAllRyName();

    /**
     * 条件查询Vo
     * @param vo 条件
     * @return 入账信息
     */
    List<Outlayin> findLayInByVo(SelectVo vo);

    /**
     * 查询记录条数
     * @return 记录条数
     */
    Integer findAllCount();

    /**
     * 删除信息
     * @param id id
     */
    void deleteLayIn(Integer id);
}
