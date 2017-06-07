/**
 * Created by dell on 2017/3/3.
 */
$(function() {
    $("#grid-data").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        // rowCount:5,
        ajax: true,
        post: getParams,
        url: basePath+"/core/productList.do",
        formatters: {
            "operate": function (column, row) {
                var but = "";
                // but += "<button class=\"btn btn-sm btn-primary \" onclick=\"upProduct(" + row.id  + ");\">修改</button>";
                // but += "&nbsp;<button class=\"btn btn-sm btn-primary \" onclick=\"deleteProduct(" + row.id + ");\">删除</button>";
                return but;
            },
            "createTime": function (column, row) {
                var str = " ";
                if (row.createTime != null) {
                    str = moment(row.createTime).format('YYYY-MM-DD');
                }
                return str;
            },
            "productType": function (column, row) {
                var str;
                if (row.productType == 1) {
                    str = "中国报告";
                } else if (row.productType == 2) {
                    str = "外国报告";
                } else if (row.productType == 3) {
                    str = "自定义报告";
                }
                return str;
            },
            "source": function (column, row) {
                var str;
                if (row.source == 1) {
                    str = "全球鹰";
                } else if (row.source == 2) {
                    str = "全搜";
                } else if (row.source == 3) {
                    str = "估估";
                } else if (row.source == 4) {
                    str = "CPM";
                }
                return str;
            }
        }
    });
});

$(function () {
    $("#addProductForm").validate();
    $("#upProductForm").validate();
});

function getParams() {
    return {
        name: $('#name2').val(),
        productType:$('#productType2').val(),
        price:$("#price2").val(),
        source:$("#source2").val()
    };
}

// 删除产品
function deleteProduct(id) {
    if(id < 1){
        return;
    }
    BootstrapDialog.confirm("确定删除吗？",function(result) {
        if (result) {
            var senddata = {
                "id":id
            };
            $.ajax({
                type:"POST",
                url:basePath+"/core/delProduct.do",
                dataType:"json",
                contentType:"application/json",
                data:JSON.stringify(senddata),
                success:function(data){
                    if(data.code){
                        BootstrapDialog.alert(data.msg);
                        query();
                    }else{
                        BootstrapDialog.alert(data.msg);
                    }
                }
            });
        }
    });
}

function query(){
    $("#grid-data").bootgrid("reload");
}

function addProduct(){
    $('#addProductModal').modal('show');
}


function addProductList() {
    if(!$("#addProductForm").valid())
        return false;
    // var $check_boxes = $('#tagList1 input[type=checkbox][checked=checked]');
    // var dropIds = new Array();
    // $check_boxes.each(function(){
    //     var moduleId=$(this).val();
    //     var isProvider=$("#isProvider"+moduleId).val();
    //     var sql=$("#sql"+moduleId).val();
    //     var productModules={moduleId:moduleId,isProvider:isProvider,sql:sql};
    //     dropIds.push(productModules);
    // });

    var senddata={
        'name':$("#name").val(),
        'source':$("#source").val(),
        'productType':$("#productType").val(),
        'desc':$("#desc").val(),
        'price':$("#price").val(),
        'createPerson':$('#createPerson').val()
        // 'productModules':dropIds
    }
    $.ajax({
        type: "POST",
        url: basePath + "/core/addProduct.do",
        dataType: "json",
        contentType: "application/json",
        data:JSON.stringify(senddata),
        success: function (data) {
            if(data.code){
                BootstrapDialog.alert(data.msg);
                query();
            }else{
                BootstrapDialog.alert(data.msg);
            }
        }
    });
    $('#addProductModal').modal('hide');
}

