<template>
    <div class="MoreView">
        <div class="MoreTop">
            <div class="MoreTopMes">分类</div>
            <div class="el-icon-search MoreTopSearch"></div>
        </div>
        <div class="MoreDown">
            <div class="MoreLeft">
                <div class="ListName" v-for="(List, i) in ListName" :key="List.id">
                    <div class="ListNameMes" @click="setNowList(i)" :style="ListNameStyle[i]">{{ List.name }}</div>
                </div>
            </div>
            <div class="MoreRight">
                <img class="MoreRightImg" src="@/assets/moreTopImg.jpg" alt="">
                <div class="LargeListData" v-for="Data in ListData" :key="Data.id">
                    <div class="DataTitle">{{ Data.name }}</div>
                    <div class="DownData">
                        <div class="SmallListData" v-for="data in Data.data" :key="data.id">
                            <div class="DataImg">
                                <img class="DataImgImg" src="@/assets/logo.png" alt="">
                            </div>
                            <div class="DataName">{{ data.name }}</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>

export default {
    name: 'MoreView',
    data() {
        return {
            ListName: [
                {
                    id: 0, name: '推荐', data: [
                        {
                            id: 0, name: '精选分类', data: [
                                { id: 0, name: '平板', url: '/', pic: '' },
                                { id: 1, name: '手机', url: '/', pic: '' },
                                { id: 2, name: '电视', url: '/', pic: '' },
                                { id: 3, name: '笔记本', url: '/', pic: '' },
                                { id: 4, name: '平板', url: '/', pic: '' },
                                { id: 5, name: '手机', url: '/', pic: '' },
                                { id: 6, name: '电视', url: '/', pic: '' },
                                { id: 7, name: '笔记本', url: '/', pic: '' },
                            ]
                        }, {
                            id: 1, name: '精选专区', data: [
                                { id: 0, name: '换季保暖', url: '/', pic: '' },
                                { id: 1, name: '净化器', url: '/', pic: '' },
                                { id: 2, name: '加湿器', url: '/', pic: '' },
                                { id: 3, name: '耳机', url: '/', pic: '' },
                            ]
                        }, {
                            id: 2, name: '精选分类', data: [
                                { id: 0, name: '平板', url: '/', pic: '' },
                                { id: 1, name: '手机', url: '/', pic: '' },
                                { id: 2, name: '电视', url: '/', pic: '' },
                                { id: 3, name: '笔记本', url: '/', pic: '' },
                                { id: 4, name: '平板', url: '/', pic: '' },
                                { id: 5, name: '手机', url: '/', pic: '' },
                                { id: 6, name: '电视', url: '/', pic: '' },
                                { id: 7, name: '笔记本', url: '/', pic: '' },
                            ]
                        },
                    ]
                },
                {
                    id: 1, name: '日常元素', data: [
                        {
                            id: 0, name: '精选分类', data: [
                                { id: 0, name: '平板', url: '/', pic: '' },
                                { id: 1, name: '手机', url: '/', pic: '' },
                                { id: 2, name: '电视', url: '/', pic: '' },
                                { id: 3, name: '笔记本', url: '/', pic: '' },
                            ]
                        }, {
                            id: 1, name: '精选专区', data: [
                                { id: 0, name: '换季保暖', url: '/', pic: '' },
                                { id: 1, name: '净化器', url: '/', pic: '' },
                                { id: 2, name: '加湿器', url: '/', pic: '' },
                                { id: 3, name: '耳机', url: '/', pic: '' },
                            ]
                        }]
                },
                {
                    id: 2, name: '自营产品', data: [
                        {
                            id: 0, name: '精选分类', data: [
                                { id: 0, name: '平板', url: '/', pic: '' },
                                { id: 1, name: '手机', url: '/', pic: '' },
                                { id: 2, name: '电视', url: '/', pic: '' },
                                { id: 3, name: '笔记本', url: '/', pic: '' },
                            ]
                        }, {
                            id: 1, name: '精选专区', data: [
                                { id: 0, name: '换季保暖', url: '/', pic: '' },
                                { id: 1, name: '净化器', url: '/', pic: '' },
                                { id: 2, name: '加湿器', url: '/', pic: '' },
                                { id: 3, name: '耳机', url: '/', pic: '' },
                            ]
                        }]
                },
                {
                    id: 3, name: '手机数码', data: [
                        {
                            id: 0, name: '精选分类', data: [
                                { id: 0, name: '平板', url: '/', pic: '' },
                                { id: 1, name: '手机', url: '/', pic: '' },
                                { id: 2, name: '电视', url: '/', pic: '' },
                                { id: 3, name: '笔记本', url: '/', pic: '' },
                            ]
                        }, {
                            id: 1, name: '精选专区', data: [
                                { id: 0, name: '换季保暖', url: '/', pic: '' },
                                { id: 1, name: '净化器', url: '/', pic: '' },
                                { id: 2, name: '加湿器', url: '/', pic: '' },
                                { id: 3, name: '耳机', url: '/', pic: '' },
                            ]
                        }]
                },
                {
                    id: 4, name: '电视电脑', data: [
                        {
                            id: 0, name: '精选分类', data: [
                                { id: 0, name: '平板', url: '/', pic: '' },
                                { id: 1, name: '手机', url: '/', pic: '' },
                                { id: 2, name: '电视', url: '/', pic: '' },
                                { id: 3, name: '笔记本', url: '/', pic: '' },
                            ]
                        }, {
                            id: 1, name: '精选专区', data: [
                                { id: 0, name: '换季保暖', url: '/', pic: '' },
                                { id: 1, name: '净化器', url: '/', pic: '' },
                                { id: 2, name: '加湿器', url: '/', pic: '' },
                                { id: 3, name: '耳机', url: '/', pic: '' },
                            ]
                        }]
                },
                {
                    id: 5, name: '大家电', data: [
                        {
                            id: 0, name: '精选分类', data: [
                                { id: 0, name: '平板', url: '/', pic: '' },
                                { id: 1, name: '手机', url: '/', pic: '' },
                                { id: 2, name: '电视', url: '/', pic: '' },
                                { id: 3, name: '笔记本', url: '/', pic: '' },
                            ]
                        }, {
                            id: 1, name: '精选专区', data: [
                                { id: 0, name: '换季保暖', url: '/', pic: '' },
                                { id: 1, name: '净化器', url: '/', pic: '' },
                                { id: 2, name: '加湿器', url: '/', pic: '' },
                                { id: 3, name: '耳机', url: '/', pic: '' },
                            ]
                        }]
                },
                {
                    id: 6, name: '小家电', data: [
                        {
                            id: 0, name: '精选分类', data: [
                                { id: 0, name: '平板', url: '/', pic: '' },
                                { id: 1, name: '手机', url: '/', pic: '' },
                                { id: 2, name: '电视', url: '/', pic: '' },
                                { id: 3, name: '笔记本', url: '/', pic: '' },
                            ]
                        }, {
                            id: 1, name: '精选专区', data: [
                                { id: 0, name: '换季保暖', url: '/', pic: '' },
                                { id: 1, name: '净化器', url: '/', pic: '' },
                                { id: 2, name: '加湿器', url: '/', pic: '' },
                                { id: 3, name: '耳机', url: '/', pic: '' },
                            ]
                        }]
                },
                {
                    id: 7, name: '美酒饮食', data: [
                        {
                            id: 0, name: '精选分类', data: [
                                { id: 0, name: '平板', url: '/', pic: '' },
                                { id: 1, name: '手机', url: '/', pic: '' },
                                { id: 2, name: '电视', url: '/', pic: '' },
                                { id: 3, name: '笔记本', url: '/', pic: '' },
                            ]
                        }, {
                            id: 1, name: '精选专区', data: [
                                { id: 0, name: '换季保暖', url: '/', pic: '' },
                                { id: 1, name: '净化器', url: '/', pic: '' },
                                { id: 2, name: '加湿器', url: '/', pic: '' },
                                { id: 3, name: '耳机', url: '/', pic: '' },
                            ]
                        }]
                },
                {
                    id: 8, name: '出行车品', data: [
                        {
                            id: 0, name: '精选分类', data: [
                                { id: 0, name: '平板', url: '/', pic: '' },
                                { id: 1, name: '手机', url: '/', pic: '' },
                                { id: 2, name: '电视', url: '/', pic: '' },
                                { id: 3, name: '笔记本', url: '/', pic: '' },
                            ]
                        }, {
                            id: 1, name: '精选专区', data: [
                                { id: 0, name: '换季保暖', url: '/', pic: '' },
                                { id: 1, name: '净化器', url: '/', pic: '' },
                                { id: 2, name: '加湿器', url: '/', pic: '' },
                                { id: 3, name: '耳机', url: '/', pic: '' },
                            ]
                        }]
                },
                {
                    id: 9, name: '运动户外', data: [
                        {
                            id: 0, name: '精选分类', data: [
                                { id: 0, name: '平板', url: '/', pic: '' },
                                { id: 1, name: '手机', url: '/', pic: '' },
                                { id: 2, name: '电视', url: '/', pic: '' },
                                { id: 3, name: '笔记本', url: '/', pic: '' },
                            ]
                        }, {
                            id: 1, name: '精选专区', data: [
                                { id: 0, name: '换季保暖', url: '/', pic: '' },
                                { id: 1, name: '净化器', url: '/', pic: '' },
                                { id: 2, name: '加湿器', url: '/', pic: '' },
                                { id: 3, name: '耳机', url: '/', pic: '' },
                            ]
                        }]
                },
                {
                    id: 10, name: '医疗健康', data: [
                        {
                            id: 0, name: '精选分类', data: [
                                { id: 0, name: '平板', url: '/', pic: '' },
                                { id: 1, name: '手机', url: '/', pic: '' },
                                { id: 2, name: '电视', url: '/', pic: '' },
                                { id: 3, name: '笔记本', url: '/', pic: '' },
                            ]
                        }, {
                            id: 1, name: '精选专区', data: [
                                { id: 0, name: '换季保暖', url: '/', pic: '' },
                                { id: 1, name: '净化器', url: '/', pic: '' },
                                { id: 2, name: '加湿器', url: '/', pic: '' },
                                { id: 3, name: '耳机', url: '/', pic: '' },
                            ]
                        }]
                },
                {
                    id: 11, name: '家居家装', data: [
                        {
                            id: 0, name: '精选分类', data: [
                                { id: 0, name: '平板', url: '/', pic: '' },
                                { id: 1, name: '手机', url: '/', pic: '' },
                                { id: 2, name: '电视', url: '/', pic: '' },
                                { id: 3, name: '笔记本', url: '/', pic: '' },
                            ]
                        }, {
                            id: 1, name: '精选专区', data: [
                                { id: 0, name: '换季保暖', url: '/', pic: '' },
                                { id: 1, name: '净化器', url: '/', pic: '' },
                                { id: 2, name: '加湿器', url: '/', pic: '' },
                                { id: 3, name: '耳机', url: '/', pic: '' },
                            ]
                        }]
                },
                {
                    id: 12, name: '家纺厨具', data: [
                        {
                            id: 0, name: '精选分类', data: [
                                { id: 0, name: '平板', url: '/', pic: '' },
                                { id: 1, name: '手机', url: '/', pic: '' },
                                { id: 2, name: '电视', url: '/', pic: '' },
                                { id: 3, name: '笔记本', url: '/', pic: '' },
                            ]
                        }, {
                            id: 1, name: '精选专区', data: [
                                { id: 0, name: '换季保暖', url: '/', pic: '' },
                                { id: 1, name: '净化器', url: '/', pic: '' },
                                { id: 2, name: '加湿器', url: '/', pic: '' },
                                { id: 3, name: '耳机', url: '/', pic: '' },
                            ]
                        }]
                },
                {
                    id: 13, name: '日用百货', data: [
                        {
                            id: 0, name: '精选分类', data: [
                                { id: 0, name: '平板', url: '/', pic: '' },
                                { id: 1, name: '手机', url: '/', pic: '' },
                                { id: 2, name: '电视', url: '/', pic: '' },
                                { id: 3, name: '笔记本', url: '/', pic: '' },
                            ]
                        }, {
                            id: 1, name: '精选专区', data: [
                                { id: 0, name: '换季保暖', url: '/', pic: '' },
                                { id: 1, name: '净化器', url: '/', pic: '' },
                                { id: 2, name: '加湿器', url: '/', pic: '' },
                                { id: 3, name: '耳机', url: '/', pic: '' },
                            ]
                        }]
                },
                {
                    id: 14, name: '服装配饰', data: [
                        {
                            id: 0, name: '精选分类', data: [
                                { id: 0, name: '平板', url: '/', pic: '' },
                                { id: 1, name: '手机', url: '/', pic: '' },
                                { id: 2, name: '电视', url: '/', pic: '' },
                                { id: 3, name: '笔记本', url: '/', pic: '' },
                            ]
                        }, {
                            id: 1, name: '精选专区', data: [
                                { id: 0, name: '换季保暖', url: '/', pic: '' },
                                { id: 1, name: '净化器', url: '/', pic: '' },
                                { id: 2, name: '加湿器', url: '/', pic: '' },
                                { id: 3, name: '耳机', url: '/', pic: '' },
                            ]
                        }]
                },
                {
                    id: 15, name: '鞋靴箱包', data: [
                        {
                            id: 0, name: '精选分类', data: [
                                { id: 0, name: '平板', url: '/', pic: '' },
                                { id: 1, name: '手机', url: '/', pic: '' },
                                { id: 2, name: '电视', url: '/', pic: '' },
                                { id: 3, name: '笔记本', url: '/', pic: '' },
                            ]
                        }, {
                            id: 1, name: '精选专区', data: [
                                { id: 0, name: '换季保暖', url: '/', pic: '' },
                                { id: 1, name: '净化器', url: '/', pic: '' },
                                { id: 2, name: '加湿器', url: '/', pic: '' },
                                { id: 3, name: '耳机', url: '/', pic: '' },
                            ]
                        }]
                },
                {
                    id: 16, name: '手表配饰', data: [
                        {
                            id: 0, name: '精选分类', data: [
                                { id: 0, name: '平板', url: '/', pic: '' },
                                { id: 1, name: '手机', url: '/', pic: '' },
                                { id: 2, name: '电视', url: '/', pic: '' },
                                { id: 3, name: '笔记本', url: '/', pic: '' },
                            ]
                        }, {
                            id: 1, name: '精选专区', data: [
                                { id: 0, name: '换季保暖', url: '/', pic: '' },
                                { id: 1, name: '净化器', url: '/', pic: '' },
                                { id: 2, name: '加湿器', url: '/', pic: '' },
                                { id: 3, name: '耳机', url: '/', pic: '' },
                            ]
                        }]
                },
                {
                    id: 17, name: '美妆个护', data: [
                        {
                            id: 0, name: '精选分类', data: [
                                { id: 0, name: '平板', url: '/', pic: '' },
                                { id: 1, name: '手机', url: '/', pic: '' },
                                { id: 2, name: '电视', url: '/', pic: '' },
                                { id: 3, name: '笔记本', url: '/', pic: '' },
                            ]
                        }, {
                            id: 1, name: '精选专区', data: [
                                { id: 0, name: '换季保暖', url: '/', pic: '' },
                                { id: 1, name: '净化器', url: '/', pic: '' },
                                { id: 2, name: '加湿器', url: '/', pic: '' },
                                { id: 3, name: '耳机', url: '/', pic: '' },
                            ]
                        }]
                },
                {
                    id: 18, name: '母婴亲子', data: [
                        {
                            id: 0, name: '精选分类', data: [
                                { id: 0, name: '平板', url: '/', pic: '' },
                                { id: 1, name: '手机', url: '/', pic: '' },
                                { id: 2, name: '电视', url: '/', pic: '' },
                                { id: 3, name: '笔记本', url: '/', pic: '' },
                            ]
                        }, {
                            id: 1, name: '精选专区', data: [
                                { id: 0, name: '换季保暖', url: '/', pic: '' },
                                { id: 1, name: '净化器', url: '/', pic: '' },
                                { id: 2, name: '加湿器', url: '/', pic: '' },
                                { id: 3, name: '耳机', url: '/', pic: '' },
                            ]
                        }]
                },
            ],
            ListData: [],
            nowList: 0,
            ListNameStyle: [{ backgroundColor: 'rgb(194, 117, 2)', color: 'whitesmoke' }]
        }
    },
    mounted() {
        for (let i = 0; i < this.ListName.length; i++) {
            this.ListNameStyle.push({ backgroundColor: '', color: 'black' })
        }
        this.setNowList(0);
    },
    methods: {
        setNowList(i) {
            this.ListNameStyle[this.nowList].backgroundColor = '';
            this.ListNameStyle[this.nowList].color = 'black';
            this.nowList = i;
            this.ListNameStyle[this.nowList].backgroundColor = 'rgb(194, 117, 2)';
            this.ListNameStyle[this.nowList].color = 'whitesmoke';

            this.ListData = this.ListName[i].data;
        }
    }
}

