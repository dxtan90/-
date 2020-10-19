package com.text.springboot.money.mapper;

import com.text.springboot.bean.Outlaycost;
import com.text.springboot.bean.Outlayin;
import com.text.springboot.bean.SelectVo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OutLayOut {

    /**
     * 添加一项出账信息
     * @param layout 出帐信息
     * @return 是否成功
     */
    boolean addLayOut(Outlaycost layout);

    /**
     * 根据id查询出账信息
     * @param id 出账经费id
     * @return 出账信息
     */
    Outlaycost findLayOutById(Integer id);


    /**
     * 查询所有出账信息
     * @return 所有出账信息
     */
    List<Outlaycost> findAllLayOut();

    /**
     * 根据经办人名称获取出账信息
     * @param ryName 经办人名称
     * @return 对应经办人的出账信息
     */
    List<Outlaycost> findLayOutByRyName(String ryName);

    /**
     * 修改出账信息
     * @param layOut 新信息
     * @return 是否成功
     */
    boolean updateLayOut(Outlaycost layOut);

    /**
     * 查询所有经办人姓名
     * @return 经办人列表
     */
    List<String> findAllRyName();



    /**
     * 条件查询Vo
     * @param vo 条件
     * @return 出账信息
     */
    List<Outlaycost> findLayOutByVo(SelectVo vo);

    /**
     * 查询记录条数
     * @return 记录条数
     */
    Integer findAllCount();

    /**
     * 删除信息
     * @param id id
     */
    void deleteLayOut(Integer id);
}
