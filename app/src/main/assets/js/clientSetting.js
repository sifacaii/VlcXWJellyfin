clientSettingHTML = `
<div id="ClientSettingPreferencesPage" data-role="page" class="focuscontainer dialog-fullscreen dialog-fullscreen-lowres dialog opened"
data-title="客户端设置" data-menubutton="true">
<div class="padded-left padded-right padded-bottom-page">
    <form style="margin: 0 auto;">
        <div class="verticalSection verticalSection-extrabottompadding">
            <h2 class="sectionTitle"> 客户端设置 </h2>

            <div class="checkboxContainer checkboxContainer-withDescription">
                <label>
                    <input type="checkbox" is="emby-checkbox" id="HardwareAcceleration" class="chkEnableGamepad" />
                    <span>启用硬件加速</span>
                </label>
                <div class="fieldDescription checkboxFieldDescription">
                    打开内置LIBVLC播放器的硬件加速
                </div>
            </div>

            <div class="checkboxContainer checkboxContainer-withDescription">
                <label>
                    <input type="checkbox" is="emby-checkbox" id="ForceHardwareAcceleration"
                        class="chkEnableGamepad" />
                    <span>强制启用硬件加速</span>
                </label>
                <div class="fieldDescription checkboxFieldDescription">
                    当开启硬件加速无效时，可尝试开启此项
                </div>
            </div>
        </div>

        <hr/>

        <div class="checkboxContainer checkboxContainer-withDescription">
            <label>
                <input type="checkbox" is="emby-checkbox" id="ToExtPlayer"
                    class="chkEnableGamepad" />
                <span>调用外部播放器</span>
            </label>
            <div class="fieldDescription checkboxFieldDescription">
                此项优先级高于内置播放器。
            </div>
        </div>
        

        <button is="emby-button" type="submit" class="raised button-submit block btnSave">
            <span>保存</span>
        </button>
    </form>
</div>
</div>
`

class ClientSetting {
    constructor({ events, loading, appSettings, playbackManager, globalize, appHost, appRouter, inputManager, toast, confirm }) {
        this.events = events;
        this.loading = loading;
        this.appRouter = appRouter;
        this.globalize = globalize;
        this.appHost = appHost;
        this.appSettings = appSettings;
        this.inputManager = inputManager;
        this.toast = toast;
        this.confirm = confirm;

        this.name = 'Client Setting';
        this.type = 'setting';
        this.id = 'clientsetting';

        this.routePath = "/clientSetting.html";

        const that = this;

        this.appRouter.addRoute(this.routePath, {
            path: this.routePath,
            dummyRoute: true
        });

        window.clientSetting = () => {
            var currentElement = document.activeElement;
            if (currentElement) {

                const modal = document.createElement("div");
                modal.classList.add('dialogContainer');

                modal.innerHTML = clientSettingHTML;
                document.body.appendChild(modal);

                modal.querySelector('#HardwareAcceleration').focus();
                let hacc = that.appSettings.get('VLC_HACC') == "true" ? true : false;
                let fhacc = that.appSettings.get('VLC_FORCE_HACC') == "true" ? true : false;
                let toextplayer = that.appSettings.get('TO_EXT_PLAYER') == "true" ? true : false;
                modal.querySelector('#HardwareAcceleration').checked = hacc;
                modal.querySelector('#ForceHardwareAcceleration').checked = fhacc;
                modal.querySelector('#ToExtPlayer').checked = toextplayer;


                var closeModal = function (e) {
                    if (e) {
                        e.preventDefault();
                        e.stopPropagation();
                    }

                    modal.remove();
                    currentElement.focus();
                    that.inputManager.off(modal, backCommand);
                    window.removeEventListener('popstate', closeModal);
                }

                var backCommand = function (e) {
                    if (e.detail.command === 'back') {
                        closeModal(e);
                    }
                }
                that.inputManager.on(modal, backCommand);

                modal.querySelector('.btnSave').addEventListener('click', (e) => {
                    that.appSettings.set('VLC_HACC', modal.querySelector('#HardwareAcceleration').checked || false);
                    that.appSettings.set('VLC_FORCE_HACC', modal.querySelector('#ForceHardwareAcceleration').checked || false);
                    that.appSettings.set('TO_EXT_PLAYER', modal.querySelector('#ToExtPlayer').checked || false);

                    closeModal(e);
                });

                window.addEventListener('popstate', closeModal);

                that.appRouter.show(that.routePath);
            }
        }
    }
}

window._clientSetting = function () {
    return new Promise(function (resolve) {
        resolve(ClientSetting);
    });
};