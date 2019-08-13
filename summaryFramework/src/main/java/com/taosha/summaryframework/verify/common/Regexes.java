package com.taosha.summaryframework.verify.common;

/**
 * @Description :
 * @Author : zhangmin
 * @Data 2019-08-13 1:48 PM
 **/
public interface Regexes {

    /** 手机号码 */
    String MOBILE = "^(13|14|15|16|17|18|19)\\d{9}$";

    /** 密码 */
    String PASSWORD = "^[a-zA-Z0-9_-]{6,15}$";

    /** 身份证号 */
    String IDCARD = "(^[1-9]\\d{5}(19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";

    /** 真实姓名 */
    String REAL_NAME = "^[\\u4e00-\\u9fa5]{2,15}$";

    /** 银行卡号 */
    String BANKCARD = "^\\d{12,21}$";

    /** 用户名 */
    String USERNAME = "^[a-zA-Z0-9_-]{6,120}$";

    /** 邮箱 */
    String EMAIL = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";

    /** 短信验证码 */
    String VERIFY_CODE = "^\\d{6}$";

    /** 手机号码或邮箱 */
    String MOBILE_OR_EMAIL = "^$|^(13|14|15|16|17|18|19)\\d{9}$|^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";

    /** 金额 */
    String MONEY = "(^1-9?(.[0-9]{1,2})?)|((0)1)|(^[0-9].0-9?$)";

    /** 金额 */
    String DATE = "^\\d{4}-\\d{1,2}-\\d{1,2}$";

    /** 金额 */
    String SWITCH = "^ON$|^OFF$";
}
