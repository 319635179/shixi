<template>
    <div class="footer">
        <div class="border"></div>
        <div class="footerBody">
            <div class="footerItem" @click="routerTo('home')">
                <el-icon style="transform: scale(1.3) translateY(1vh);">
                    <HomeFilled />
                </el-icon>
                <div class="ItemMes">首页</div>
            </div>
            <div class="footerItem" @click="routerTo('classify')">
                <el-icon style="transform: scale(1.3) translateY(1vh);">
                    <Operation />
                </el-icon>
                <div class="ItemMes">分类</div>
            </div>
            <div class="footerItem" @click="routerTo('shoppingBag')">
                <el-icon style="transform: scale(1.3) translateY(1vh);">
                    <ShoppingBag />
                </el-icon>
                <div class="ItemMes">购物车</div>
            </div>
            <div class="footerItem" @click="routerTo('myMes')">
                <el-icon style="transform: scale(1.3) translateY(1vh);">
                    <UserFilled />
                </el-icon>
                <div class="ItemMes">我的</div>
            </div>
        </div>
    </div>
</template>

<script>
import router from '@/router';


export default {
    name: 'FooterCom',
    setup() {

        const routerTo = to => {
            router.push({ name: to });
        }

        return {
            routerTo
        }
    }
}

</script>

<style scoped>
.footer {
    width: 100vw;
    height: 9vh;
    background-color: white;
    position: fixed;
    bottom: 0px;
}

div.border {
    width: 100vw;
    height: 1px;
    background-color: gray;
    transform: scale(1, 0.2);
}

.footerBody {
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: space-around;
    color: darkred;
}

.footerItem {
    width: 25vw;
    height: 100%;
    display: flex;
    flex-wrap: wrap;
    flex-shrink: 0;
    align-items: center;
    justify-content: center;
}

.ItemMes {
    width: 100%;
    font-size: 14px;
    display: flex;
    justify-content: center;
    align-items: center;
}
</style>