function upProduct(id){
    var senddata={
        'id':id
    };
    // alert("id==="+id);
    $.ajax({
        type:"POST",
        url:basePath + "/core/getProduct.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data) {
            // var html_string="";
            if (data.code) {
                // alert(data.code);
                var object = data.content;
                $('#id1').val(object.id);
                $('#name1').val(object.name);
                $('#source1').val(object.source);
                $('#desc1').val(object.desc);
                $("#price1").val(object.price);
                $("#createPerson1").val(object.createPerson);
                $("#createTime1").val(object.createTime);

                // $('#id1').val(data.product.id);
                // $('#name1').val(data.product.name);
                // $('#source1').val(data.product.source);
                // $('#desc1').val(data.product.desc);
                // $("#price1").val(data.product.price);
                // $("#createPerson1").val(data.product.createPerson);
                // $("#createTime1").val(data.product.createTime);
            //     $.each(data.modules,function(idx,obj){
            //         var a=0;
            //                 break;
            //             }
            //         }
                //         for(var x = 0; x < data.productModules.length; x++){
                //             if(obj.id == data.productModules.moduleId){
                //                 html_string += '<label class="col-sm-2 control-label">'+obj.name+'</label>' +
                //                     '<input type="checkbox" id="moduleId1'+obj.id+'" name="productModules.moduleId" value="'+obj.id+'"  checked/>&nbsp;&nbsp;';
                //                 a=1;
            //         if(a == 0 ){
            //             html_string += '<label class="col-sm-2 control-label">'+obj.name+'</label>' +
            //                 '<input type="checkbox" id="moduleId1'+obj.id+'" name="productModules.moduleId" value="'+obj.id+'" />&nbsp;&nbsp;';
            //         }
            //         html_string += '<label  class="col-sm-2 control-label">是否供应商</label>'+
            //             '<div class="col-sm-2">'
            //             +' <select id="isProvider1'+obj.id+'" name="productModules.isProvider" class="input-large form-control" required>'
            //             + '<option></option>'
            //             +'<option value="true">是</option>'
            //             +' <option value="flase">否</option>'
            //             +' </select> </div>&nbsp;&nbsp;';
            //         html_string += '<label class="col-sm-2 control-label">查询SQL</label>' +
            //             '<div class="col-sm-4">' +
            //             '<input type="text" id="sql1'+obj.id+'" name="productModules.sql"  />' +
            //             '</div></span></div><br/>';
            //     });
            //     $('#tagList1').append(html_string);
            //     $('#upProductModal').modal('show');
            // }else{
            //     $.each(data.modules,function(idx,obj){
            //         html_string += '<div><label class="col-sm-2 control-label">'+obj.name+'</label>' +
            //             '<input type="checkbox" id="moduleId'+obj.id+'" name="productModules.moduleId" value="'+obj.id+'" /><span></span>&nbsp;&nbsp;';
            //         html_string += '<label  class="col-sm-2 control-label">是否供应商</label>'+'<div class="col-sm-2">'
            //             +' <select id="isProvider'+obj.id+'" name="productModules.isProvider" class="input-large form-control" required>'
            //             + '<option></option>'
            //             +'<option value="true">是</option>'
            //             +' <option value="flase">否</option>'
            //            +' </select> </div>&nbsp;&nbsp;';
            //         html_string += '<label class="col-sm-2 control-label">查询SQL</label>' +
            //             '<div class="col-sm-4"><input type="text" id="sql'+obj.id+'" name="productModules.sql"  />' +
            //             '</div></span></div><br/>';
            //     });
            //     $('#tagList').append(html_string);
            //     $('#addProductModal').modal('show');
                $('#upProductModal').modal('show');
             }else{
                $('#addProductModal').modal('show');
            }
            }
        });

}

function upProductList(){
    if(!$("#upProductForm").valid())
        return false;
    // var $check_boxes = $('#tagList input[type=checkbox][checked=checked]');
    // var dropIds = new Array();
    // $check_boxes.each(function(){
    //     var moduleId=$(this).val();
    //     var isProvider=$("#isProvider"+moduleId).val();
    //     var sql=$("#sql"+moduleId).val();
    //     var productModules={moduleId:moduleId,isProvider:isProvider,sql:sql};
    //     dropIds.push(productModules);
    // });

    var senddata = {
        'id':$('#id1').val(),
        'name':$("#name1").val(),
        'source':$("#source1").val(),
        'desc':$("#desc1").val(),
        'price':$("#price1").val(),
        'createPerson':$('#createPerson1').val(),
        'lastUpdatePerson':$('#lastUpdatePerson1').val(),
        'createTime':$('#createTime1').val()
        // 'productModules':dropIds
    }
    $.ajax({
        type:"POST",
        url:basePath+"/core/upProduct.do",
        dataType:"json",
        contentType:"application/json",
        data:JSON.stringify(senddata),
        success:function(data){
            if(data.code){
                BootstrapDialog.alert(data.msg);
                query();
            }else{
                BootstrapDialog.alert(data.msg);
            }
        }
    });
    $('#upProductModal').modal('hide');
}