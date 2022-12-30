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
            <div class="Ashop" v-for="(shop, i) in ListData" :key="i">
                <img class="shopImg" :src="'http://localhost:3000' + shop.photoUrl" alt="">
                <div class="rightShopMes">
                    <div class="shopTitle" :style="shopStyle[i]">{{ shop.name }}</div>
                    <div class="shopMes">
                        <div class="shopPrice">{{ shop.price }}</div>
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
            ListData: [],
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

        $.ajax({
            url: 'http://localhost:3000/query/goods',
            type: 'get',
            headers: {
                Authorization: "Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIzMDRiZmRmNzUzODc0NjcyYTYxMzc4N2YzNzI5ZDMzZCIsInN1YiI6ImQ5ZTA1MGM2LTY2MjQtNDA4Mi05ODhlLTE1YTY2NTM0ZWQ4YiIsImlzcyI6InNnIiwiaWF0IjoxNjcyMTIyNzQ4LCJleHAiOjE2NzMzMzIzNDh9.tWlavx9BaH_JEGNRIwY43Hw5OyOOuYSjVrUVXBiiq7U",
            },
            success: (resp) => {
                this.ListData = resp.data;
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