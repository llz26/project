/**
 * HSK2管理初始化
 */
var Hsk2 = {
    id: "Hsk2Table",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Hsk2.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'NUM', field: 'id', visible: true, align: 'center', valign: 'middle'},
        {title: 'NAME', field: 'name', visible: true, align: 'center', valign: 'middle'},
        {title: 'Pinyin', field: 'pinyin', visible: true, align: 'center', valign: 'middle'},
        {title: 'English', field: 'english', visible: true, align: 'center', valign: 'middle'},
        {title: 'MP3', field: 'address', visible: true, align: 'center', valign: 'middle'},
        {title: 'sentence', field: 'sentence', visible: true, align: 'center', valign: 'middle'},
        {title: 'Pinyin', field: 'ps', visible: true, align: 'center', valign: 'middle'},
        {title: 'English', field: 'es', visible: true, align: 'center', valign: 'middle'},
        {title: 'MP3', field: 'saddress', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Hsk2.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Hsk2.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加HSK2
 */
Hsk2.openAddHsk2 = function () {
    var index = layer.open({
        type: 2,
        title: '添加HSK2',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/hsk2/hsk2_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看HSK2详情
 */
Hsk2.openHsk2Detail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: 'HSK2详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/hsk2/hsk2_update/' + Hsk2.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除HSK2
 */
Hsk2.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/hsk2/delete", function (data) {
            Feng.success("删除成功!");
            Hsk2.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("hsk2Id",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询HSK2列表
 */
Hsk2.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Hsk2.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Hsk2.initColumn();
    var table = new BSTable(Hsk2.id, "/hsk2/list", defaultColunms);
    table.setPaginationType("client");
    Hsk2.table = table.init();
});
