var _continentId = 1;//默认查询亚洲
$(function() {
    $("#grid-data").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        post: getParams,
        url: basePath+"/basic/countryList.do",
        formatters: {
            "operate": function(column, row)
            {
                var but="";
                but += "<button class=\"btn btn-sm btn-primary\" onclick=\"editCountry("+row.id+");\">查看详情</button>";
                but += "&nbsp;<button class=\"btn btn-sm btn-primary\" onclick=\"countryDel("+row.id+");\">删除</button>";
                return but;
            }
        }
    });
});

$(document).ready(function () {
    $("#continentForm").validate();
    $("#countryForm").validate();
    loadContinents();
});

function changeContinent(btn){
    _continentId = $(btn).attr("value");
    $("button[name='continentBtn']").removeClass("btn-primary");
    $(btn).addClass("btn-primary");
    $("#grid-data").bootgrid("reload");
}

function getParams(){
    return {
        continentId: _continentId,
        cnName:$("#cnName").val(),
        enName:$("#enName").val(),
        isEnable:$("#isEnable").val()
    }
}

function query(){
    $("#grid-data").bootgrid("reload");
}

//初始化区域按钮，并按默认值选中
function loadContinents(){
    $.post(basePath + '/basic/continentList.do',{},function (data) {
        var map = $.parseJSON(data);
        buildContinents(map.rows);
    });
}
//构建区域按钮及选择器
function buildContinents(rows){
    $("#selRegion").empty();
    $("#continentIdCountry").empty();
    $("#selRegion").append("<button id='allContinent' name='continentBtn' value='0' class='btn btn-lg btn-default' onclick='changeContinent(this)'>所有</button>");
    $.each(rows, function (i, row) {
        $("#selRegion").append("<button name='continentBtn' value='" + row.id + "' enName='" + row.enName + "' isEnable='" + row.isEnable + "' class='btn btn-lg btn-default' onclick='changeContinent(this)'>" + row.cnName + "</button>");
        $("#continentIdCountry").append("<option value='" + row.id + "'>" + row.cnName + "</option>");
    });
    $("button[value='" + _continentId + "']").addClass("btn-primary");
}

function editContinent(id){
    //$("#continentForm").data('bootstrapValidator').destroy();
    //$("#continentForm").bootstrapValidator('resetForm', true);
    if(!id){
        id =  _continentId;
    }
    if(id == 0){
        BootstrapDialog.alert("请先选择一个区域");
        return;
    }
    if(id > 0){
        var btn = $("button[value='" + id + "']");
        var enName = btn.attr("enName");
        var isEnable = btn.attr("isEnable");
        var cnName = btn.html();

        $("#enNameContinent").val(enName);
        $("#cnNameContinent").val(cnName);
        $("#idContinent").val(id);
        $("#isEnableContinent").val(isEnable);
    }
    $('#continentModal').modal('show');
}

function continentSave() {
    if(!$("#continentForm").valid())
        return false;
    var id = $("#idContinent").val();
    var enName = $("#enNameContinent").val();
    var cnName = $("#cnNameContinent").val();
    var isEnable = $("#isEnableContinent").val();
    $.post(basePath + '/basic/continentSave.do',
        {
            id: id,
            enName: enName,
            cnName: cnName,
            isEnable: isEnable
        },
        function (data) {
            var map = $.parseJSON(data);
            if(map.result){
                BootstrapDialog.alert("保存成功！");
                buildContinents(map.rows);
            }else{
                BootstrapDialog.alert("保存失败！");
            }
        }
    );
    $('#continentModal').modal('hide');
}

function continentDel(id) {
    if(!id){
        id =  _continentId;
    }
    if(id == 0){
        BootstrapDialog.alert("请先选择一个区域");
        return;
    }
    BootstrapDialog.confirm("确定删除吗？",function(result) {
        if (result) {
            $.post(basePath + '/basic/continentDel.do',
                {
                    id: id,
                },
                function (data) {
                    var map = $.parseJSON(data);
                    if (map.result) {
                        //删除成功后选择第一个区域，不是所有
                        var btn = $("#allContinent").next();
                        if(btn){
                            _continentId = btn.attr("value");
                        }else {
                            _continentId = 0;
                        }
                        buildContinents(map.rows);
                        BootstrapDialog.alert("删除成功！");
                        query();
                    } else {
                        BootstrapDialog.alert("删除失败！<br/>" + map.resultDes);
                    }
                }
            );
        }
    });
    $('#continentModal').modal('hide');
}

