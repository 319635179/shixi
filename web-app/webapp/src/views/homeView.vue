<template>
    <div class="homeView">
        <div class="HomeHeader">
            <div class="myPosition">
                <div class="el-icon-location-outline"></div>
                <div class="Aposition">河南-郑州</div>
            </div>
            <div class="Allserch">
                <input class="searchInp" type="search" placeholder="Search" aria-label="Search">
                <button class="searchButton" type="submit">搜索</button>
            </div>
        </div>
        <div class="swiper">
            <div class="swiperFor">
                <div class="swiperImg" v-for="img in imgs" :key="img.id" :style="imgstyle">
                    <img :src="img.pic" alt="">
                </div>
                <div class="imgButton">
                    <div class="imgItem" v-for="(img, i) in imgs" :key="img.id" :style="imgItemStyle[i]"></div>
                </div>
            </div>
        </div>
        <div class="menusDisplay">
            <div class="oneMenu" v-for="menu in menus" :key="menu.id">
                <img :src="menu.pic" alt="">
                <div class="show">{{ menu.name }}</div>
            </div>
        </div>
        <div class="tuijianTitle">
            <div class="tuijianMes">推荐</div>
            <div class="el-icon-s-operation tuijianButton"></div>
        </div>
        <div class="ShopList">
            <div class="Ashop" v-for="(shop, i) in ListData.data" :key="i">
                <img class="shopImg" :src="shop.url" alt="">
                <div class="rightShopMes">
                    <div class="shopTitle" :style="shopStyle[i]">{{ shop.title }}</div>
                    <div class="shopMes">
                        <div v-html="shop.price" class="shopPrice"></div>
                        <div class="shopMarket">{{ shop.market }}</div>
                    </div>

                </div>

            </div>
        </div>
    </div>
</template>

