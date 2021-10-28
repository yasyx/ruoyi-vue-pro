package cn.iocoder.yudao.coreservice.modules.system.enums.social;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.IntArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * 社交平台的类型枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum SysSocialTypeEnum implements IntArrayValuable {

    GITEE(10, "GITEE"), // https://gitee.com/api/v5/oauth_doc#/
    DINGTALK(20, "DINGTALK"), // https://developers.dingtalk.com/document/app/obtain-identity-credentials
    WECHAT_ENTERPRISE(30, "WECHAT_ENTERPRISE"), // https://xkcoding.com/2019/08/06/use-justauth-integration-wechat-enterprise.html
    // TODO @timfruit：微信平台，从 30 开始递增哈。另外，尽量不要出现，先 12，然后 11，有序，嘿嘿。
    /**
     * 微信公众平台 - H5
     */
    WECHAT_MP(12, "WECHAT_MP"), // https://www.cnblogs.com/juewuzhe/p/11905461.html
    /**
     * 微信开放平台 - 小程序
     */
    WECHAT_OPEN(11, "WECHAT_OPEN"), // https://justauth.wiki/guide/oauth/wechat_open/#_2-%E7%94%B3%E8%AF%B7%E5%BC%80%E5%8F%91%E8%80%85%E8%B5%84%E8%B4%A8%E8%AE%A4%E8%AF%81
    ;

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(SysSocialTypeEnum::getType).toArray();

    public static final List<Integer> WECHAT_ALL = ListUtil.toList(WECHAT_ENTERPRISE.type, WECHAT_MP.type, WECHAT_OPEN.type);

    /**
     * 类型
     */
    private final Integer type;
    /**
     * 类型的标识
     */
    private final String source;

    @Override
    public int[] array() {
        return ARRAYS;
    }

    public static SysSocialTypeEnum valueOfType(Integer type) {
        return ArrayUtil.firstMatch(o -> o.getType().equals(type), values());
    }

    public static List<Integer> getRelationTypes(Integer type) {
        if (WECHAT_ALL.contains(type)) {
            return WECHAT_ALL;
        }
        return ListUtil.toList(type);
    }

}