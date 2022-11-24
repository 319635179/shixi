<template>
    <div class="shop">
        <div class="shopTop">
            <div class="shopTopMes">购物车</div>
            <div class="shopTopRight">
                <div class="STRMes">编辑</div>
                <div class="STRBut el-icon-s-comment"></div>
            </div>
        </div>
        <div class="shopMes">
            <div class="shopMesTop" v-if="isShopMesTop">
                <span class="el-icon-message-solid"></span>
                您有一件商品降价了！
                <div @click="isShopMesTop = false">X</div>
            </div>
            <!-- test -->
            <div class="Ashop" v-for="(data, i) in Data" :key="data.id">
                <div class="AshopTop">
                    <div class="shopAllSelect" @click="setAllSelect(i)"
                        :style="data.isAllSelect ? '' : { backgroundColor: 'white', border: '1px solid lightblue' }">
                        <div class="el-icon-check"></div>
                    </div>
                    <div class="AshopTopMes">{{ data.shopname }}</div>
                    <div class="AshopTopRight">
                        <div class="isFree">
                            <div class="el-icon-warning-outline"></div>已免运费
                        </div>
                        <div class="getFree">领券</div>
                    </div>
                </div>
                <!-- test -->
                <div class="AshopBody" v-for="(item, j) in data.data" :key="item.id">
                    <div class="AshopBodySelect">
                        <div class="shopSelect" @click="setSelect(i, j)"
                            :style="item.isSelect ? '' : { backgroundColor: 'white', border: '1px solid lightblue' }">
                            <div class="el-icon-check"></div>
                        </div>
                    </div>
                    <div class="AshopBodyImg">
                        <img class="shopBodyImg" src="@/assets/shopImg/2]JL9F6~2E$9AW)2DWQD4DK.png" alt="">
                    </div>
                    <div class="AshopBodyMes">
                        <div class="goodsTitle">{{ item.name }}
                        </div>
                        <div class="goodsSelect">{{ item.nowSelect }}<span class="el-icon-arrow-down"></span>
                        </div>
                        <div class="goodsWelfare">{{ item.welfare }}</div>
                        <div class="goodsPriceAndNum">￥{{ item.price }}</div>
                        <div class="notOnePrice" v-if="item.joinPrice > item.price">
                            这件宝贝降价了{{ item.joinPrice - item.price }}元!
                        </div>
                    </div>
                </div>
                <!-- test -->
            </div>
            <!-- test -->
        </div>
        <div class="shopDownMes">
            <div class="SelectAll" @click.stop="SelectAll">
                <div class="shopAllSelect"
                    :style="selectAll ? '' : { backgroundColor: 'white', border: '1px solid lightblue' }">
                    <div class="el-icon-check"></div>
                </div>
                <div style="margin: 3vw; font-size: 12px; color: gray;">全选</div>
            </div>
        </div>
        <div class="toShop">
            <div>
                合计:
                <div class="allPrice">￥{{ allPrice.toFixed(2) }}</div>
            </div>
            <button>结算</button>
        </div>
    </div>
</template>

<script>

export default {
    name: 'shopView',
    data() {
        return {
            isShopMesTop: true,
            Data: [
                {
                    id: 0, shopname: '有品精选', isAllSelect: false, data: [
                        { id: 0, name: '香菇酱红葱酱拌饭酱肉燥酱系列原味210g*2', nowSelect: '原味210g*2', welfare: '7天价保 包邮', price: 35, isSelect: false, joinPrice: 35 },
                        { id: 1, name: '手机10部', nowSelect: '随机盲盒*1', welfare: '30天价保 包邮', price: 10088, isSelect: false, joinPrice: 11988 },
                        { id: 2, name: '过大年限定系列手办', nowSelect: '梅花鹿*1', welfare: '7天价保 包邮', price: 398.99, isSelect: false, joinPrice: 398.99 },
                    ]
                }, {
                    id: 1, shopname: '自营产品', isAllSelect: false, data: [
                        { id: 0, name: '剁椒鱼头酱料', nowSelect: '500g*5', welfare: '14天价保 包邮', price: 98, isSelect: false, joinPrice: 98 },
                        { id: 1, name: '新品电脑', nowSelect: 'RTX4090-12代i9*1', welfare: '30天价保 包邮', price: 19088, isSelect: false, joinPrice: 19088 },
                    ]
                }
            ],
            selectAll: false
        }
    },
    methods: {
        setSelect(i, j) {
            this.Data[i].data[j].isSelect = !this.Data[i].data[j].isSelect;
            if (this.getAShopAllSelect(i)) this.Data[i].isAllSelect = true;
            else this.Data[i].isAllSelect = false;
            this.isSelectAll();
        },
        getAShopAllSelect(i) {
            for (let j of this.Data[i].data) {
                if (!j.isSelect) {
                    this.selectAll = false;
                    return false;
                }
            }
            this.isSelectAll();
            return true;
        },
        setAllSelect(i) {
            const nowSet = !this.Data[i].isAllSelect;
            if (!nowSet) this.selectAll = false;
            for (let j in this.Data[i].data)
                this.Data[i].data[j].isSelect = nowSet;
            this.Data[i].isAllSelect = !this.Data[i].isAllSelect;
            this.isSelectAll();
        },
        SelectAll() {
            const nowSet = !this.selectAll;
            for (let i in this.Data) {
                this.Data[i].isAllSelect = nowSet;
                for (let j in this.Data[i].data)
                    this.Data[i].data[j].isSelect = nowSet;
            }
            this.selectAll = nowSet;
        },
        isSelectAll() {
            for (let i in this.Data) {
                if (this.Data[i].isAllSelect === false) return false;
            }
            this.selectAll = true;
            return true;
        }
    },
    computed: {
        allPrice() {
            let pri = 0;
            for (let i in this.Data) {
                for (let j in this.Data[i].data)
                    if (this.Data[i].data[j].isSelect === true) pri += this.Data[i].data[j].price;
            }
            return pri;
        }
    }
}

