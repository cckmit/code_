/**
 * 汉化
 */
$.extend($.validator.messages, {
    required: "该项为必填项",
    remote: "请修正该项",
    email: "请输入有效的email地址",
    url: "请输入有效的URL",
    date: "请输入有效的日期",
    dateISO: "请输入有效的日期(ISO)",
    number: "请输入有效的数字",
    digits: "请输入有效的数字",
    creditcard: "请输入有效的信用卡号",
    equalTo: "请再次输入",
    maxlength: $.validator.format("不超过{0}个字符"),
    minlength: $.validator.format("至少{0}个字符"),
    rangelength: $.validator.format("字符个数在{0}到{1}之间"),
    range: $.validator.format("在{0}到{1}之间"),
    max: $.validator.format("不大于{0}"),
    min: $.validator.format("不小于{0}")
});
/**
 二、默认校验规则
 (1)required:true                必输字段
 (2)remote:"check.php"      使用ajax方法调用check.php验证输入值
 (3)email:true                    必须输入正确格式的电子邮件
 (4)url:true                        必须输入正确格式的网址
 (5)date:true                      必须输入正确格式的日期 日期校验ie6出错，慎用
 (6)dateISO:true                必须输入正确格式的日期(ISO)，例如：2009-06-23，1998/01/22 只验证格式，不验证有效性
 (7)number:true                 必须输入合法的数字(负数，小数)
 (8)digits:true                    必须输入整数
 (9)creditcard:                   必须输入合法的信用卡号
 (10)equalTo:"#field"          输入值必须和#field相同
 (11)accept:                       输入拥有合法后缀名的字符串（上传文件的后缀）
 (12)maxlength:5               输入长度最多是5的字符串(汉字算一个字符)
 (13)minlength:10              输入长度最小是10的字符串(汉字算一个字符)
 (14)rangelength:[5,10]      输入长度必须介于 5 和 10 之间的字符串")(汉字算一个字符)
 (15)range:[5,10]               输入值必须介于 5 和 10 之间
 (16)max:5                        输入值不能大于5
 (17)min:10                       输入值不能小于10
 */