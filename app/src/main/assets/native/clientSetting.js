var _ClientSetting = null;

class ClientSetting {

    constructor() {
        _ClientSetting = this;
    }

    show() {
        return new Promise(resolv => {
            fetch('/js/clientSetting.html').then((rsp) => {
                rsp.text().then(html => {
                    let dlg = this.createSettingDialog(html)
                    window.InnerComponents.Components.dashboard.default.dialogHelper.open(dlg);
                    resolv(dlg);
                });
            });
        });

    }

    createSettingDialog(html) {
        let dlg = window.InnerComponents.Components.dashboard.default.dialogHelper.createDialog({
            size: 'fullscreen',
            removeOnClose: true,
            scrollY: false,
            modal: true
        });
        dlg.innerHTML = html;
        dlg.querySelector('.btnCloseDialog').addEventListener('click', () => {
            window.InnerComponents.Components.dashboard.default.dialogHelper.close(dlg);
        });
        dlg.querySelector('#clientSettingSaveBtn').addEventListener('click', function () {
            _ClientSetting.save(dlg);
        });

        this.init(dlg);
        return dlg;
    }

    init(dlg) {
        dlg.querySelector('#useExternalplayer').checked = localStorage.getItem('useExternalplayer') == 'true';
        dlg.querySelector('#forceDirectPlay').checked = localStorage.getItem('forceDirectPlay') == 'true';

        let maxVideoWidth = localStorage.getItem('MaxVideoWidth') || 0;
        maxVideoWidth = maxVideoWidth == 0 ? 1280 : maxVideoWidth;
        dlg.querySelector('#selectMaxVideoWidth').value = maxVideoWidth;

        let maxAudioChannels = localStorage.getItem('AllowedAudioChannels') || -1;
        maxAudioChannels = maxAudioChannels == -1 ? 2 : maxAudioChannels;
        dlg.querySelector('#selectAllowedAudioChannels').value = maxAudioChannels;

        //转码音频格式
        let selectTranscodeVideoAudioCodec = localStorage.getItem("selectTranscodeVideoAudioCodec") || "";
        dlg.querySelector("#selectTranscodeVideoAudioCodec").value = selectTranscodeVideoAudioCodec;
    }

    save(dlg) {
        // 使用外部播放器
        localStorage.setItem('useExternalplayer', dlg.querySelector('#useExternalplayer').checked);
        localStorage.setItem('forceDirectPlay', dlg.querySelector('#forceDirectPlay').checked);

        localStorage.setItem('MaxVideoWidth', dlg.querySelector('#selectMaxVideoWidth').value);
        localStorage.setItem('AllowedAudioChannels', dlg.querySelector('#selectAllowedAudioChannels').value);

        localStorage.setItem('selectTranscodeVideoAudioCodec', dlg.querySelector("#selectTranscodeVideoAudioCodec").value);

        window.InnerComponents.Components.toast('已保存')
        window.InnerComponents.Components.dashboard.default.dialogHelper.close(dlg);
    }
}

const settingDialog = new ClientSetting();
export default settingDialog;