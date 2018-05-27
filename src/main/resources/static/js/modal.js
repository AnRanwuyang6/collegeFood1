/**
 * Created by yichen on 2017/8/7.
 */
$(function(){
    $('#cautionClose').on('click',function(){
        $('#cautionModal').modal('hide')
    })
})

var wakeModal = '';
/**
 * 因semantic不可存在两个模态框，所以添加重唤醒功能
 * @param message 需要显示的信息
 * @param wakeModalId 要重新唤醒的模态框id
 */
var cautionModal = function(message,wakeModalId){
    if (wakeModalId != '' && wakeModalId != null){
        wakeModal = wakeModalId;
    }
    var modal = $('#cautionModal');
    var content = $('#cautionModal .content');
    content.text(message);
    modal.modal('setting', 'closable', false).modal('show')
}

var hideCautionModal = function(){
    var modal = $('#cautionModal');
    modal.modal('hide');
    if (wakeModal != '' && wakeModal != null){
        $('#'+wakeModal).modal('setting', 'closable', false).modal('show');
        wakeModal = '';
    }
}
