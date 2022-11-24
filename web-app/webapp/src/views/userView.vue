<template>
    <div class="userView">
        <div class="userBackGround"></div>
        <div class="userViewTop">
            <div class="el-icon-s-comment"></div>
            <div class="el-icon-s-tools"></div>
            <div class="el-icon-camera-solid"></div>
        </div>
        <div class="userMessage">
            <div class="userNameMes">
                <div class="userImg"><img src="https://cdn.acwing.com/media/user/profile/photo/83205_lg_7618323e8a.jpg"
                        alt=""></div>
                <div class="userMes">
                    <div class="userName">UserName</div>
                    <div class="userId">账号ID：464354186</div>
                </div>
            </div>
            <div class="userOwnerWalfare">
                <div class="userVip">
                    <div><img src="@/assets/P9ZPO[ZTSX0DLDS4QDR78B0.png" style="height: 2vh"> UP会员专享</div>
                    <div>
                        <div>会员折上折</div>
                        <div>120元月享礼</div>
                    </div>
                </div>
                <div class="userWalfare">
                    <div>引领者</div>
                    <div>快来领福利!</div>
                </div>
            </div>
            <div class="userHistory">
                <div class="HistoryMes">
                    <div>6</div>
                    <div>收藏</div>
                </div>
                <div class="BreakUp"></div>
                <div class="HistoryMes">
                    <div>43</div>
                    <div>浏览记录</div>
                </div>
                <div class="BreakUp"></div>
                <div class="HistoryMes">
                    <div>￥0.00</div>
                    <div>我的红包</div>
                </div>
                <div class="BreakUp"></div>
                <div class="HistoryMes">
                    <div>10</div>
                    <div>优惠券</div>
                </div>
            </div>
            <div class="userForm">
                <div class="formTitle">
                    <div class="myFrom1">我的订单</div>
                    <div class="myFrom2">全部订单<span class="el-icon-arrow-right"></span></div>
                </div>
                <div class="formMes">
                    <div>
                        <div class="formMesImg"><img
                                src="https://cdn.acwing.com/media/user/profile/photo/83205_lg_7618323e8a.jpg" alt="">
                        </div>
                        <div class="formMesCou">待付款</div>
                    </div>
                    <div>
                        <div class="formMesImg"><img
                                src="https://cdn.acwing.com/media/user/profile/photo/83205_lg_7618323e8a.jpg" alt="">
                        </div>
                        <div class="formMesCou">待收货</div>
                    </div>
                    <div>
                        <div class="formMesImg"><img
                                src="https://cdn.acwing.com/media/user/profile/photo/83205_lg_7618323e8a.jpg" alt="">
                        </div>
                        <div class="formMesCou">评价</div>
                    </div>
                    <div>
                        <div class="formMesImg"><img
                                src="https://cdn.acwing.com/media/user/profile/photo/83205_lg_7618323e8a.jpg" alt="">
                        </div>
                        <div class="formMesCou">退款/售后</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="userPower">
            <div class="PowerMes">
                <div class="formMesImg"><img
                        src="https://cdn.acwing.com/media/user/profile/photo/83205_lg_7618323e8a.jpg" alt="">
                </div>
                <div class="formMesCou">我的资产</div>
            </div>
            <div class="PowerMes">
                <div class="formMesImg"><img
                        src="https://cdn.acwing.com/media/user/profile/photo/83205_lg_7618323e8a.jpg" alt="">
                </div>
                <div class="formMesCou">用户投诉</div>
            </div>
            <div class="PowerMes">
                <div class="formMesImg"><img
                        src="https://cdn.acwing.com/media/user/profile/photo/83205_lg_7618323e8a.jpg" alt="">
                </div>
                <div class="formMesCou">分期购物</div>
            </div>
            <div class="PowerMes">
                <div class="formMesImg"><img
                        src="https://cdn.acwing.com/media/user/profile/photo/83205_lg_7618323e8a.jpg" alt="">
                </div>
                <div class="formMesCou">品味社区</div>
            </div>
            <div class="PowerMes">
                <div class="formMesImg"><img
                        src="https://cdn.acwing.com/media/user/profile/photo/83205_lg_7618323e8a.jpg" alt="">
                </div>
                <div class="formMesCou">官方客服</div>
            </div>
            <div class="PowerMes">
                <div class="formMesImg"><img
                        src="https://cdn.acwing.com/media/user/profile/photo/83205_lg_7618323e8a.jpg" alt="">
                </div>
                <div class="formMesCou">用户钱包</div>
            </div>
            <div class="PowerMes">
                <div class="formMesImg"><img
                        src="https://cdn.acwing.com/media/user/profile/photo/83205_lg_7618323e8a.jpg" alt="">
                </div>
                <div class="formMesCou">补贴会场</div>
            </div>
            <div class="PowerMes">
                <div class="formMesImg"><img
                        src="https://cdn.acwing.com/media/user/profile/photo/83205_lg_7618323e8a.jpg" alt="">
                </div>
                <div class="formMesCou">有奖调研</div>
            </div>
        </div>
        <div class="shopView">
            <div class="ViewImg"><img src="@/assets/shopImg/P)0@[1767DW6E{4~MTQ}2GU.png" alt=""></div>
            <div class="moreShop">
                <div class="moreShopTitle">为你推荐</div>
                <div class="moreShopMes"></div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'UserView',
    data() {
        return {

        }
    },
    mounted() {
    }
}

</script>

<style scoped>
* {
    box-sizing: border-box;
}

/* @media(max-width: 644px) { */
.userView {
    padding: 0 3vw 0 3vw;
    box-sizing: border-box;
    position: fixed;
    top: 0;
    height: 91vh;
    overflow: auto;
    background-color: whitesmoke;
}

