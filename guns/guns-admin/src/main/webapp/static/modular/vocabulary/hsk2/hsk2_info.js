/**
 * 初始化HSK2详情对话框
 */
var Hsk2InfoDlg = {
    hsk2InfoData : {}
};

/**
 * 清除数据
 */
Hsk2InfoDlg.clearData = function() {
    this.hsk2InfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Hsk2InfoDlg.set = function(key, val) {
    this.hsk2InfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
Hsk2InfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
Hsk2InfoDlg.close = function() {
    parent.layer.close(window.parent.Hsk2.layerIndex);
}

/**
 * 收集数据
 */
Hsk2InfoDlg.collectData = function() {
    this
    .set('id')
    .set('name')
    .set('pinyin')
    .set('English')
    .set('address')
    .set('sentence')
    .set('ps')
    .set('es')
    .set('saddress');
}

/**
 * 提交添加
 */
Hsk2InfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/hsk2/add", function(data){
        Feng.success("添加成功!");
        window.parent.Hsk2.table.refresh();
        Hsk2InfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.hsk2InfoData);
    ajax.start();
}

/**
 * 提交修改
 */
Hsk2InfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/hsk2/update", function(data){
        Feng.success("修改成功!");
        window.parent.Hsk2.table.refresh();
        Hsk2InfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.hsk2InfoData);
    ajax.start();
}

$(function() {

});
