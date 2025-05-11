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
    }

    save(dlg) {
        // 使用外部播放器
        localStorage.setItem('useExternalplayer', dlg.querySelector('#useExternalplayer').checked);
        localStorage.setItem('forceDirectPlay', dlg.querySelector('#forceDirectPlay').checked);

        window.InnerComponents.Components.toast('已保存')
        window.InnerComponents.Components.dashboard.default.dialogHelper.close(dlg);
    }
}

const settingDialog = new ClientSetting();
export default settingDialog;