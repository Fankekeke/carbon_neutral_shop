
const http = require("../../../utils/request");
const app = getApp();
Page({
    data: {
        StatusBar: app.globalData.StatusBar,
        CustomBar: app.globalData.CustomBar,
        TabbarBot: app.globalData.tabbar_bottom,
        TabCur: 1,scrollLeft:0,
        SortMenu: [{id:1,name:"使用中"},{id:2,name:"已失效"}],
        userInfo: null,
        userDetail: null,
        materialInfoList: []
    },
    onLoad: function (options) {
        let that = this;
        wx.getStorage({
            key: 'userInfo',
            success: (res) => {
                this.setData({
                    userInfo: res.data
                })
                this.queryMaterialInfoList()
                this.queryUserInfo(res.data.id)
            },
            fail: res => {
                wx.showToast({
                    title: '请先进行登录',
                    icon: 'none',
                    duration: 2000
                })
            }
        })
    },
    queryUserInfo(userId) {
        http.get('queryUserDetail', { userId }).then((r) => {
            this.setData({ userDetail: r.data })
        })
    },
    queryMaterialInfoList() {
        http.get('queryMaterialInfoList').then((r) => {
            this.setData({ materialInfoList: r.data })
        })
    },
    tabSelect(e) {
        console.log(e.currentTarget.dataset.id);
        this.setData({
            TabCur: e.currentTarget.dataset.id,
            scrollLeft: (e.currentTarget.dataset.id-1)*60
        })
    },
    // 兑换商品功能
    exchangeMaterial(e) {
        const material = e.currentTarget.dataset.material;
        const that = this;

        // 检查用户积分是否足够
        if (this.data.userDetail && this.data.userDetail.integral < material.integral) {
            wx.showToast({
                title: '积分不足',
                icon: 'none',
                duration: 2000
            });
            return;
        }

        wx.showModal({
            title: '确认兑换',
            content: `确定要兑换"${material.name}"吗？需要${material.integral}积分`,
            success(res) {
                if (res.confirm) {
                    // 调用兑换接口
                    http.post('exchangeInfoAdd', {
                        materialId: material.id,
                        userId: that.data.userInfo.id,
                        integral: material.integral
                    }).then((result) => {
                        if (result.code === 0) {
                            wx.showToast({
                                title: '兑换成功',
                                icon: 'success',
                                duration: 2000
                            });
                            // 更新用户积分
                            that.queryUserInfo(that.data.userInfo.id);
                            // 刷新商品列表
                            that.queryMaterialInfoList();
                        } else {
                            wx.showToast({
                                title: result.msg || '兑换失败',
                                icon: 'none',
                                duration: 2000
                            });
                        }
                    }).catch(error => {
                        wx.showToast({
                            title: '网络错误',
                            icon: 'none',
                            duration: 2000
                        });
                    });
                }
            }
        })
    },
    // 显示积分明细
    showIntegralDetail() {
        wx.navigateTo({
            url: '/pages/user/detail/index'
        });
    }
});
