jqserialize=function(selector){
    var json = $(selector).serialize();
    json= strToObj(decodeURIComponent(json,true));
    return json;
}
strToObj=function(str){
    str = str.replace(/&/g,"','");
    str = str.replace(/=/g,"':'");
    str = "({'"+str +"'})";
    obj = eval(str);
    return obj;
}