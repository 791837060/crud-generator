package com.coinflex.api.vault.feign;

import com.github.pagehelper.PageInfo;
import com.coinflex.api.vault.vo.VaultPoolVO;
import com.coinflex.api.vault.vo.VaultPoolQueryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * vault_pool-FeignClientFallback
 *
 * @author jack
 */
@Component
public class VaultPoolClientFallback implements IVaultPoolClient {
    private static final Logger logger = LoggerFactory.getLogger(VaultPoolClientFallback.class);

    /**
     * 分页查询vault_pool数据
     *
     * @param query           查询条件
     * @return 分页查询结果
     */
    @Override
    public PageInfo<VaultPoolVO> getRecordList(VaultPoolQueryVO query) {
        //TODO 处理异常情况
        return null;
    }

    /**
     * 根据主键查询vault_pool数据
     *
     * @param id  待查询的vault_pool记录id
     * @return vault_pool数据
     */
    @Override
    public VaultPoolVO getRecord(Long id) {
        //TODO 处理异常情况
        return null;
    }

    /**
     * 插入vault_pool记录
     *
     * @param vo    待插入的数据
     * @return 是否成功
     */
    @Override
    public Boolean insert(VaultPoolVO vo) {
        //TODO 处理异常情况
        return false;
    }

    /**
     * 更新vault_pool记录
     *
     * @param vo    待更新的数据
     * @return 是否成功
     */
    @Override
    public Boolean update(VaultPoolVO vo) {
        //TODO 处理异常情况
        return false;
    }

    /**
     * 删除vault_pool记录
     *
     * @param id  待删除的vault_pool记录id
     * @return 是否成功
     */
    @Override
    public Boolean delete(Long id) {
        //TODO 处理异常情况
        return false;
    }
}