<script>
import $ from 'jquery';
export default {
    name: 'HomeView',
    data() {
        return {
            imgs: [],
            nowImg: 0,
            imgstyle: {
                transform: 'translateX(calc(0%))'
            },
            menus: [],
            ListData: { data: [{ url: "http://p0.meituan.net/scpdeal/805885a761d293db0d371a792ac148f423289.jpg", title: "蜜雪冰城", desc: "[多城市]招牌柠檬水", price: "2.99<span class=\"price-unit\">元</span>", market: "门市价:¥4" }, { url: "http://p1.meituan.net/deal/8d5f77d0b08b88ddfc7f31434e0b9c0c173511.jpg", title: "茶百道", desc: "[多城市]爆品-冷萃茶 2 选 1", price: "6.66<span class=\"price-unit\">元</span>", market: "门市价:¥8" }, { url: "http://p0.meituan.net/scpdeal/8c6c9cc6eacfdba00bc05c30a07d35b1135145.jpg", title: "甜啦啦", desc: "[多城市]酸奶冰淇淋", price: "1.66<span class=\"price-unit\">元</span>", market: "门市价:¥3" }, { url: "http://p0.meituan.net/deal/1ef13b6262c3eaf3c42127ed7fc61a01130193.jpg", title: "华莱士·全鸡汉堡", desc: "[多城市]双堡炸鸡桶", price: "40.8<span class=\"price-unit\">元</span>", market: "门市价:¥75" }, { url: "http://p0.meituan.net/deal/80f44c1eec7544dc77aa52fca780295c152320.jpg", title: "贤合庄卤味火锅", desc: "[火车站/二七广场]春意盎然特惠双人餐", price: "108<span class=\"price-unit\">元</span>", market: "门市价:¥182" }, { url: "http://p0.meituan.net/deal/45329ac7e451661339c5ad8ec507051e21604.jpg", title: "格瑞欧海鲜自助烤肉火锅", desc: "[大上海城]全天自助套餐", price: "64.9<span class=\"price-unit\">元</span>", market: "门市价:¥89" }, { url: "http://p0.meituan.net/deal/487a67380a713035280db6d77ba27508117285.jpg", title: "喜姐炸串", desc: "[多城市]脆皮水磨年糕", price: "2<span class=\"price-unit\">元</span>", market: "门市价:¥2.5" }, { url: "http://p0.meituan.net/scpdeal/edb891b1d77562a92517a7bd3625f52a208310.jpg", title: "豪客来牛排", desc: "[多城市]铁板奥尔良鸡排饭", price: "22.9<span class=\"price-unit\">元</span>", market: "门市价:¥36" }, { url: "http://p0.meituan.net/deal/9e10da144275a98d11f199cc74109b7c4046637.png", title: "潮掌门鸭恋虾特色火锅", desc: "[2店通用]豪华螺狮鸭爪爪 2-3 人餐", price: "69.9<span class=\"price-unit\">元</span>", market: "门市价:¥259" }, { url: "http://p1.meituan.net/deal/86ce67b09ef7c50dc4b7f45c2e7a2fda28765.jpg", title: "小龙坎火锅", desc: "[火车站/二七广场]招牌双人餐", price: "115<span class=\"price-unit\">元</span>", market: "门市价:¥210" }, { url: "http://p1.meituan.net/deal/058e66cec06c94faf72e1c03873e06f271202.jpg", title: "项师傅炸鸡汉堡", desc: "[丰业广场/千盛广场]香脆双鸡堡3个", price: "9.6<span class=\"price-unit\">元</span>", market: "门市价:¥15" }, { url: "http://p1.meituan.net/deal/2e9bb2fb71d7b54e0644b111c4d21ea1171289.jpg", title: "胡涂老串串牛油火锅", desc: "[3店通用]五折超值双人餐", price: "99<span class=\"price-unit\">元</span>", market: "门市价:¥159" }, { url: "http://p1.meituan.net/deal/90ed06b6232c76f4bffde4f69a6a80611753811.png", title: "蓉狮叔·川派肥肠鸡·沸腾毛肚鱼", desc: "[火车站/二七广场]招牌肥肠双人餐", price: "39.9<span class=\"price-unit\">元</span>", market: "门市价:¥146" }, { url: "http://p0.meituan.net/deal/b1cf0521bdf7fb03cfa15d340137f3c0175147.jpg", title: "孔一锅牛杂煲", desc: "[12店通用]孔一锅牛杂煲双人餐", price: "98<span class=\"price-unit\">元</span>", market: "门市价:¥127" }, { url: "http://p1.meituan.net/deal/b0ca58eac5408651f5e85f75136cbcb9235598.jpg", title: "地锅根据地", desc: "[西大街]2-3 人餐", price: "88<span class=\"price-unit\">元</span>", market: "门市价:¥146" }, { url: "http://p0.meituan.net/deal/e3e81a5a61d8006fb6833203ea5df29b89955.jpg", title: "王婆大虾·酸菜鱼", desc: "[火车站/二七广场]香辣虾•羊蝎子 1-2 人体验餐", price: "39.9<span class=\"price-unit\">元</span>", market: "门市价:¥75" }, { url: "http://p0.meituan.net/deal/564ef3a5c7346baa79fc0f1a3f1c75f223839.jpg", title: "汉堡王", desc: "[多城市]【双人餐】皇堡+双层脆鸡堡+王道嫩香鸡块+薯霸王（小）+可口可乐（中）*2\n_10614_汉堡王", price: "43.83<span class=\"price-unit\">元</span>", market: "门市价:¥87" }, { url: "http://p1.meituan.net/deal/431f34b691c92d5a6fa5b577f7463bc598390.jpg", title: "全羊鲜汤饸饹面", desc: "[惠济区]饸饹面", price: "8.8<span class=\"price-unit\">元</span>", market: "门市价:¥12" }] },
            shopStyle: [],
            imgItemStyle: [{ backgroundColor: 'rgb(49, 159, 223)' }]
        }
    },
    mounted() {
        setInterval(() => {
            this.imgItemStyle[this.nowImg] = { backgroundColor: 'rgba(0, 0, 0, 0.7)' };
            this.nowImg++;
            this.nowImg %= this.imgs.length;
            this.imgItemStyle[this.nowImg] = { backgroundColor: 'rgb(49, 159, 223)' };
            this.imgstyle.transform = 'translateX(calc(-' + (this.nowImg * 100) + '%))';
        }, 2000);
        $.ajax({
            url: 'https://apif.java.crmeb.net/api/front/index',
            type: 'GET',
            success: resp => {
                this.imgs = resp.data.banner;
                this.menus = resp.data.menus;
            }
        })
        for (let i = 0; i < this.ListData.data.length; i++) {
            if (this.ListData.data[i].title.length > 10) {
                this.shopStyle[i] = {
                    lineHeight: '4vh',
                    fontSize: (2 - (this.ListData.data[i].title.length - 10) / 5) + 'vh',
                    fontWeight: '600',
                }
            }
        }
    },
    methods: {

    }
}

