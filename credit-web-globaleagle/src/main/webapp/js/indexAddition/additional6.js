$(function() {
      $.each(continents,function(i,item){
    	if (continent==null||continent==""|| continent=="undefined") {
            $("#continent").append("<option >"+item.cnName+"</option>");
        }else{
    		if (continent==item.cnName) {
		        $("#continent").append("<option selected='selected'>"+item.cnName+"</option>");
			}else{
		        $("#continent").append("<option >"+item.cnName+"</option>");
			}
        }
        $.each(item.countries,function(j,itemj){       
        	if (country==null||country==""||country=="undefined") {
	            $("#company_country").append("<option >"+itemj.cnName+"</option>");	           
			}else{		
				if (country==itemj.cnName) {
		            $("#company_country").append("<option selected='selected'>"+itemj.cnName+"</option>");
				}else{
		            $("#company_country").append("<option >"+itemj.cnName+"</option>");
				}
			}
        });
    });
    if ((continent!=null||continent!=""||continent!="undefined")&&(country==null||country==""||country=="undefined")){
        onContinentChange();
    }else{
        onContinentChange2(country1);
    }

});



function onContinentChange(){
    var continent = $("#continent").val();
    $("#company_country").empty();
    $("#company_country").append("<option selected='selected'>选择国家/地区</option>");
    $.each(continents,function(i,item){
        if(item.cnName == continent){
            $.each(item.countries,function(j,itemj){
                $("#company_country").append("<option >"+itemj.cnName+"</option>");
            });
        }
    });
}

function onContinentChange2(country1){
    var continent = $("#continent").val();
    $("#company_country").empty();
    if (country1!=null||country1!=""){
        $("#company_country").append("<option selected='selected'>"+country+"</option>");
    }else{
        $("#company_country").append("<option selected='selected'>选择国家/地区</option>");
        $.each(continents,function(i,item){
            if(item.cnName == continent){
                $.each(item.countries,function(j,itemj){
                    $("#company_country").append("<option >"+itemj.cnName+"</option>");
                });
            }
        });
    }

}




