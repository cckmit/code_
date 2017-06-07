$(function() {

    $("#progress-bar").hide();
    if(companyName != undefined && companyName!=""){
        $("#progress-bar").show();
        searchTM();
    }else{
        BootstrapDialog.alert("Company name cannot be empty.");
    }
});

function getParams() {
    return {
        companyName : companyName,
        type: type,

        province:$('#province').val(),
        status: $('#status').val(),
        exIm: $('#exIm').val(),

        provinceProduct:$('#provinceProduct').val(),
        productAandV: $('#productAandV').val(),
        scale:$('#scale').val(),
        statusProduct: $('#statusProduct').val()
    }
}

function searchTM(){
    $("#orderGrid").bootgrid("destroy");

    $("#orderGrid").bootgrid({
        ajaxSettings: {
            method: "POST",
            cache: false
        },
        ajax: true,
        post: getParams(),
        url: basePath + "searchCompanyList.do",
        rowCount:  50,
        formatters: {
            "companyInfo": function(column, row)
            {
                function isName(companyDeal){
                     var cName=companyDeal.replace(/<em style='color:red'>/g,"").replace(/<\/em>/g,"");
                    return cName;
                }
                var companyDeal = row.nameEN;
                isName(companyDeal);

                var url = basePath+"user/reportChoose.do?typeId="+type+"&cnId="+companyName+"&crefoNo="+encodeURI(row.crefoNo)+"&companyName="+encodeURIComponent(isName(companyDeal))+"&companyNameCN="+encodeURI(row.nameCN)+"&status="+encodeURI(row.status)+"&stockCode="+encodeURI(row.stockCode)+"&a="+encodeURI(row.a)+"&v="+encodeURI(row.v)+"&reg="+row.reg;
                console.log(url);
                var html = "";
                html += ' <p><span class="lead"> <a href="javascript:void(0);" onclick=\'window.location.href="'+url+'"\' >'+row.highLightNameEN+'</a> </span><span class="label ' + (row.status == 1 ? 'label-success':'label-default') + '">Active</span>&nbsp;'
                if (row.stockCode == ''){
                }else{
                    html += '<span class="label ' + (row.stockCode == '' ? 'label-default':'label-success fxq-public') + '">Public</span>'
                }
                html += '&nbsp;<span class="label fxq-A-set ' + (row.a == 1 ? 'label-success fxq-A':'label-default') + '">A<span class="fxq-A-full">Authentication</span></span>&nbsp;<span class="label  fxq-V-set ' + (row.v == 1 ? 'label-success fxq-V':'label-default') + '">V<span class="fxq-V-full">Verification</span></span></p>';
                if(row.productLabel==undefined||row.productLabel==""||row.productLabel==null){
                }else{
                    html += ' <p>'+row.productLabel+'</p>';
                }
                if(row.reg==undefined||row.reg==""||row.reg==null){
                }else{
                    html += '<p><strong>Reg ID:'+row.reg+' </strong>';
                }
                if(row.provinceEN==undefined||row.provinceEN==""||row.provinceEN==null||row.cityEN==undefined||row.cityEN==""||row.cityEN==null){
                }else{
                    html += '&nbsp;<strong>Local: </strong>'+row.cityEN+'/'+row.provinceEN+'';
                }
                if(row.website==undefined||row.website==""||row.website==null){
                }else{
                    html += '&nbsp;<strong>URL: </strong><a href="'+row.website+'" target="_blank">'+row.website+'</a>';
                }
                html += '</p>';
                html+='<legend></legend>';
                return html;

            }
        },
    }).on("loaded.rs.juqery.bootgrid",function(){
        //在formatters中自定义属性data-row-id的值
    });
    $("#progress-bar").hide();

}


function query() {
    $("#orderGrid").bootgrid("reload");
}

