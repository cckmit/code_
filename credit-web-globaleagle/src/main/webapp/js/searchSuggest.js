/**
 * Created by gavin on 16-11-1.
 */
$(".searchCountry").ready(function () {
    $(".searchCountry").bsSuggest({
        allowNoKeyword: false,   //是否允许无关键字时请求数据。为 false 则无输入时不执行过滤请求
        // multiWord: true,         //以分隔符号分割的多关键字支持
        // separator: ",",          //多关键字支持时的分隔符，默认为空格
        autoSelect: true,
        inputBgColor: 'white',               //输入框背景色，当与容器背景色不同时，可能需要该项的配置
        inputWarnColor: 'white', //输入框内容不是下拉列表选择时的警告色
        listStyle: {
            'padding-top': 0,
            'max-height': '375px',
            'max-width': '800px',
            'overflow': 'auto',
            'width': 'auto',
            'transition': '0.3s',
            '-webkit-transition': '0.3s',
            '-moz-transition': '0.3s',
            '-o-transition': '0.3s'
        },
        listHoverStyle: 'background: #1a9fde; color:#fff', //提示框列表鼠标悬浮的样式
        listHoverCSS: 'jhover',         //提示框列表鼠标悬浮的样式名称
        getDataMethod: "url",    //获取数据的方式，总是从 URL 获取
        url: basePath + "searchCountry.do?pageSize=10&t="+new Date().getTime() + "&keyword=", //优先从url ajax 请求 json 帮助数据，注意最后一个参数为关键字请求参数
        showBtn: false,
        idField: "enName",
        keyField: "cnName",
        // jsonp: 'cb',                        //如果从 url 获取数据，并且需要跨域，则该参数必须设置
        fnProcessData: function (json) {    // url 获取数据时，对数据的处理，作为 fnGetData 的回调函数
        //     alert(JSON.stringify(json));
            if (!json || json.length === 0) {
                return false;
            }

            var len = json.length;

            var data = {value:[]};
            for (var index = 0; index < len; index++) {
                var jj = json[index];
                data.value.push({
                    code: jj.code,
                    enName: jj.enName,
                    cnName:  jj.cnName
                });
            }

            //字符串转化为 js 对象
            return data;
        }
    }).on('onDataRequestSuccess', function (e, result) {
        console.log('onDataRequestSuccess: ', result);
    }).on('onSetSelectValue', function (e, keyword, data) {
        $(".searchCountry").val(data.cnName);
        console.log('onSetSelectValue: ', keyword, data);
    }).on('onUnsetSelectValue', function () {
        console.log("onUnsetSelectValue");
    });

});