</script>

<style scoped>
* {
    box-sizing: border-box;
}

.HomeHeader {
    box-sizing: border-box;
    height: 7vh;
    min-height: 20px;
    padding: 1vh 5vw 1vh 5vw;
    display: flex;
    align-items: center;
    background-color: chocolate;
    color: white;
}

.myPosition {
    display: flex;
}

.Aposition {
    font-size: 12px;
}

.Allserch {
    position: absolute;
    right: 5vw;
}

.searchInp {
    width: 30vw;
    height: 4vh;
    border-radius: 2vh;
    border: 1px solid rgb(190, 190, 230);
    padding: 0 3vw 0 3vw;
    box-sizing: border-box;
}

.searchButton {
    width: 20vw;
    height: 4vh;
    border-radius: 2vh;
    border: 0;
    background-color: rgb(24, 199, 77);
    color: rgb(0, 0, 0);
}

.swiper {
    width: 100vw;
    box-sizing: border-box;
    display: flex;
    flex-shrink: 0;
    overflow: hidden;
}

.swiperFor {
    width: 100vw;
    height: 50vw;
    display: flex;
    flex-shrink: 0;
    box-sizing: border-box;
}

.swiperFor img {
    width: 100vw;
    height: 50vw;
}

.imgButton {
    width: 100vw;
    display: flex;
    justify-content: center;
    position: absolute;
    transform: translateY(calc(46vw - 4px));
}

.imgItem {
    width: 4px;
    height: 4px;
    border-radius: 2px;
    margin: 0 1vw 0 1vw;
    background-color: rgba(0, 0, 0, 0.7);
}

.menusDisplay {
    width: 100vw;
    display: flex;
    flex-wrap: wrap;
    flex-shrink: 0;
}

.oneMenu {
    width: 20vw;
    display: flex;
    flex-wrap: wrap;
    font-size: 8px;
    justify-content: center;
    margin: 8px 0 8px 0;
    box-sizing: border-box;
}

.oneMenu img {
    width: 13vw;
    height: 13vw;
    margin: 3.5vw 3.5vw 0 3.5vw;
}

.swiperImg {
    transition: 400ms;
}

.ShopList {
    clear: both;
    width: 100vw;
    box-sizing: border-box;
    margin: 0 0 10vh 0;
    padding: 0 5vw 0 5vw;
}

.Ashop {
    height: 10vh;
    display: flex;
    box-sizing: border-box;
    margin: 1vh 0 1vh 0;
    line-height: 3vh;
    font-size: 2vh;
    border-radius: 3vw;
    overflow: hidden;
    background-color: rgba(117, 233, 194, 0.3);
}

.rightShopMes p {
    margin: 0;
}

.shopMes {
    display: flex;
    margin: 1vh 0 0 0;
}

.shopTitle {
    line-height: 4vh;
    font-size: 2.5vh;
    font-weight: 600;
}

.shopPrice {
    margin: 0 2vw 0 0;
    line-height: 3vh;
    font-size: 2.3vh;
    font-weight: 800;
    color: red;
}

.shopMarket {
    margin: 0 2vw 0 2vw;
    line-height: 3vh;
    font-size: 2vh;
    font-weight: 600;
    color: gray;
    text-decoration: line-through;
}

.shopImg {
    width: 30vw;
    height: 10vh;
}

.rightShopMes {
    padding: 0.3vh 3vw 0.3vh 3vw;
}

.tuijianTitle {
    margin: 2vh 0 2vh 0;
    height: 4vh;
    padding: 0.5vh 5vw 0.5vh 5vw;
    box-sizing: border-box;
    line-height: 3vh;
    font-size: 2.8vh;
}

.tuijianButton {
    float: right;
}

.tuijianMes {
    float: left;
}
</style>