.userBackGround {
    width: 100vw;
    height: 24vh;
    position: absolute;
    top: 0;
    left: 0;
    z-index: -1;
    background-image: linear-gradient(to bottom right, #FAD7B9, #F7C090);
}

.userViewTop {
    width: 100%;
    height: 6vh;
    display: flex;
    flex-direction: row-reverse;
    align-items: center;
    z-index: 89;
}

.userViewTop>div {
    margin: 0 0 0 2vw;
    font-weight: 800;
}

.userNameMes,
.userMessage {
    width: 100%;
    z-index: 89;
}

.userNameMes {
    display: flex;
}

.userImg {
    width: 10vh;
    height: 10vh;
}

.userImg,
.HistoryMes>div {
    display: flex;
    justify-content: center;
    align-items: center;
}

.userImg>img {
    width: 80%;
    height: 80%;
    border-radius: 50%;
}

.userMes {
    width: calc(94vw - 10vh);
    padding: 1vh 3vw;
    color: rgb(110, 46, 0);
}

.userName {
    height: 5vh;
    line-height: 5vh;
    font-size: 2.3vh;
    font-weight: 600;
}

.userId {
    height: 3vh;
    line-height: 3vh;
    font-size: 1.5vh;
    color: rgb(145, 60, 0);
}

.userOwnerWalfare {
    width: 100%;
    height: 8vh;
    margin-top: 4vh;
    display: flex;
}

.userVip {
    width: 59%;
    height: 100%;
    margin-right: 1%;
    border-radius: 5px;
    background-image: linear-gradient(to right, rgb(42, 76, 122), rgb(15, 36, 65));
    padding: 1vh 3vw;
}

.userWalfare {
    width: 39%;
    height: 100%;
    margin-left: 1%;
    border-radius: 5px;
    background-image: linear-gradient(to right, rgb(128, 75, 41), rgb(51, 24, 7));
    padding: 1vh 3vw;
}


.userVip>div:nth-child(1) {
    color: rgb(253, 214, 175);
    height: 3vh;
    font-size: 2vh;
}

.userVip>div:nth-child(1),
.userVip>div:nth-child(2)>div,
.userWalfare>div:nth-child(1),
.userHistory {
    display: flex;
    align-items: center;
}

.userVip>div:nth-child(2) {
    display: flex;
    height: 3vh;
    font-size: 1.5vh;
    align-items: center;
    color: whitesmoke;
}

.userVip>div:nth-child(2)>div {
    width: 48%;
}

.userVip>div:nth-child(2)>div:nth-child(1) {
    margin-right: 4%;
    border-right: 1px solid gray;
}

.userWalfare>div:nth-child(1) {
    color: rgb(253, 214, 175);
    height: 3vh;
    font-size: 2vh;
}

.userWalfare>div:nth-child(2) {
    display: flex;
    height: 3vh;
    font-size: 1.5vh;
    align-items: center;
    color: whitesmoke;
}

.userHistory {
    width: 100%;
    height: 10vh;
    justify-content: space-around;
}

.BreakUp {
    width: 1px;
    height: 3vh;
    border-left: 1px solid gray;
}

.HistoryMes {
    width: calc((100% - 3px) / 4);
    display: flex;
    flex-wrap: wrap;
    flex-shrink: 0;
    justify-content: center;
}

.HistoryMes>div {
    width: 100%;
}

.HistoryMes>div:nth-child(2) {
    font-size: 1.5vh;
    color: rgb(75, 75, 75);
}

.userForm {
    width: 100%;
    height: 16vh;
    background-color: white;
    border-radius: 5px;
    padding: 1vh 3vw;
}

.formTitle {
    width: 100%;
    height: 5.5vh;
    line-height: 4vh;
    display: flex;
    font-size: 2vh;
    font-weight: 800;
    /* align-items: center; */
}

.myFrom2 {
    position: absolute;
    right: 6vw;
    font-size: 1.5vh;
    color: rgb(80, 80, 80);
    font-weight: 400;
}

.formMes {
    width: 100%;
    height: 8.5vh;
    display: flex;
    justify-content: space-around;
}

.formMes>div {
    width: 25%;
    height: 100%;
    display: flex;
    flex-shrink: 0;
    flex-wrap: wrap;
    justify-content: center;
}

.formMesImg {
    width: 100%;
    height: 5vh;
    display: flex;
    justify-content: center;
}

.formMesImg>img {
    height: 100%;
    border-radius: 50%;
}

.formMesCou {
    font-size: 1.5vh;
}

.userPower {
    margin-top: 1vh;
    width: 100%;
    height: 21vh;
    border-radius: 5px;
    background-color: white;
    padding: 2vh 3vw;
    display: flex;
    flex-shrink: 0;
    flex-wrap: wrap;
}

.PowerMes {
    width: 25%;
    display: flex;
    flex-shrink: 0;
    flex-wrap: wrap;
    justify-content: center;
}

.shopView {
    width: 100%;
    margin-top: 1vh;
    background-color: white;
    border-radius: 5px;
}

.ViewImg {
    width: 100%;
    height: 9vh;
}

.ViewImg>img {
    width: 100%;
    border-radius: 5px;
}

.moreShop {
    width: 100%;
}

.moreShopTitle {
    width: 100%;
    height: 4vh;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 2vh;
    font-weight: 800;
}

.moreShopMes {
    width: 100%;
    height: 300vh;
    margin-top: 1vh;
    margin-bottom: 1vh;
    border-radius: 5px;
    background-color: #F7C090;
}

/* } */
</style>