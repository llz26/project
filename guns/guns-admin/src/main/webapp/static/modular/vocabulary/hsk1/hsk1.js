/**
 * HSK1管理初始化
 */
var Hsk1 = {
    id: "Hsk1Table",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Hsk1.initColumn = function () {
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
Hsk1.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Hsk1.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加HSK1
 */
Hsk1.openAddHsk1 = function () {
    var index = layer.open({
        type: 2,
        title: '添加HSK1',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/hsk1/hsk1_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看HSK1详情
 */
Hsk1.openHsk1Detail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: 'HSK1详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/hsk1/hsk1_update/' + Hsk1.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除HSK1
 */
Hsk1.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/hsk1/delete", function (data) {
            Feng.success("删除成功!");
            Hsk1.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("hsk1Id",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询HSK1列表
 */
Hsk1.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Hsk1.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Hsk1.initColumn();
    var table = new BSTable(Hsk1.id, "/hsk1/list", defaultColunms);
    table.setPaginationType("client");
    Hsk1.table = table.init();
});
