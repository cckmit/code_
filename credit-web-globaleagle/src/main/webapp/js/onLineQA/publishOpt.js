var globalFromId = '';
var globalToId = '';
$(document).ready(function() {
    $('#sendInfo').click(function () {
        var textContent = $('#textContent').val();
        var different = 'different';
        if($.trim(textContent) == ''|| textContent == null || textContent=="undefined"||textContent==undefined){
            BootstrapDialog.alert("发表意见不能为空");
        }else{
            $.ajax({
                method: "POST",
                url:basePath+"customer/insMessage.do",
                cache:false,
                dataType : 'json',
                data:{
                    'textContent' : textContent,
                    'url': sendUrl,
                    'fromId':globalFromId,
                    'toId':globalToId
                },
                success : function(data) {
                    $('#textContent').val('');
                    var content = data.content;
                    var sendTime = data.sendTime;
                    var formatST = formatDateTime(sendTime);
                    var from_id = data.fromId;
                    var to_id = data.toId;
                    var html = '';
                    html += '<tr><td width="80px"></td><td align="right"><div class="send1"><p class="left" id="fromContent">' + content + '</p><p class="right">' + formatST + '</p><div class="arrow1"></div></div></td><td width="80px" valign="top"><div style="float:right; width:38px; height:35px; margin:10px 20px 0px 0;"><img src="/images/right.png"></div></td></tr>';
                    $('#contentTable').append(html);
                }
            });
        }
    });
    $('#onLineQA').click(function () {
        $.ajax({
            method: "POST",
            url:basePath+"customer/mesCaution.do",
            cache:false,
            dataType : 'json',
            success : function(data) {
                if(data == "200" || data == 200){
                    $('#aqModal').modal('show');
                    var toId = '1';
                    $.ajax({
                        method: "POST",
                        url:basePath+"customer/loadMessage.do",
                        cache:false,
                        dataType : 'json',
                        data:{
                            'toId': toId,
                            'fromId': globalFromId
                        },
                        success : function(data) {
                            $('#contentTable').empty();
                            $.each(data,function(i,item){
                                var content = item.content;
                                var sendTime = item.sendTime;
                                var formatST = formatDateTime(sendTime);
                                var from_id = item.fromId;
                                var to_id = item.toId;
                                var html = '';
                                if(to_id ==  toId ){
                                    html += '<tr><td></td><td align="right"><div class="send1"><p class="left" id="fromContent">'+content+'</p><p class="right">'+formatST+'</p><div class="arrow1"></div></div></td><td valign="top"><div style="float:right; width:38px; height:35px; margin:10px 20px 0px 0;"><img src="/images/right.png"></div></td></tr>';
                                }else{
                                    html += '<tr><td width ="80px" valign="top"><div style="float:right; width:38px; height:35px; margin:10px 20px 0px 0;"><img src="/images/left.png"></div></td><td align="left"><div class="send"><div class="arrow"></div><p class="left">'+content+'</p><p class="right">'+formatST+'</p></div></td><td width="80px"></td></tr>';
                                }
                                $('#contentTable').append(html);
                            });
                        }
                    });
                }else {
                    $('#answerModal').modal('show');
                    $('#msgTBody').empty();
                    if (data.length != 0) {
                        $.each(data, function (i, item) {
                            globalFromId = item.fromId;
                            globalToId = item.toId;
                            var email = item.email;
                            var url = item.url;
                            var count = item.count;
                            var html = '';
                            html += '<tr><td height="40" align="center">' + email + '</td><td align="center">' + url + '</td><td align="center">' + count + '</td><td align="center"><input type="button" value="回复" onclick="myAnswer(' + globalFromId + ',' + globalToId + ')"/></td></tr>';
                            $('#msgTBody').append(html);
                        });
                    }
                }
            }
        });
    });

});
var formatDateTime = function (time) {
    var date = new Date(time);
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    m = m < 10 ? ('0' + m) : m;
    var d = date.getDate();
    d = d < 10 ? ('0' + d) : d;
    var h = date.getHours();
    var minute = date.getMinutes();
    minute = minute < 10 ? ('0' + minute) : minute;
    return y + '-' + m + '-' + d+' '+h+':'+minute;
};

function myAnswer(globalFromId,globalToId) {
    $.ajax({
        method: "POST",
        url:basePath+"customer/loadMessage.do",
        cache:false,
        dataType : 'json',
        data:{
            'fromId':globalFromId,
            'toId':globalToId
        },
        success : function(data) {
            $('#aqModal').modal('show');
            $('#contentTable').empty();
            $.each(data,function(i,item){
                var content = item.content;
                var sendTime = item.sendTime;
                var formatST = formatDateTime(sendTime);
                var from_id = item.fromId;
                var to_id = item.toId;
                var html = '';
                if(to_id == globalFromId && from_id == globalToId  ){
                    html += '<tr><td></td><td align="right"><div class="send1"><p class="left" id="fromContent">'+content+'</p><p class="right">'+formatST+'</p><div class="arrow1"></div></div></td><td valign="top"><div style="float:right; width:38px; height:35px; margin:10px 20px 0px 0;"><img src="/images/right.png"></div></td></tr>';
                }else{
                    html += '<tr><td width ="80px" valign="top"><div style="float:right; width:38px; height:35px; margin:10px 20px 0px 0;"><img src="/images/left.png"></div></td><td align="left"><div class="send"><div class="arrow"></div><p class="left">'+content+'</p><p class="right">'+formatST+'</p></div></td><td width="80px"></td></tr>';
                }
                $('#contentTable').append(html);
            });
        }
    });
};
