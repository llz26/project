/**
 * 初始化HSK1详情对话框
 */
var Hsk1InfoDlg = {
    hsk1InfoData : {}
};

/**
 * 清除数据
 */
Hsk1InfoDlg.clearData = function() {
    this.hsk1InfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Hsk1InfoDlg.set = function(key, val) {
    this.hsk1InfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Hsk1InfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
Hsk1InfoDlg.close = function() {
    parent.layer.close(window.parent.Hsk1.layerIndex);
}

/**
 * 收集数据
 */
Hsk1InfoDlg.collectData = function() {
    this
    .set('id')
    .set('name')
    .set('pinyin')
    .set('english')
    .set('address')
    .set('sentence')
    .set('ps')
    .set('es')
    .set('saddress');
}

/**
 * 提交添加
 */
Hsk1InfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/hsk1/add", function(data){
        Feng.success("添加成功!");
        window.parent.Hsk1.table.refresh();
        Hsk1InfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.hsk1InfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Hsk1InfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/hsk1/update", function(data){
        Feng.success("修改成功!");
        window.parent.Hsk1.table.refresh();
        Hsk1InfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.hsk1InfoData);
    ajax.start();
}

$(function() {

});
