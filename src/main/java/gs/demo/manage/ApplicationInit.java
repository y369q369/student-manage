package gs.demo.manage;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import gs.demo.constants.ConfigConstant;
import gs.demo.constants.SysDictConstant;
import gs.demo.domain.Config;
import gs.demo.domain.SysDict;
import gs.demo.domain.SysDictItem;
import gs.demo.mapper.ConfigMapper;
import gs.demo.mapper.SysDictItemMapper;
import gs.demo.mapper.SysDictMapper;
import gs.demo.vo.DictVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author gs
 * @since 2023/3/24 14:32
 */
@Slf4j
@Component
public class ApplicationInit {

    @Resource
    private ConfigMapper configMapper;

    @Resource
    private SysDictMapper sysDictMapper;

    @Resource
    private SysDictItemMapper sysDictItemMapper;

    /**
     * 在系统启动完成，需要进行初始化，包括以下内容
     */
    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        initConfig();
        initSysDict();
    }

    /**
     * 配置表初始化
     */
    private void initConfig() {
        List<Config> configList = configMapper.selectList(null);
        if (CollUtil.isNotEmpty(configList)) {
            Map<String, String> configMap = configList.stream().collect(Collectors.toMap(Config::getFieldKey, Config::getFieldValue, (a, b) -> b));
            ConfigConstant.configMap = configMap;
            if (configMap.containsKey(ConfigConstant.TOKEN_EXPIRE_FIELD)) {
                ConfigConstant.TOKEN_EXPIRE = Long.valueOf(configMap.get(ConfigConstant.TOKEN_EXPIRE_FIELD));
            }
            if (configMap.containsKey(ConfigConstant.TOKEN_SALT_FIELD)) {
                ConfigConstant.TOKEN_SALT = configMap.get(ConfigConstant.TOKEN_SALT_FIELD);
            }
            if (configMap.containsKey(ConfigConstant.DEFAULT_PWD_FIELD)) {
                ConfigConstant.DEFAULT_PWD = configMap.get(ConfigConstant.DEFAULT_PWD_FIELD);
            }
            if (configMap.containsKey(ConfigConstant.EXPORT_MAX_NUM_FIELD)) {
                ConfigConstant.EXPORT_MAX_NUM = Integer.valueOf(configMap.get(ConfigConstant.EXPORT_MAX_NUM_FIELD));
            }
        }
    }

    /**
     * 字典初始化
     */
    private void initSysDict() {
        List<SysDict> sysDictList = sysDictMapper.selectList(Wrappers.<SysDict>lambdaQuery().eq(SysDict::getDelFlag, 0));
        if (CollUtil.isNotEmpty(sysDictList)) {
            List<SysDictItem> sysDictItemList = sysDictItemMapper.selectList(Wrappers.<SysDictItem>lambdaQuery()
                    .eq(SysDictItem::getStatus, 1)
                    .orderByAsc(Arrays.asList(SysDictItem::getDictId, SysDictItem::getSortOrder))
            );
            if (CollUtil.isNotEmpty(sysDictItemList)) {
                Map<String, Map<Object, String>> dictTypeMap = new HashMap<>();
                Map<String, List<DictVo>> dictListMap = new HashMap<>();
                Map<Integer, List<SysDictItem>> sysDictItemMap = sysDictItemList.stream().collect(Collectors.groupingBy(SysDictItem::getDictId));
                for (SysDict item : sysDictList) {
                    if (sysDictItemMap.containsKey(item.getId())) {
                        List<SysDictItem> itemList = sysDictItemMap.get(item.getId());

                        Map<Object, String> itemMap = new HashMap<>();
                        List<DictVo> dictVoList = new ArrayList<>();
                        for (SysDictItem dictItem : itemList) {
                            Object value = item.getType() == 0 ? dictItem.getItemValue(): Integer.valueOf(dictItem.getItemValue());
                            itemMap.put(value, dictItem.getItemText());
                            DictVo dictVo = new DictVo();
                            dictVo.setLabel(dictItem.getItemText());
                            dictVo.setValue(value);
                            dictVoList.add(dictVo);
                        }
                        dictTypeMap.put(item.getDictCode(), itemMap);
                        dictListMap.put(item.getDictCode(), dictVoList);
                    }
                }
                SysDictConstant.dictTypeMap = dictTypeMap;
                SysDictConstant.dictListMap = dictListMap;
            }
        }
    }

}