function editCountry(id){
    //$("#countryForm").data('bootstrapValidator').destroy();
    //$("#countryForm").bootstrapValidator('resetForm', true);
    if(id > 0){//加载国家信息
        $.post(basePath + '/basic/getCountry.do',{id:id},function(data){
            var map = $.parseJSON(data);
            $("#idCountry").val(map.id);
            $("#codeCountry").val(map.code);
            $("#enNameCountry").val(map.enName);
            $("#cnNameCountry").val(map.cnName);
            $("#continentIdCountry").val(map.continentId);
            $("#isEnableCountry").val(map.isEnable);

            $("#cnyCountry").val(map.onlineOrderCnyPrice);
            $("#usdCountry").val(map.onlineOrderUsdPrice);
            $("#eurCountry").val(map.onlineOrderEurPrice);
            $("#cnyDCountry").val(map.onlineExpressDeliveryCnyPrice);
            $("#usdDCountry").val(map.onlineExpressDeliveryUsdPrice);
            $("#eurDCountry").val(map.onlineExpressDeliveryEurPrice);
            $("#normalDays").val(map.onlineNormailDeliveryDays);
            $("#fastDays").val(map.onlineExpressDeliveryDays);

            $("#cnyFullCountry").val(map.onlineFullOrderCnyPrice);
            $("#usdFullCountry").val(map.onlineFullOrderUsdPrice);
            $("#eurFullCountry").val(map.onlineFullOrderEurPrice);
            $("#cnyFullDCountry").val(map.onlineFullExpressDeliveryCnyPrice);
            $("#usdFullDCountry").val(map.onlineFullExpressDeliveryUsdPrice);
            $("#eurFullDCountry").val(map.onlineFullExpressDeliveryEurPrice);
            $("#normalFullDays").val(map.onlineFullNormailDeliveryDays);
            $("#fastFullDays").val(map.onlineFullExpressDeliveryDays);

            $("#cnyOffCountry").val(map.offlineOrderCnyPrice);
            $("#usdOffCountry").val(map.offlineOrderUsdPrice);
            $("#eurOffCountry").val(map.offlineOrderEurPrice);
            $("#cnyOffDCountry").val(map.offlineExpressDeliveryCnyPrice);
            $("#usdOffDCountry").val(map.offlineExpressDeliveryUsdPrice);
            $("#eurOffDCountry").val(map.offlineExpressDeliveryEurPrice);
            $("#normalOffDays").val(map.offlineNormailDeliveryDays);
            $("#fastOffDays").val(map.offlineExpressDeliveryDays);
        });
    }
    $('#countryModal').modal('show');
}
function countrySave() {
    if(!$("#countryForm").valid())
        return false;
    $.post(basePath + '/basic/countrySave.do',
        {
            id: $("#idCountry").val(),
            code: $("#codeCountry").val(),
            cnName: $("#cnNameCountry").val(),
            enName: $("#enNameCountry").val(),
            isEnable: $("#isEnableCountry").val(),
            continentId: $("#continentIdCountry").val(),

            onlineOrderCnyPrice: $("#cnyCountry").val(),
            onlineOrderUsdPrice: $("#usdCountry").val(),
            onlineOrderEurPrice: $("#eurCountry").val(),
            onlineExpressDeliveryCnyPrice: $("#cnyDCountry").val(),
            onlineExpressDeliveryUsdPrice: $("#usdDCountry").val(),
            onlineExpressDeliveryEurPrice: $("#eurDCountry").val(),
            onlineNormailDeliveryDays: $("#normalDays").val(),
            onlineExpressDeliveryDays: $("#fastDays").val(),

            onlineFullOrderCnyPrice: $("#cnyFullCountry").val(),
            onlineFullOrderUsdPrice: $("#usdFullCountry").val(),
            onlineFullOrderEurPrice: $("#eurFullCountry").val(),
            onlineFullExpressDeliveryCnyPrice: $("#cnyFullDCountry").val(),
            onlineFullExpressDeliveryUsdPrice: $("#usdFullDCountry").val(),
            onlineFullExpressDeliveryEurPrice: $("#eurFullDCountry").val(),
            onlineFullNormailDeliveryDays: $("#normalFullDays").val(),
            onlineFullExpressDeliveryDays: $("#fastFullDays").val(),

            offlineOrderCnyPrice: $("#cnyOffCountry").val(),
            offlineOrderUsdPrice: $("#usdOffCountry").val(),
            offlineOrderEurPrice: $("#eurOffCountry").val(),
            offlineExpressDeliveryCnyPrice: $("#cnyOffDCountry").val(),
            offlineExpressDeliveryUsdPrice: $("#usdOffDCountry").val(),
            offlineExpressDeliveryEurPrice: $("#eurOffDCountry").val(),
            offlineNormailDeliveryDays: $("#normalOffDays").val(),
            offlineExpressDeliveryDays: $("#fastOffDays").val()
        },
        function (data) {
            var map = $.parseJSON(data);
            if(map.result){
                BootstrapDialog.alert("保存成功！");
                query();
            }else{
                BootstrapDialog.alert("保存失败！");
            }
        }
    );
    $('#countryModal').modal('hide');
}

function countryDel(id) {
    if(id < 1){
        return;
    }
    BootstrapDialog.confirm("确定删除吗？",function(result) {
        if (result) {
            $.post(basePath + '/basic/countryDel.do',
                {
                    id: id,
                },
                function (data) {
                    var map = $.parseJSON(data);
                    if (map.result) {
                        BootstrapDialog.alert("删除成功！");
                        query();
                    } else {
                        BootstrapDialog.alert("删除失败！<br/>" + map.resultDes);
                    }
                }
            );
        }
    });
    $('#continentModal').modal('hide');
}