</script>

<style scoped>
* {
    box-sizing: border-box;
}

.MoreView {
    width: 100vw;
    display: inline;
}

.MoreTop {
    height: 5vh;
    width: 100vw;
    background-color: white;
    margin-bottom: 1vh;
    display: flex;
    justify-content: center;
    align-items: center;
    position: fixed;
    top: 0;
}

.MoreTopMes {
    position: relative;
    top: 0.5vh;
    font-weight: 900;
    color: chocolate;
}

.MoreTopSearch {
    position: absolute;
    line-height: 6vh;
    right: 5vw;
    width: 3vh;
    height: 5vh;
    font-weight: 800;
    color: chocolate;
}

.MoreDown {
    width: 100vw;
    display: flex;
    position: fixed;
    top: 6vh;
}

.MoreLeft {
    overflow: auto;
    height: 85vh;
    width: 33vw;
    background-color: white;
    position: sticky;
    box-sizing: border-box;
    border-radius: 5px;
    /* top: 0px; */
}

.ListName {
    height: 8vh;
    display: flex;
    align-items: center;
    justify-content: center;
}

.ListNameMes {
    width: 80%;
    height: 55%;
    border-radius: 2.4vh;
    display: flex;
    align-items: center;
    justify-content: center;
    /* background-color: rgb(194, 117, 2); */
    /* color: whitesmoke; */
}

