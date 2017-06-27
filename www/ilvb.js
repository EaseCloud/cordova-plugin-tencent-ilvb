/*global cordova, module*/

module.exports = {
    greet: function (name, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "TencentILVB", "greet", [name]);
    },
    initSdk: function (appId, accountType, successCallback, errorCallback) {
        // 初始化 iLiveSDK
        // int appId: 直播 appId
        // int accountType: 直播 accountType
        // Android: https://www.qcloud.com/document/product/268/7685#1-.E5.88.9D.E5.A7.8B.E5.8C.96
        cordova.exec(
            successCallback,
            errorCallback,
            "TencentILVB",
            "initSdk",
            [appId, accountType]
        );
    },
    iLiveLogin: function (id, sig, successCallback, errorCallback) {
        // 账号登录
        // string id: 用户id,在直播过程中的唯一标识
        // string sig: 鉴权的密钥Sig 如果是独立登录方式，是业务方后台计算生成后下发的
        // Android: https://www.qcloud.com/document/product/268/7685#2-.E8.B4.A6.E5.8F.B7.E7.99.BB.E5.BD.95
        cordova.exec(
            successCallback,
            errorCallback,
            "TencentILVB",
            "iLiveLogin",
            [id, sig]
        );
    },
    createRoom: function (id, option, successCallback, errorCallback) {
        // 创建房间
        // string id: 房间id,房间唯一标识，建议由业务方后台统一分配
        // string option: 房间配置项 可以设置角色 权限 主播ID 摄像头参数等 具体参考类ILiveRoomOption
        // Android: https://www.qcloud.com/document/product/268/7685#3-.E5.88.9B.E5.BB.BA.E6.88.BF.E9.97.B4
        cordova.exec(
            successCallback,
            errorCallback,
            "TencentILVB",
            "createRoom",
            [id, sig]
        );
    },
    joinRoom: function (id, option, successCallback, errorCallback) {
        // 加入房间
        // string id: 房间id,房间唯一标识，建议由业务方后台统一分配
        // string option: 房间配置项 可以设置角色 权限 主播ID 摄像头参数等 具体参考类ILiveRoomOption
        // Android: https://www.qcloud.com/document/product/268/7685#4-.E5.8A.A0.E5.85.A5.E6.88.BF.E9.97.B4
        cordova.exec(
            successCallback,
            errorCallback,
            "TencentILVB",
            "createRoom",
            [id, sig]
        );
    },
};