</script>

<style scoped>
* {
    box-sizing: border-box;
}

.shop {
    background-color: whitesmoke;
}

.shopTop {
    width: 100vw;
    height: 6vh;
    display: flex;
    justify-content: center;
    align-items: center;
    position: fixed;
    top: 0px;
    background-color: whitesmoke;
    /* box-shadow: 0px 0px 3px gray; */
}

.shopMesTop {
    background-color: #FEE6E6;
    padding: 0 5vw 0 5vw;
    height: 5vh;
    border-radius: 5px;
    line-height: 5vh;
    font-size: 2vh;
    color: rgb(211, 14, 14);
}

.shopMesTop>div {
    position: absolute;
    right: 5vw;
    top: 1vh;
    line-height: 5vh;
}

.shopTopMes {
    line-height: 6vh;
    font-size: 2.5vh;
    font-weight: 800;
    color: chocolate;
}

.shopTopRight {
    position: absolute;
    right: 3vw;
    display: flex;
}

.STRMes,
.STRBut {
    margin: 0 1vw 0 2vw;
}

.STRMes {
    font-size: 2vh;
}

.STRBut {
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 2.5vh;
}

.shopMes {
    overflow: auto;
    width: 100vw;
    height: 77vh;
    position: fixed;
    top: 6vh;
    padding: 1vh 3vw 1vh 3vw;
    background-color: whitesmoke;
}

.Ashop {
    width: 100%;
    margin: 2vh 0 0 0;
    border-radius: 3vw;
    overflow: hidden;
}

.Ashop:nth-child(1),
.Ashop:nth-child(2) {
    margin: 1vh 0 0 0;
}

.AshopTop {
    width: 100%;
    height: 6vh;
    display: flex;
    align-items: center;
    background-color: white;
    border-radius: 3vw 3vw 0 0;
}

.shopAllSelect {
    width: 5vw;
    height: 5vw;
    border-radius: 2.5vw;
    background-color: chocolate;
    margin-left: 5vw;
    display: flex;
    justify-content: center;
    align-items: center;
    color: white;
    font-size: 12px;
}

.AshopTopMes {
    margin-left: 4vw;
    font-size: 4vw;
    font-weight: 800;
}

.AshopTopRight {
    position: absolute;
    right: 5vw;
    display: flex;
    font-size: 3vw;
}

.isFree {
    padding-right: 2vw;
    border-right: 1px solid gray;
}

.getFree {
    padding-left: 2vw;
    color: chocolate;
}

.AshopBody {
    width: 100%;
    /* height: 14vh; */
    display: flex;
    background-color: white;
    padding: 1vh 0 1vh 0;
}

.AshopBodySelect {
    width: 12%;
    display: flex;
    /* align-items: center; */
}

.shopSelect {
    width: 5vw;
    height: 5vw;
    border-radius: 50%;
    margin-left: 5vw;
    margin-top: 8.78vw;
    background-color: chocolate;
    display: flex;
    justify-content: center;
    align-items: center;
    color: white;
    font-size: 12px;
}

.AshopBodyImg {
    width: 28.2vw;
    display: flex;
    justify-content: center;
}

.shopBodyImg {
    width: 22.56vw;
    height: 22.56vw;
}

.AshopBodyMes {
    width: 58%;
    padding: 0 3vw 0 0;
    /* display: flex;
    flex-shrink: 0;
    flex-wrap: wrap; */
}

.goodsTitle {
    font-size: 2.0vh;
}

.goodsSelect,
.goodsWelfare {
    font-size: 12px;
}

.goodsSelect {
    /* width: 55%; */
    margin: 0.5vh 0 0.5vh 0;
    padding: 0.2vh 1vw 0.2vh 1vw;
    border-radius: 3px;
    background-color: rgba(214, 214, 214, 0.445);
}

.goodsWelfare {
    /* width: 50%; */
    border-radius: 8px;
    padding: 0 1vw 0 1vw;
    border: 1px solid rgb(0, 162, 255);
    color: rgb(0, 162, 255);
    display: flex;
    justify-content: center;
}

.goodsSelect span {
    float: right;
    line-height: 100%;
}

.goodsPriceAndNum {
    color: rgb(209, 0, 0);
    font-weight: 800;
}

.notOnePrice {
    font-size: 12px;
    padding: 0.5vh 2vw 0.5vh 2vw;
    border-radius: 3px;
    background-color: #FEE6E6;
    color: rgb(209, 0, 0);
}

.shopDownMes {
    width: 100vw;
    height: 8vh;
    background-color: white;
    position: fixed;
    bottom: 9vh;
    border-top: 1px solid rgba(179, 179, 179, 0.788);
    z-index: 69;
}

.SelectAll {
    height: 100%;
    display: flex;
    align-items: center;
}

.toShop {
    z-index: 70;
    position: absolute;
    bottom: 9vh;
    right: 5vw;
    display: flex;
    align-items: center;
    height: 8vh;
}

.toShop>button {
    height: 60%;
    width: 28vw;
    background-color: red;
    border-radius: 2.4vh;
    border: 0;
    color: white;
}

.toShop>div {
    font-size: 14px;
    margin-right: 3vw;
    display: flex;
}

.toShop>div>.allPrice {
    color: red;
}
</style>