.MoreRight {
    overflow: auto;
    width: 67vw;
    height: 85vh;
    background-color: rgba(245, 245, 245, 0.596);
    position: sticky;
    padding: 0 2% 0 2%;
}

.MoreRightImg {
    border-radius: 5px;
    overflow: hidden;
    width: 100%;
    margin-top: 1vh;
}

.LargeListData {
    width: 100%;
    background-color: white;
    border-radius: 5%;
    padding: 3vw;
    margin: 1vh 0 1vh 0;
    box-sizing: border-box;
    overflow: hidden;
    display: flex;
    flex-shrink: 0;
    flex-wrap: wrap;
}

.DataTitle {
    width: 100%;
    height: 4vh;
    font-weight: 800;
    line-height: 70%;
    font-size: 90%;
    margin-bottom: 1vh;
    display: flex;
    align-items: center;
}

.DownData {
    width: 100%;
    display: flex;
    flex-wrap: wrap;
    flex-shrink: 0;
    color: rgb(87, 87, 87);
    font-weight: 500;
}

.SmallListData {
    width: 33.33%;
    height: 12vh;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-shrink: 0;
    flex-wrap: wrap;
    margin-bottom: 3px;
    border-radius: 3px;
    padding: 3px;
}

.DataImg {
    width: 80%;
    height: 0;
    padding-bottom: 80%;
    border-radius: 50%;
    overflow: hidden;
    /* background-color: rgb(118, 105, 235); */
}

.DataImgImg {
    z-index: 78;
    width: 100%;
}

.DataName {
    display: flex;
    justify-content: center;
    align-items: center;
    line-height: 16px;
    font-size: 12px;
}
</style>